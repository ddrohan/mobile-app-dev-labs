#App Refactoring - Our 'Search' Option (Part 2)
Once again, we already have most of the code we need in our 'SearchFragment' fragment, we just need to 'move' some code around a bit, so go ahead and see can you complete this step.

To get you started, you'll need to move everything from the <i>onCreate()</i> to the <i>onCreateView()</i> and you'll need to use the inflated layout (<b>v</b>) to bind to the widgets.

There's actually not a lot of extra code to add with this refactoring, once again, demonstrating the benefits of using (and reusing) Fragments.

For completness, add the following to the Fragment

~~~java
@Override
	public void onResume() {
		super.onResume();

		titleBar.setText(R.string.searchCoffeesLbl);
	}
~~~

When you're done, you should be able to Search & Filter as normal (as with the previous version) only this time it's all nice and contained in a Fragment, like so:

