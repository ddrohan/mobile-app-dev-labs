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

Because we're passing 'null' to our getAll() call, there's a small change you need to make in your CoffeeApi class - so see if you can work out what it is?


Once you have, add this to your **_onStop()_**

~~~java
CoffeeApi.detachListener();
~~~

Before you run your app, I'd suggest checking the Web App to confirm you have some coffees stored on the server and can view them on the Map in the Browser, so when you run your app, you know it's working correctly if you see your coffees - something like this

![](/assets/coffeemate.9.png)

---

###AddFragment

zzzz

---

###EditFragment

zzzz


