# App Refactoring - Our 'Edit' Option \(Part 4\)

Now, once you've tried to confirm that your update and toggle features are working as expected, you've probably noticeed you have to manually navigate back to the previous screen when you click the update button.

To improve the user experience somewhat, we can ensure that the user is automatically returned to the previous screen after they've selected the update button - no matter which screen they were on. This can be achieved with the following code, so add this to your Fragment and run your app again and se what happens.

```
if (getFragmentManager().getBackStackEntryCount() > 0) {    
                getFragmentManager().popBackStack();    
                return;
         }
```

The final step in this lab is to add database support, which we'll do next.

