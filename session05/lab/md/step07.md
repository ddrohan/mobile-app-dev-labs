# App Refactoring - Our 'Edit' Option \(Part 1\)

This step is similar to our 'Add' Fragment implementation but there's a bit more complexity involved as we need to

* Create a new Fragment \(**EditFragment**\) \(similar to Add\)
* Recycle the 'Edit' Layout for use with our new Fragment \(similar to Add\)

and

* Pass the relevant Coffee Data from the 'Coffee List' \(managed within the **CoffeeFragment**\) to the **EditFragment**

So first of all, go ahead and create the Fragment \(and it's associated layout\) but this time, modify the boilerplate code so that the **_newInstance\(\)_** method takes a 'Bundle' object \(called _coffeeBundle_\) as a parameter.



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

so see if you can implement the necessary code to 'switch to' the EditFragment instead of launching the Edit activity. 

**Hint:** have a look at your **Home** activity and how we manage our Fragments.

