# App Refactoring - Our 'Edit' Option \(Part 1\)

This step is similar to our 'Add' Fragment implementation but there's a bit more complexity involved as we need to

* Create a new Fragment \(**EditFragment**\) \(similar to Add\)
* Recycle the 'Edit' Layout for use with our new Fragment \(similar to Add\)

and

* Pass the relevant Coffee Data from the 'Coffee List' \(managed within the **CoffeeFragment**\) to the **EditFragment**

AND

* Implement a callback interface from our Fragment to our Activity to handle the 'favourites star' toggle and the update button.

**Note:** We could simply have our EditFragment implement an onClick Listener, but this is an opportunity to demonstrate how to communicate between a Fragment and an Activity.

So first of all, go ahead and create the Fragment \(and it's associated layout\) but this time, make sure you choose to **Include interface Callbacks**, like so .

![](/assets/lab509.png)

Then, modify the boilerplate code so that the **_newInstance\(\)_** method takes a 'Bundle' object \(called _coffeeBundle_\) as a parameter.

Now, our current _**onItemClick\(\)**_ method inside our CoffeeFragment, looks like this

```
@Override  public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
{    
Bundle activityInfo = new Bundle();    
activityInfo.putInt("coffeeID", view.getId());    

Intent goEdit = new Intent(getActivity(), Edit.class);
goEdit.putExtras(activityInfo);   
getActivity().startActivity(goEdit);  
}
```

so see if you can implement the necessary code to 'switch to' the EditFragment instead of launching the Edit activity \(We'll revist this code in Part 2 to complete the Edit feature\).

**Hint:** have a look at your **Home** activity and how we manage our Fragments.

---

Next, you need to update your layout, so again, have a go at that, but to help you along here's the layout I copied from our 'Add' and refactored to suit our needs.

```js
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="ie.cm.fragments.AddFragment">


    <RelativeLayout
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:layout_gravity="center_horizontal|bottom">

    <LinearLayout
        android:id="@+id/linearLayout1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:paddingBottom="5dp"
        android:paddingLeft="10dp"
        android:paddingRight="10dp"
        android:paddingTop="5dp" >

        <TableLayout
            android:id="@+id/tableLayout1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" >

            <TableRow
                android:id="@+id/tableRow1"
                android:layout_width="wrap_content"
                android:layout_height="0dp"
                android:layout_weight="1"
                tools:ignore="UselessParent" >

                <TextView
                    android:id="@+id/coffeeNameTextView"
                    android:text="The Title"
                    tools:ignore="HardcodedText"
                    android:layout_width="310dp"
                    android:textSize="24dp"
                    android:textColor="@color/colorPrimary"
                    android:layout_marginLeft="5dp" />

                <ImageView
                    android:id="@+id/favouriteImageView"
                    android:layout_width="40dp"
                    android:layout_height="40dp"
                    android:src="@drawable/ic_favourite_off"
                    tools:ignore="ContentDescription"
                    android:onClick="toggle" />

            </TableRow>
        </TableLayout>

        <TextView
            android:id="@+id/coffeeShopTextView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="The Description..."
            android:textColor="@color/bannerBGColor"
            tools:ignore="HardcodedText"
            android:textSize="18dp"
            android:layout_marginLeft="5dp" />

    </LinearLayout>


        <TextView
            android:id="@+id/barTextView"
            style="@style/banner"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/coffeeDetailsLbl"
            android:layout_below="@+id/linearLayout1"
            android:layout_alignParentStart="true" />

        <RatingBar
            android:id="@+id/coffeeRatingBar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:numStars="5"
            android:rating="2"
            android:stepSize="1"
            android:progressTint="@color/bannerBGColor"
            android:layout_above="@+id/updateCoffeeBtn"
            android:layout_centerHorizontal="true" />

        <EditText
            android:id="@+id/nameEditText"
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="textShortMessage"
            android:layout_below="@+id/barTextView"
            android:layout_alignStart="@+id/shopEditText">

            <requestFocus />

        </EditText>

        <EditText
            android:id="@+id/shopEditText"
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="textShortMessage"
            android:layout_alignTop="@+id/shopTextView"
            android:layout_alignEnd="@+id/coffeeRatingBar">
        </EditText>

        <TextView
            android:id="@+id/ratingTextView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/coffeeRatingLbl"
            android:textColor="@color/appFontColor"
            android:textSize="18sp"
            android:layout_above="@+id/coffeeRatingBar"
            android:layout_alignStart="@+id/priceTextView" />

        <TextView
            android:id="@+id/nameTextView"
            android:layout_width="60dp"
            android:layout_height="20dp"
            android:gravity="top"
            android:text="@string/coffeeNameLbl"
            android:textColor="@color/appFontColor"
            android:textSize="18sp"
            android:layout_below="@+id/barTextView"
            android:layout_toStartOf="@+id/nameEditText"
            android:layout_marginTop="2dp" />

        <EditText
            android:id="@+id/priceEditText"
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="numberDecimal"
            android:layout_below="@+id/shopEditText"
            android:layout_alignStart="@+id/shopEditText" />

        <TextView
            android:id="@+id/shopTextView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/coffeeShopLbl"
            android:textColor="@color/appFontColor"
            android:textSize="18sp"
            android:layout_below="@+id/nameEditText"
            android:layout_alignStart="@+id/nameTextView" />

        <TextView
            android:id="@+id/priceTextView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/coffeePriceLbl"
            android:textColor="@color/appFontColor"
            android:textSize="18sp"
            android:layout_alignTop="@+id/priceEditText"
            android:layout_alignStart="@+id/shopTextView" />

        <Button
            android:id="@+id/updateCoffeeBtn"
            style="@android:style/Holo.Light.ButtonBar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:drawableTop="@drawable/ic_save_coffee"
            android:text="@string/updateCoffeeBtnLbl"
            android:layout_alignParentBottom="true"
            android:layout_centerHorizontal="true"
            android:layout_marginBottom="38dp" 
            android:onClick="update"/>

    </RelativeLayout>


</FrameLayout>
```

Run you app and confirm you get a blank Edit Screen when you select a row in the coffee list, like so:

![](/assets/lab508.png)

But you get an error instead??

Can you try a very rudementary fix to get the app running?

