#Adding a Login Screen

Now we'll add in a very basic level of security - we'll get the user to login before they can use the app. First thing to do is download the necessary resources in [loginresources](../archives/loginresources.zip) and add them to the relevant packages/folders in your project. 

(You can literally drag-and-drop the files into eclipse! <b>NOTE : Make sure you drop in the images first or you'll get a number of errors in your resources file</b>)

You may also get a resource error on the layout regarding a colour, so if you do, update your 'colors.xml' with the following

~~~java
 <color name="bar_black_text">#000000</color>
~~~

The Login Screen looks like this:

 ![](../img/lab504.png)

so modify your <b>Splash.java</b> to load this Screen before any other Screens.

If you now run the app and click the Login Button, you'll notice nothing happens, so the next thing to do is implement the <b><i>onClick()</i></b> event for this activity. The <i>SharedPreferences</i> are initially set up, so have a look at that, to see how it was done, to give you an idea on how to complete this step.

The solution is on the next step, but try and have a go at completing it before you take a look. To help you along you need to do the following:

- Grab the email and password entered (you should use a <i>CharSequence</i> object for this)

- Validate both for being empty and/or the correct combination (You can just hardcode in the correct details at this stage)

- Once the details are correct, update your SharedPreferences to say the user is logged in, and launch the correct activity.


