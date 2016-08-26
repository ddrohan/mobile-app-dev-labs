#Adding 'Swipe' Features - Using a ViewPager widget

This step involves the use of the remaining classes in our [mapresources](../archives/mapresources.zip) so add <b>CoffeePagerAdapter.java</b> and <b>NearbyListAdapter.java</b> to the <i>ie.cm.coffeeadapters</i> package, add <b>Nearby.java</b> to the <i>ie.cm.activities</i> package and add <b>NearbyPageFragment.java</b> and <b>NearbyFragment.java</b> to the <i>ie.cm.fragments</i> package.

Once again, have a look through the classes you've just added to the project, as they demonstrate the use of 'custom' swipe features and the use of 'nested' fragments. These classes are all wired up already, so you just need to ensure that when 'Nearby' is selected, the Nearby (swipe) page is loaded.

Firstly, edit your <b>Home.java</b> and make sure the correct 'screen' is loaded, like so:

~~~java
  public void nearby(View v) {
      goToActivity(this, Nearby.class, null);
  }
~~~

Next, make sure this new class is referenced in the manifest file:

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