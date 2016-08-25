# Google+ Integration - Searching a Coffee

At this Stage your CoffeeMate App should be able to View/Add/Delete & Update coffees, and view your favourite coffees (like before), all on the server.

Now, because we introduced a **SwipeRefreshLayout**, we need to make some modifications to our 'Search' option so you need to ensure that your **fragment_search** layout now has the following (around the ListView)

```
<android.support.v4.widget.SwipeRefreshLayout     
    android:id="@+id/coffee_swipe_refresh_layout" 
    android:layout_width="match_parent" 
    android:layout_height="107dp" 
    android:layout_alignParentStart="true" 
    android:layout_below="@+id/recentAddedBarTextView"     
    android:layout_alignParentBottom="true"> 

<ListView android:id="@+id/coffeeList" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent" 
    android:layout_gravity="right|bottom"> 
</ListView>

</android.support.v4.widget.SwipeRefreshLayout>
```
and in your Fragment you bind to the **SwipeRefreshLayout** and set it like so

```
mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.coffee_swipe_refresh_layout);
setSwipeRefreshLayout();
```

Run your app once again and make a few changes on the server and test out the swipe refresh to confirm you've completed this lab successfully - Well Done!