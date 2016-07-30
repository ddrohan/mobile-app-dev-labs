# Adding a google+ Sign-in Screen

There's quite a lot of code \(relatively speaking\) to get this off the ground, so we'll use this step as more of a 'configuration' step, and hopefully once you've completed this, you'll be able to _**'Go Green'**_ on your own app :-\) \(Reduce,Reuse,Recycle my code\).

The first thing you need to do is introduce the following variables into your **Base** class

```
/* Client used to interact with Google APIs. */
public static GoogleApiClient mGoogleApiClient;

public static boolean signedIn = false;
public static String googleToken;
public static String googleName;
public static String googleMail;
public static String googlePhotoURL;
public static Bitmap googlePhoto;
public static int drawerID = 0;
```

and the following method

```
public void logout(MenuItem item) 
    { 
    Log.v("coffeemate","Logging out from: " + mGoogleApiClient); 
    Base.signedIn = mGoogleApiClient.isConnected(); 
        if (Base.signedIn) 
        { 
        Log.v("coffeemate","Logging out from: " + mGoogleApiClient); 
        Plus.AccountApi.clearDefaultAccount(mGoogleApiClient); 
        mGoogleApiClient.disconnect(); 
        Base.googleToken = ""; 
        Base.signedIn = mGoogleApiClient.isConnected(); 
        mGoogleApiClient.connect(); 
        Log.v("coffeemate","googleClient Connected: " + Base.signedIn); 
        Toast.makeText(this, "Signing out of Google", Toast.LENGTH_LONG).show(); 
        Log.v("coffeemate", "CoffeeMate App Terminated"); 
        } 

    startActivity(new Intent(Base.this, Login.class) 
        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }
```

Then, bring in the following resources into your own CoffeeMate project \(and store in the relevant folders\) and fix\/import any errors. You may need to revisit the Nav Drawer layout to rename some widgets.

* **Login** Activity \(in package _**ie.cm.activities**_\)
* **activity\_login** Layout \(in _**res\/layout**_\)

Also, just confirm that you have the following permissions in your manifest file

```
<uses-permission android:name="android.permission.INTERNET" />
```

Next, bring in a 'Logout' Option in your Menu, like so

```
<item    
    android:id="@+id/menu_logout"    
    android:title="Logout"    
    android:orderInCategory="100"    
    app:showAsAction="never"    
    android:onClick="logout"/>
```

