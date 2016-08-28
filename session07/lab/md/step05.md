#View Users Coffee Locations

The last step in this lab involves displaying the users coffees on the map, along with the users location (which was the last step) so we need to modify a few classes here, namely

- MapFragment
- AddFragment
- EditFragment

###MapFragment

Here we need to inspect our list of coffees and (using the longitude and latitude coordinates) place a marker on the map indicating the location of each coffee.

So, first, open up your MapFragment class and add the following method

~~~java
public void addCoffees(List<Coffee> list){ 
    for(Coffee c : list) 
        getMap().addMarker(new MarkerOptions() 
            .position(new LatLng(c.marker.coords.latitude, c.marker.coords.longitude)) 
            .title(c.name + " €" + c.price) 
            .snippet(c.shop + " " + c.address)                 
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.coffee)));
}
~~~

To ensure our list of coffees is up to date and the most recent one, the MapFragment class needs to implement the VolleyListener interface, so go ahead and complete that now.

Once you've implemented the necessary methods, add a call to **_addCoffees()_** in your **_setList()_** method.

Now, add the following APi call to your **_onConnected()_**  

~~~java
CoffeeApi.attachListener(this);
CoffeeApi.getAll("/coffees/" + Base.googleToken, null);
~~~

and this to your **_onStop()_**

~~~java
CoffeeApi.detachListener();
~~~



---

###AddFragment

zzzz

---

###EditFragment

zzzz


