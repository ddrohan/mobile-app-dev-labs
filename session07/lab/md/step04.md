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

~~~java
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
~~~

and run your app again (and remember to accept these new permissions).

![](/session07/lab/img/lab0710.png)

You should now see something like this, 

![](/session07/lab/img/lab0706.png)

but now when you send new coordinates to the emulator, you should see the 'blue dot' move to that new location, as below

![](/session07/lab/img/lab0709.png)

![](/session07/lab/img/lab0707.png)

![](/session07/lab/img/lab0708.png)

