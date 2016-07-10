#App Refactoring - Our 'Add' Option (Part 2)
Here's the code you should have implemented (or something similar) to get the 'Add' screen loading

~~~java
 fragment = AddFragment.newInstance();
 ft.replace(R.id.homeFrame, fragment);
 ft.addToBackStack(null);
 ft.commit();
~~~



Once you've properly tested the latest version of CoffeeMate, you'll see that we only have The 'Home' & 'View Favourites' implemented (from the starter App). This step will take you through building a new Fragment <b>AddFragment</b> and reusing a lot of the 'Add' activity code and resources. 