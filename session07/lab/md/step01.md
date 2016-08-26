#Setup - Starter Code

As with the previous labs, you can download the starter code for this lab here - [CoffeeMate.7.0.Starter](../archives/CoffeeMate.7.0.Starter.zip). It contains all the resources you'll need to complete this lab along with some of the code and the necessary helper classes.

To open this in eclipse, first extract the archive somewhere on our hard disk (preferably, your workspace). Then, in Eclipse, select 'File->Import' menu option, and in the dialog select 'Existing Projects into Workspace' (like you did in Lab 3)

Take a few moments to familiarise yourself with the new Activities and more importantly, the helper classes in your project and explore the resources that you will be referring to throughout the lab, especially the layouts in both 'Graphical Layout' view and 'XML' view. It's also probably a good idea to run the App at this stage too, so you can set up your AVD (if you haven't done so already) and confirm that the starter app is configured properly and running.

In this lab, you are required to do the following:

- Add Location awareness to the App (via the GPSTracker helper class)

- Add a Google Map, so the user can see their coffees displayed on a Map

- Add a ViewPager Activity screen, so the user can 'swipe' between the Search screen and the Map.

- Add Database Support to CoffeeMate to manage our coffees (already done!)

The following steps will guide you through these requirements, but before we can do anything with the Google Maps, you need to obtain your own Google Maps Key to add to your manifest file. 

 