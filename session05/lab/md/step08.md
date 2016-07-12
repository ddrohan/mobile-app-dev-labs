# App Refactoring - Our 'Edit' Option \(Part 2\)

The problem with the previous step was the Main Activity \(in out case 'Home' must implement the **OnFragmentInteractionListener** interface \(for the callbacks\) so you can carry out a quick fix like so

![](/assets/lab510.png)

choosing to Implement methods.

Run your app again just to make sure everything is working as expected.

---

Now, This step involves recycling a lot of our existing code from our Add Activity but also implementing a callback interface, a lot of which is actually supplied for us via Android Studio when we create a Fragment.

First of all, ensure your CoffeeFragment's onItemClick\(\) looks something like this

```
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
{  
    Bundle activityInfo = new Bundle();  
    activityInfo.putInt("coffeeID", view.getId());  

    FragmentTransaction ft = getFragmentManager().beginTransaction();  
    Fragment fragment = EditFragment.newInstance(activityInfo);  
    ft.replace(R.id.homeFrame, fragment);  
    ft.addToBackStack(null);  
    ft.commit();
}
```

and your initial EditFragment looks something like this

