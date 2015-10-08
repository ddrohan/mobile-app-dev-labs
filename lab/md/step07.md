#Our 'new look' Home Screen - Edit a Coffee

#Updating the data in our coffeeList

You probably worked out that the problem was, even if we changed the data, it was only updated in our list of coffees if we clicked the 'Update' Button, but nothing else happens - we'd need to hit the 'back' button to return to the previous screen.

It's worth nothing that we never actually 'put it back' in the list after we updated it, but because our list is <i>static</i>, that's ok - any changes to a single coffee are updated in the global list. We might need to revisit this in later labs, but for now, it's all good.

In the <i><b>update()</b></i> method we need something like this

~~~java
goToActivity(this,Home.class, activityInfo);
~~~

so see if you can work out where this should be inserted.

You should run you app once more and fully test it for the features now implemented.
