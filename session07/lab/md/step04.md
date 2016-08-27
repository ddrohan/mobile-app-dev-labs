#View Users Current Location - Part II

The previous step was mostly about adding in a lot of boilerplate code to our Fragment, to get things moving - a lot of which you would have seen in the lecture material that covers Location and Google Maps.

This step adds a bit more of that, but also adds some bespoke code specific to CoffeeMate and its features.

Firstly, edit your <b>MapsFragment</b> and add/replace the following methods


~~~java
protected void startLocationUpdates() { 
    mLocationRequest = new LocationRequest();
    mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY); 
    mLocationRequest.setInterval(UPDATE_INTERVAL); 
    mLocationRequest.setFastestInterval(FASTEST_INTERVAL); 

    try { 
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this); 
    } 
    catch(SecurityException se) { 
        Toast.makeText(getActivity(),"Check Your Permissions on Location Updates",Toast.LENGTH_SHORT).show(); 
    }
  }

public void onLocationChanged(Location location) { 
// Report to the UI that the location was updated 
String msg = "Updated Location: " + Double.toString(location.getLatitude()) + "," + Double.toString(location.getLongitude()); 
Log.v("coffeemate", "onLocationChanged() = " + msg); 
mCurrentLocation = location; initCamera(mCurrentLocation);
}
~~~

And make sure you call startLocationUpdates() in your onConnected()

Now, add the following permission to your manifest file

~~~xml

~~~

and run your app again.


~~~java
<activity android:name="ie.cm.activities.Nearby"></activity>
~~~

While you're working with the manifest file, take a moment to examine all the permissions necessary for location features in the app - this can commonly throw up errors if you don't have the necessary permissions set when requesting certain features. Also, note the following:

~~~java
<activity android:name="ie.cm.activities.Map"
            android:configChanges="orientation|screenSize">
</activity>
~~~

This forces the Map <b>NOT</b> to be recreated if the orientation changes, which should only be used as a last resort, but does ensure our app won't crash on a screen change. (Not my best work!!, but it is due to known google map v2 issues :-D)

Now, if you run the app again, and select 'Nearby', you should see the following (which you can swipe between):

![](../img/lab705.png)      ![](../img/lab706.png)

Carry out some testing, and see if you can find a bug in the app, related to syncing between the list and the map in the ViewPager.