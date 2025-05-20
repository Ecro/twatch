# Gesture Demonstration Screens - Design Requirements

This document outlines the requirements and considerations for designing the screens that demonstrate the four scoring gestures (15, 30, 40, Game) within the Gesture Scoreboard tutorial (Task 1.2).

## Requirements for Each Gesture Demonstration:

1.  **Clear Visual Representation:** Provide a clear visual demonstration of the specific wrist movement required for the gesture.
    *   **Deliverable:** Specify whether this will be an animation, illustration, or short video clip.
    *   **Consideration:** How will this be optimized for the circular Wear OS display?

2.  **Accurate Motion:** The demonstration must accurately represent the motion that the IMU pattern recognition model (Task 5) is designed to detect.
    *   **Consideration:** Close coordination with Task 5 implementation will be needed.

3.  **Concise Instruction:** Accompany the visual demonstration with brief, easy-to-understand text instructions for performing the gesture.
    *   **Consideration:** Text length limitations on a small screen.

4.  **Looping Demonstration:** The visual demonstration should loop or be easily repeatable by the user until they indicate readiness to move on.

5.  **Gesture Name/Score Display:** Clearly show which gesture/score is being demonstrated (e.g., "15 Points").

6.  **Navigation:** Provide clear navigation options to move to the next gesture demonstration, repeat the current one, or go back.
    *   **Consideration:** Consistency with overall tutorial navigation (Task 1.4).

## Considerations for All Gesture Demonstration Screens:

*   **Visual Consistency:** Maintain a consistent visual style with the welcome/introduction screens (Task 1.1) and the overall visual design system (Task 1.5).
*   **Performance:** Ensure animations or video clips are optimized for smooth playback and minimal battery impact on the watch.
*   **Accessibility:** Consider users with visual impairments and how the gesture can be explained or demonstrated through alternative means if necessary.
*   **Loading States:** How will loading states for animations or video be handled?

## Potential Deliverables for this Subtask:

*   Wireframes or mockups of each gesture demonstration screen.
*   Specifications for animations or illustrations (e.g., duration, keyframes, file format).
*   Draft text content for instructions.
*   Notes on interaction and navigation within these screens. 