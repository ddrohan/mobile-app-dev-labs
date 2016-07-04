#Reusing Fragments - Filtering Favourite Coffees

As mentioned in the Lectures, a <i>ListView</i> supports filtering of elements via its adapter. In this step we will associate our custom filter (<b>CoffeeFilter.java</b>) with our <i>CoffeeFragment</i> so that we have the ability to filter this list whatever way we want, on any screen we want.

#Our Custom Filter - <b>CoffeeFilter.java</b>

First of all, familarise yourself with the (already supplied) <i>CoffeeFilter</i> class. Pay particular attention to the two methods that had to be implemented to actually filter the data and then 'publish' the results and make sure you understand what's going on. 

Next, have a look at the constructor 

~~~java
public CoffeeFilter(List<Coffee> originalCoffeeList, String filterText,
      CoffeeListAdapter adapter) {
    super();
    this.originalCoffeeList = originalCoffeeList;
    this.filterText = filterText;
    this.adapter = adapter;
  }
~~~

and see if you can create an instance called <i>coffeeFilter</i> inside our <i>CoffeeFragment</i> without referring to the notes.

#Filtering our Favourites

Once you have the filter set up, the next step is to call it's filter method correctly to filter out just the 'Favourite' coffees and display them in our list. To achieve this you'll need to call the following code (can you work out where it should go inside our <i>CoffeeFragment</i>?)

~~~java
if (getActivity() instanceof Favourites) {
      coffeeFilter.setFilter("favourites"); // Set the filter text field to 'favourites'
      coffeeFilter.filter(null); // Filter the data, but don't use any prefix
      listAdapter.notifyDataSetChanged(); // Update the adapter
    }
~~~

If you run the app again, and select the Favourites Button, you should now see just the 'Favourite' coffees, like so:

![](../img/lab0406.png)

Note that we didn't have to modify a single line of code in our <b>Favourites.java</b> Activity class.

Next we'll look at searching our coffees by name and/or type.

