# Setting Up Google+ Sign-in

As previously mentioned, we now want our CoffeeMate App to interact with a sister Web App (<a href="http://coffeemateweb.herokuapp.com">CoffeeMateWeb</a>) so we need <b>Google+ Sign-in</b> support to allow us to connect to the Web App and Add/Edit/Delete/View Coffees stored on the Server.

What we want is something like this:

The user launches the app and (after a Splash Screen) is prompted to login, like so

![](../img/lab0602.png)

If the user hasn't previously logged in, they will be asked to choose an existing Account, or add a different account (that's what we'll do here)

![](../img/lab0603.png)

The user is then prompted for their Google credentials

![](../img/lab0604.png)

![](../img/lab0605.png)

and then the app asked for certain permissions

![](../img/lab0606.png)

The additional account can now be chosen as the active Google account in the app 

![](../img/lab0607.png)

and we can display the users Google Profile pic, and email in the Navigation Drawer like so

![](../img/lab0608.png)

<hr>

Before you can start integrating Google+ features in your own app, you must create a <b><i>Google Developers Console project</i></b> and initialize the <b>GoogleApiClient</b> within your app.

###Ste p 1: Add Google Sign-In

Before you begin using Google+ in your Android app, follow all of the steps to <a href="https://developers.google.com/identity/sign-in/android/start-integrating">Start Integrating Google Sign-In into your Android App</a>.

Step 2: Enable the Google+ API
If you followed the steps above to add Google Sign-In to your app, you have already created a project in Google Developers Console. Now enable the Google+ API for that project to access Google+ features.
Go to the Google Developers Console APIs library .
From the project drop-down, select the project you previously created.
In the list of Google APIs, search for the Google+ API service.
Select Google+ API from the results list.
Select Enable API.
When the process completes, Google+ API appears in the list of enabled APIs. To access, select API Manager on the left sidebar menu, then select the Enabled APIs tab.



