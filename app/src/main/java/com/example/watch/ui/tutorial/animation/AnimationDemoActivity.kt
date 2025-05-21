package com.example.watch.ui.tutorial.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.watch.R

data class SyncPoint(val progress: Float, val text: String)

class AnimationDemoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_GESTURE_DRAWABLE_ID = "extra_gesture_drawable_id"

        // Define synchronization points for each gesture
        private val gestureSyncPoints = mapOf(
            R.drawable.avd_gesture_15 to listOf(
                SyncPoint(0.0f, "Prepare for swipe up"),
                SyncPoint(0.4f, "Swipe up now!"),
                SyncPoint(0.8f, "Swipe complete")
            ),
            R.drawable.avd_gesture_30 to listOf(
                SyncPoint(0.0f, "Prepare for swipe down"),
                SyncPoint(0.4f, "Swipe down now!"),
                SyncPoint(0.8f, "Swipe complete")
            ),
            R.drawable.avd_gesture_40 to listOf(
                SyncPoint(0.0f, "Prepare for double flick"),
                SyncPoint(0.3f, "First flick up!"),
                SyncPoint(0.6f, "Second flick down!"),
                SyncPoint(0.9f, "Double flick complete")
            ),
            R.drawable.avd_gesture_game to listOf(
                SyncPoint(0.0f, "Prepare for rotation"),
                SyncPoint(0.5f, "Rotate wrist"),
                SyncPoint(0.9f, "Rotation complete")
            )
        )
    }

    private lateinit var animationImageView: ImageView
    private lateinit var instructionTextView: TextView
    private var synchronizationAnimator: ValueAnimator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_demo)

        animationImageView = findViewById(R.id.animationImageView)
        instructionTextView = findViewById(R.id.instructionTextView)

        // Load the AnimatedVectorDrawable for the 15 point gesture
        // Get the drawable ID from the intent
        val gestureDrawableId = intent.getIntExtra(EXTRA_GESTURE_DRAWABLE_ID, 0)

        if (gestureDrawableId != 0) {
            val drawable = getDrawable(gestureDrawableId)

            if (drawable is AnimatedVectorDrawable) {
                animationImageView.setImageDrawable(drawable)

                // Create a ValueAnimator to track animation progress
                synchronizationAnimator = ValueAnimator.ofFloat(0f, 1f)
                synchronizationAnimator?.duration = drawable.intrinsicDuration.toLong() // Match duration

                synchronizationAnimator?.addUpdateListener {
                    val progress = it.animatedValue as Float
                    // Update text based on animation progress and gesture-specific sync points
                    val syncPoints = gestureSyncPoints[gestureDrawableId] ?: emptyList()
                    for (syncPoint in syncPoints) {
                        if (progress >= syncPoint.progress) {
                            instructionTextView.text = syncPoint.text
                        } else {
                            break // Assuming sync points are ordered by progress
                        }
                    }
                }

                // Attach a listener to update text when animation ends
                drawable.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationStart(animation: Animator) {
                        super.onAnimationStart(animation)
                        // Start the synchronization animator when the main animation starts
                        synchronizationAnimator?.start()
                        // Set initial text when animation starts
                        instructionTextView.text = gestureSyncPoints[gestureDrawableId]?.firstOrNull()?.text ?: "Watch the animation:"
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        // Stop or reset the synchronization animator
                        synchronizationAnimator?.cancel() // Or reset as needed
                        // Update text after animation finishes
                        instructionTextView.text = gestureSyncPoints[gestureDrawableId]?.lastOrNull()?.text ?: "Animation demonstrated!"
                    }
                })

                // Start the animation
                drawable.start()

            } else {
                // Handle error if drawable is not AnimatedVectorDrawable
                instructionTextView.text = "Error loading animation or no ID provided."
            }
        } else {
            // Handle error if drawable is not AnimatedVectorDrawable
            instructionTextView.text = "Error loading animation or no ID provided."
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Clean up the animator to prevent memory leaks
        synchronizationAnimator?.cancel()
        synchronizationAnimator = null
    }
} 