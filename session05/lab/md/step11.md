#Adding Database Support

Before we complete this step, here's the code you need for the previous step.

~~~java
@Override
  public void onClick(View arg0) {

    CharSequence email = ((TextView) findViewById(R.id.loginEmail))
        .getText();
    CharSequence password = ((TextView) findViewById(R.id.loginPassword))
        .getText();

    if (email.length() <= 0 || password.length() <= 0)
      Toast.makeText(this, "You must enter an email & password",
          Toast.LENGTH_SHORT).show();
    else if (!email.toString().matches("d")
        || !password.toString().matches("d"))
      Toast.makeText(this, "Unable to validate your email & password",
          Toast.LENGTH_SHORT).show();
    else if (!mIsBackButtonPressed) {
      // Validate User with Server Here

      // Update logged in preferences
      SharedPreferences.Editor editor = settings.edit();
      editor.putBoolean("loggedin", true);
      editor.commit();
      // start the home screen if the back button wasn't pressed already
      startHomeScreen();
      this.finish(); // destroy the Login Activity
    }
  }
~~~

Once you import the necessary Database classes, this step is relatively straight forward - all you have to do is replace the method calls that manages the <b><i>coffeeList</i></b> with the respective <b><i>dbManager</i></b> calls.

First thing to do is download the necessary database classes in the [database](../archives/database.zip) archive and add them to a new <i>ie.cm.db</i> package in your project.

Take a few moments to investigate the classes and familarise yourself with the methods you'll be using.

There are a number of classes you'll need to modify to add database support to your project, but initially, you need to create an instance of <b><i>DBManager</i></b> in <b>CofeeMateApp.java</b> and both open/close the database when necessary.

Our DBManager instance inside our Application Object

~~~java
  public class CoffeeMateApp extends Application
{
  //public List <Coffee>  coffeeList = new ArrayList<Coffee>();
  public DBManager  dbManager = new DBManager(this);

  @Override
  public void onCreate()
  {
    super.onCreate();
    Log.v("coffeemate", "CoffeeMate App Started");
    dbManager.open();
  }
  
  @Override
public void onTerminate() {
  super.onTerminate();
  dbManager.close();
  }
}
~~~

Once you make this change (and save the file) you'll get a number of errors, which actually indicates which classes you need to now update and add the database calls (and remove the coffeeList calls).

Each error requires only one line of code to be fixed, so have a go and updating each of the classes (and we'll have a look at the solution near the end of the Practical Lab).

Once you fix all the errors, and run the app again, (and successfully login!) you should see your coffee list - but this time those coffees are stored in a database.

And as a final check, if you call the <i>setupList</i> method of the <i>DBManager</i> reference in you CoffeeMateApp reference 'app' (replacing the existing setup method in 'Home') you should see the following list:

![](../img/lab505.png)
