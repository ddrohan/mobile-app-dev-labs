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

Before you can start integrating Google+ features in your own app, you must create a Google Developers Console project and initialize the <b>GoogleApiClient</b> within your app.



