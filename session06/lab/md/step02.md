#Understanding CoffeeMate.5.0


As previously mentioned, this lab is all about understanding how <b>CoffeeMate.5.0</b> works, so you'll be extensively debugging this version of the app and working out how the AsyncTask calls do what they do.

Initially run the app, to confirm that your app is connecting to the Web Service and retrieving the list of Coffees. 

<b>It's worth pointing out at this stage that this Web Service is working with a SHARED Database, so if anyone adds, edits or deletes a coffee from their app, everyone else should see the change</b>

So working in pairs or a group, just add in a few coffees, and tag them with your initials (eg. I'd name a coffee, coffeeDD) just so everyone doesn't try and delete or edit the same coffee at the same time!

Once, you've experimented with this process, the next thing to do is debug through the app and see what's going on. So add the following breakpoints at the following lines identified below:

![](../img/bp01.png)

![](../img/bp02.png)

![](../img/bp03.png)

![](../img/bp04.png)

![](../img/bp05.png)

![](../img/bp06.png)

![](../img/bp07.png)

When you've debugged through the classes & methods identified above, go ahead and experiment with some of the other methods, and enter breakpoints to investigate soem of the other web service calls.