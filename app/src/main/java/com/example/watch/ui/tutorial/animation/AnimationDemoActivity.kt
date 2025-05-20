package com.example.watch.ui.tutorial.animation

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.watch.R // Assuming R is in this package or adjust import

class AnimationDemoActivity : AppCompatActivity() {

    private lateinit var animationImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_demo)

        animationImageView = findViewById(R.id.animationImageView)

        // Load the AnimatedVectorDrawable
        val drawable = getDrawable(R.drawable.avd_fade_in_circle)

        if (drawable is AnimatedVectorDrawable) {
            animationImageView.setImageDrawable(drawable)
            // Start the animation
            drawable.start()
        } else {
            // Handle error if drawable is not AnimatedVectorDrawable
            // Log an error or show a static image
        }
    }
} 