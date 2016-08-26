#Syncing our List and our Map

The last step in this lab involves fixing a small bug in the app - hopefully you've identified the situation where a coffee gets deleted from the list, but the map doesn't update until the activity is launched again.

What we need to do is notify the map that its data has changed and then force a refresh of the map. This is why we maintain a reference to the map in our <b>CoffeeFragment</b> like so:

~~~java
protected Fragment mapReference;
~~~

and can set it with:

~~~java
public void setMapReference(Fragment ref) {
		mapReference = ref;
	}
~~~

The map reference is actually set whenever the <b>NearbyPageFragment</b> Fragment is loaded/resumed and the <i>coffeeFragment</i> nested within it:

~~~java
@Override
	public void onResume() {
		super.onResume();

		activity.coffeeFragment = new SearchFragment();
		((CoffeeFragment) activity.coffeeFragment).setMapReference(mapReference);
		getChildFragmentManager().beginTransaction()
		.add(R.id.fragment_layout, activity.coffeeFragment).commit();
	}
~~~

So whenever the delete is called in the <i>coffeeFragment</i> we have a reference to the map, which we assigned when <b>NearbyPageFragment</b> was initially created, via a call to newInstance, like so:

~~~java
	public static Fragment newInstance(Fragment map) {
		NearbyPageFragment pageFragment = new NearbyPageFragment();

		mapReference = map;
		return pageFragment;
	}
~~~

Here's the final few lines of code necessary to refresh the map when a coffee is deleted while inside the <b>ViewPager</b>. This should be placed inside the <i>onCoffeeDelete()</i> method of the <b>CoffeeFragment</b> class.

~~~java
	if(mapReference != null) // We're inside the Nearby Fragment
		((MapPageFragment)mapReference).refreshMarkers();		
~~~

Test your app again to ensure the both the map and the list display consistant data after any deletes.
