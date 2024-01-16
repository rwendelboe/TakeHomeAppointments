## Task

Build the front end for a mobile web application that covers as many of the following as possible in the time allotted:

- Allows providers to submit times they’d like to work on the schedule.
- Allows clients to list available slots.
- Allows clients to reserve an available slot.
- Allows clients to confirm their reservation.

## Explination

Providers Tab:

- Allows providers to select a date and start/end times for their availability. The "Save" button, in this example, clears the data; in a real-world scenario, we would send this data to our backend. Due to time constraints, I didn't implement validation for date and time selection. In a production app, thorough validation would ensure the data meets our requirements before sending it to the backend. If the provider enters invalid date and time, the UI should display an appropriate message or warning.

Clients Tab:

- Enables clients to view available time slots from their provider. The client can tap a desired time slot, triggering a confirmation dialog for the appointment. The client can then confirm or cancel, dismissing the dialog and displaying a Toast message indicating the action taken. In a real-world scenario, this would involve validation against restrictions to ensure the appointment was successfully scheduled, and the UI would respond accordingly.

## Improvments

In an extended development timeframe, I would revamp the UI significantly. For the Clients UI, I'd integrate a Custom Calendar View, utilizing a library or building a my own solution. This calendar would highlight dates with available times, offering a clear visual cue to users. Upon selecting a date, the app would transition to a screen allowing users to swipe horizontally between dates at the top, while the rest of the screen accommodates a vertical scroll for a list of available times. Users can tap a time cell to initiate a confirmation view.

On the Providers UI, a similar approach would be implemented. The interface would feature a calendar view, enabling providers to navigate through each day, selecting and customizing their available time slots. This approach aims to optimize the user experience for both clients and providers by incorporating a more intuitive and visually appealing design.

