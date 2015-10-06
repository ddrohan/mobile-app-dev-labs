#First Android Project - "HelloWorld"

In Android Studio, select File->New->New Project, or if it's a first run, select "Start a new Android Studio Project"

![](../img/firstrun.png)

Press "Next" (or click the option) and then give the project a name: 'HelloWorld'

It's recommended you change the default package name also and it's probably worth changing the Project Location too but you can take the default for the moment.

![](../img/new01.png)

Select the Platform(s) you want your app to run on - we'll just stick with Phone & Tablet and choose an appropriate Minimum SDK.

![](../img/new02.png)

You should choose An Blank Activity as your activity type on the next screen

![](../img/activity.png)

and name it as in the screenshot below

![](../img/activity2.png)

After you press "Finish", you should now have something similar to the following:

![](../img/09.png)

Next, open up the AndroidManifest.xml file in Graphical View, select the 'Application' tab and change the 'Theme' to Theme.Holo.Light with Dark Action Bar, like below

![](../img/manifest1.png)

![](../img/manifest2.png)

Familiarise yourself with the project layout - the initial xml layout or "screen" is first displayed, this is one of the many resources you will be using and creating throughout this module. We will experiment later with modifying this layout, but first you should run the application.

Select the Project (HelloWorld)->Right-Mouse-Button->Run As->Android Application, as follows:

![](../img/run.png)

If you haven't done so already, you will be asked to select/create an AVD (Android Virtual Device), as follows:

![](../img/avd1.png)

and

![](../img/avd.png)

Use the settings as above and your first Android App should launch like so, (Once you've unlocked the device!):

![](../img/device.png)