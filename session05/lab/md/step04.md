#App Refactoring - Our 'Add' Option (Part 2)
Here's the code you should have implemented (or something similar) to get the 'Add' screen loading

~~~java
 fragment = AddFragment.newInstance();
 ft.replace(R.id.homeFrame, fragment);
 ft.addToBackStack(null);
 ft.commit();
~~~

and just for completeness, you may have noticed that the title bar we're using for our 'Add' screen  still displays

 ![](../img/lab504.png)
 
 so add the following to your <b>AddFragment</b> (and fix the errors)
 
 ~~~java
  @Override
    public void onResume() {
        super.onResume();

        titleBar = (TextView) getActivity().findViewById(R.id.recentAddedBarTextView);
        titleBar.setText(R.string.addACoffeeLbl);
    }
 ~~~
 
 and run the app again to confirm you get the following
 
 ![](../img/lab505.png)

Once you've properly tested the latest version of CoffeeMate, you'll see that we only have The 'Home' & 'View Favourites' implemented (from the starter App). This step will take you through building a new Fragment <b>AddFragment</b> and reusing a lot of the 'Add' activity code and resources. 