# Practice Mode UI - Design Requirements

This document outlines the requirements and considerations for designing the user interface of the Practice Mode within the Gesture Scoreboard tutorial (Task 1.3).

## Key UI Elements and Interactions:

1.  **Gesture Prompt:** How will the UI visually or textually prompt the user to perform a specific gesture?
    *   **Consideration:** Clear and concise instructions on a small screen.

2.  **Real-time Visual Feedback:** Design immediate visual feedback after a gesture attempt.
    *   **Requirements:** Clear indication of Success (e.g., green checkmark) and Failure (e.g., red X, hint text).
    *   **Consideration:** Animation or visual effect duration should be short to maintain flow.

3.  **Haptic Feedback Indication (UI Aspect):** While haptics are implemented elsewhere, how does the UI inform the user about or explain the haptic feedback they will receive?
    *   **Consideration:** Maybe a brief on-screen message or icon associated with the haptic cue.

4.  **Attempt Tracking/Timing Display:** If the practice mode includes tracking attempts or a timer, how is this information displayed?
    *   **Consideration:** Display should be visible but not intrusive during gesture attempts.

5.  **Navigation:** Design controls for moving between practice gestures, repeating a gesture, or exiting practice mode.
    *   **Consideration:** Consistency with other tutorial navigation (Task 1.4).

6.  **Skip Practice Option:** Design the UI element for skipping the practice mode entirely.

## Overall Practice Mode UI Considerations:

*   **Visual Consistency:** Maintain consistency with the welcome (1.1), demonstration (1.2), and overall tutorial visual style (1.5).
*   **Responsiveness:** The UI should respond quickly to gesture attempts or user input.
*   **Clarity on Circular Display:** Optimize layout and element sizing for the circular Wear OS screen, avoiding elements being cut off by the bezel.
*   **Accessibility:** Ensure feedback and instructions are accessible.

## Potential Deliverables for this Subtask:

*   Wireframes or mockups showing the different states of the practice mode screens (prompting, success feedback, failure feedback).
*   Specifications for visual feedback animations/effects.
*   Draft text for prompts and feedback messages.
*   Notes on interaction design for practice attempts and navigation. 