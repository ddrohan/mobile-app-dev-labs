#The Application Object

In order to keep our application design coherent, we now bring in an 'Application' object.

Create a new package called 'ie.cm.main' and incorporate this class here:

~~~java
package ie.cm.main;

import ie.cm.models.Coffee;
import java.util.ArrayList;
import java.util.List;
import android.app.Application;
import android.util.Log;

public class CoffeeMateApp extends Application
{
  public List <Coffee>  coffeeList = new ArrayList<Coffee>();

  @Override
  public void onCreate()
  {
    super.onCreate();
    Log.v("coffeemate", "CoffeeMate App Started");
  }
}
~~~

Application objects need to be referenced in the AndroidManifest.xml - at the very top as 'andorid:name'

~~~xml
    <application
        android:allowBackup="true"
        android:icon="@drawable/ic_launcher"
        android:label="@string/app_name"
        android:theme="@style/AppTheme" 
        android:name="ie.cm.main.CoffeeMateApp">
~~~

Make sure the 'CoffeeMate App Started' appears in the logs to verify that it has actually been engaged correctly, when you launch the app.

As we now want our Appication Object to manage or list of coffees, we need to replace all references of the list from Base with a reference to our Application Object list.

The Base class will now look something like this

~~~java

...

public class Base extends Activity {

  public CoffeeMateApp  app; 
  protected Bundle    activityInfo;
  public Fragment     coffeeFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    app = (CoffeeMateApp) getApplication();
  }

...

~~~

You can then access the list of coffees via the Base class 'app' reference like so... 

Our refactored 'Add' 

~~~java

app.coffeeList.add(c);

~~~

See if you can refactor the rest of the affected classes.....
