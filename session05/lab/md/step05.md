#Adding a 'Logout' Menu Button

The last step in this lab involves adding a 'Logout' button to the menu, like so :

![](../img/lab506.png)

When you extracted the [loginresources](../archives/loginresources.zip) archive there was also a 'logout.png' image, so drop this into the drawable folder of the project.

Then go ahead and modify your <b>optionsmenu.xml</b> to add in the new menu option.

You should run the app again, just to confirm you can see the new menu with 4 options (including our logout button).

As this menu is available on all screens, we need to implement our logout functionality in <b>Base.java</b> so first, open this source file.

Next, copy in the following method

~~~java
private void logout() {
		SharedPreferences.Editor editor = getSharedPreferences("loginPrefs", 0)
				.edit();
		editor.putBoolean("loggedin", false);
		editor.commit();

		startActivity(new Intent(Base.this,Login.class)
		.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
		finish();
	}
~~~

and try and work out when and where this method should be called in <b>Base.java</b>.  You'll notice that we're starting a new Intent with some setting of 'Flags', so when you get to this part, we'll discuss it in class, but for the moment, assume we need them. (Can you maybe work out why??, it's related to the "<i>Achilles heel of Android</i>")

Once you've got this completed, run your app again and test to see if the logout button works as it should.

<b><i>As an experiment, remove any setting of "Flags" and see what happens when you logout, <u>and then hit the 'back button'</u></i></b>