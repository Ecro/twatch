package com.example.watch.ui.tutorial.animation

import org.junit.Assert.assertEquals
import org.junit.Test

// The SyncPoint data class from the main source set is public, so it should be accessible here.
// If not, it would need to be replicated or made accessible.
// data class SyncPoint(val progress: Float, val text: String)

class AnimationDemoActivityTest {

    // Replicated SyncPoint list for testing (originally for R.drawable.avd_gesture_15)
    private val testSyncPoints1 = listOf(
        SyncPoint(0.0f, "Prepare for swipe up"),
        SyncPoint(0.4f, "Swipe up now!"),
        SyncPoint(0.8f, "Swipe complete")
    )

    // Replicated SyncPoint list for testing (originally for R.drawable.avd_gesture_40)
    // SyncPoint(0.0f, "Prepare for double flick"),
    // SyncPoint(0.3f, "First flick up!"),
    // SyncPoint(0.6f, "Second flick down!"),
    // SyncPoint(0.9f, "Double flick complete")
    private val testSyncPoints2 = listOf(
        SyncPoint(0.0f, "Prepare for double flick"),
        SyncPoint(0.3f, "First flick up!"),
        SyncPoint(0.6f, "Second flick down!"),
        SyncPoint(0.9f, "Double flick complete")
    )

    private val emptySyncPoints = emptyList<SyncPoint>()

    private fun findSyncPointText(syncPoints: List<SyncPoint>, progress: Float): String? {
        return syncPoints.lastOrNull { progress >= it.progress }?.text
    }

    @Test
    fun testSyncPointSelection_emptyList() {
        assertEquals(null, findSyncPointText(emptySyncPoints, 0.5f))
    }

    @Test
    fun testSyncPointSelection_list1_progressBeforeFirst() {
        // For testSyncPoints1, first point is at 0.0f.
        // Progress < 0.0f should result in null as no point has progress <= -0.1f
        assertEquals(null, findSyncPointText(testSyncPoints1, -0.1f))
    }

    @Test
    fun testSyncPointSelection_list1_progressAtFirst() {
        assertEquals("Prepare for swipe up", findSyncPointText(testSyncPoints1, 0.0f))
    }

    @Test
    fun testSyncPointSelection_list1_progressBetweenFirstAndSecond() {
        assertEquals("Prepare for swipe up", findSyncPointText(testSyncPoints1, 0.2f))
    }

    @Test
    fun testSyncPointSelection_list1_progressAtSecond() {
        assertEquals("Swipe up now!", findSyncPointText(testSyncPoints1, 0.4f))
    }

    @Test
    fun testSyncPointSelection_list1_progressBetweenSecondAndThird() {
        assertEquals("Swipe up now!", findSyncPointText(testSyncPoints1, 0.6f))
    }

    @Test
    fun testSyncPointSelection_list1_progressAtThird() {
        assertEquals("Swipe complete", findSyncPointText(testSyncPoints1, 0.8f))
    }

    @Test
    fun testSyncPointSelection_list1_progressAfterThird() {
        assertEquals("Swipe complete", findSyncPointText(testSyncPoints1, 0.9f))
    }

    @Test
    fun testSyncPointSelection_list1_progressFarAfterThird() {
        assertEquals("Swipe complete", findSyncPointText(testSyncPoints1, 1.0f))
    }

    // Tests for the second list
    @Test
    fun testSyncPointSelection_list2_progressAtFirst() {
        assertEquals("Prepare for double flick", findSyncPointText(testSyncPoints2, 0.0f))
    }

    @Test
    fun testSyncPointSelection_list2_progressBetweenFirstAndSecond() {
        assertEquals("Prepare for double flick", findSyncPointText(testSyncPoints2, 0.15f))
    }

    @Test
    fun testSyncPointSelection_list2_progressAtSecond() {
        assertEquals("First flick up!", findSyncPointText(testSyncPoints2, 0.3f))
    }

    @Test
    fun testSyncPointSelection_list2_progressBetweenSecondAndThird() {
        assertEquals("First flick up!", findSyncPointText(testSyncPoints2, 0.45f))
    }

    @Test
    fun testSyncPointSelection_list2_progressAtThird() {
        assertEquals("Second flick down!", findSyncPointText(testSyncPoints2, 0.6f))
    }
    
    @Test
    fun testSyncPointSelection_list2_progressBetweenThirdAndFourth() {
        assertEquals("Second flick down!", findSyncPointText(testSyncPoints2, 0.75f))
    }

    @Test
    fun testSyncPointSelection_list2_progressAtFourth() {
        assertEquals("Double flick complete", findSyncPointText(testSyncPoints2, 0.9f))
    }

    @Test
    fun testSyncPointSelection_list2_progressAfterFourth() {
        assertEquals("Double flick complete", findSyncPointText(testSyncPoints2, 1.0f))
    }
}
