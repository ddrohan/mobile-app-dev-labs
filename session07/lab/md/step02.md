#Obtaining your Google Maps Key

First of all, you need to visit [Get an API Key](https://developers.google.com/maps/documentation/android-api/signup) on the Android Developer site as it contains all the info you need to obtain your Key. You'll have some of the work done already (from the previous lab) but there's still a bit of work to do, so if you get stuck just ask!

Once you have your key, the next thing to do is add the following to your strings.xml

```
<string name="title_map">Map</string>
<string name="google_maps_key">abcdefghijklmnopetcetcetc</string>
```

where 'abcdefghijklmnopetcetcetc' is your API Key.

Next, open up your manifest file and add the following just before the **closing** "application" tag

```
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="@string/google_maps_key" />
```

Also, in your manifest file add the following permissions

```
<uses-permission android:name="ie.cm.permission.MAPS_RECEIVE"/>

```

and the following dependencies to you build.gradle

```
compile 'com.google.android.gms:play-services-maps:8.1.0'
compile 'com.google.android.gms:play-services-location:8.1.0'
```

Then, go ahead and create a new **Empty Activity** but name the Layout **_fragment_map_** - this is important as we will be disgarding the activity in the next step but retaining the layout - we are just using it here to confirm we have configured our key etc. correctly.

![](/session07/lab/img/lab0701.png)

now add the following to the layout

```
<fragment android:name="com.google.android.gms.maps.MapFragment" 
        android:id="@+id/map" 
        android:layout_width="match_parent" 
        android:layout_height="match_parent"/>

```

Finally, (for this step) add the following to your Home Activity, to temporarily handle launching our new Map activity, if the user selects the menu option.

```
else if (id == R.id.nav_map) { 
startActivity(new Intent(this, Map.class));
}

```
Run your app and select "View on Map"

![](/session07/lab/img/lab0702.png)

and if everything goes according to plan, you should get

![](/session07/lab/img/lab0703.png)


Congratulations - you can now go ahead and build map based apps!
