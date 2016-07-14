# App Refactoring - Our 'Edit' Option \(Part 3\)

As we're using \(and replacing\) Fragments instead of switching between Activities, we have two options when trying to implement event handling.  We can

* Implement the event handling and listeners 'in house' and manage everything inside the Fragment - but this can get a bit tricky when we want to handle more than one event \(like our situation\)

or

* we implement a callback listener to the parent activity \(in our case 'Home'\), which ties in with the particular navigation pattern we're trying to adhere to - so this is what we'll do.

If you recall, Android Studio generated a lot of boilerplate code for us, including some template callback listeners - which we needed to implement, to get a version of our app running. We'll now revisit this code \(and the whole EditFragment\) and complete our 'Edit' feature.

First, familarise yourself with the particular listener we need to implement

```
public interface OnFragmentInteractionListener 
{    
// TODO: Update argument type and name    
void onFragmentInteraction(Uri uri);
}
```

and the default methods to 'hook up', attach\/detach to the UI event

```
// TODO: Rename method, update argument and hook method into UI event

public void onButtonPressed(Uri uri) 
{    
if (mListener != null) {        
    mListener.onFragmentInteraction(uri);    
    }
}

@Override
public void onAttach(Context context) 
{    
    super.onAttach(context);    
        if (context instanceof OnFragmentInteractionListener) {        
            mListener = (OnFragmentInteractionListener) context;    
            } 
            else {        
                    throw new RuntimeException(context.toString()                
                            + " must implement OnFragmentInteractionListener");    
            }
}

@Override
public void onDetach() 
{    
    super.onDetach();    
    mListener = null;
}
```

Next, bring in the existing methods from the Edit activity \('toggle' and 'update'\) and fix any errors.

**Note:** Seeing as we need to bind to the widgets both for displaying and updating it's probably best to use class-wide widget variables \(like we did for our 'Add'\) so before you proceed, make sure your **onCreateView\(\)** and **update\(\)** methods look something like this

```java
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { 

    View v = inflater.inflate(R.layout.fragment_edit, container, false); 

    ((TextView)v.findViewById(R.id.coffeeNameTextView)).setText(aCoffee.name); 
    ((TextView)v.findViewById(R.id.coffeeShopTextView)).setText(aCoffee.shop); 

    name = (EditText)v.findViewById(R.id.nameEditText); name.setText(aCoffee.name); 
    shop = (EditText)v.findViewById(R.id.shopEditText); shop.setText(aCoffee.shop); 
    price = (EditText)v.findViewById(R.id.priceEditText); price.setText(""+aCoffee.price); 
    ratingBar = (RatingBar) v.findViewById(R.id.coffeeRatingBar); ratingBar.setRating((float)aCoffee.rating); 

    favouriteImage = (ImageView) v.findViewById(R.id.favouriteImageView); 
        if (aCoffee.favourite == true) { 
            favouriteImage.setImageResource(R.drawable.ic_favourite_on); 
            isFavourite = true; 
        } else { 
            favouriteImage.setImageResource(R.drawable.ic_favourite_off); 
            isFavourite = false; 
        } 
    return v;
}
```

```
public void update(View v) {    
        if (mListener != null) {        
                String coffeeName = name.getText().toString();        
                String coffeeShop = shop.getText().toString();        
                String coffeePriceStr = price.getText().toString();        
                double ratingValue = ratingBar.getRating();        

                double coffeePrice;        
                        try {            
                        coffeePrice = Double.parseDouble(coffeePriceStr);        
                        } catch (NumberFormatException e) 
                        {            coffeePrice = 0.0;        }        

                if ((coffeeName.length() > 0) && (coffeeShop.length() > 0) && (coffeePriceStr.length() > 0)) {            
                        aCoffee.name = coffeeName;            
                        aCoffee.shop = coffeeShop;            
                        aCoffee.price = coffeePrice;            
                        aCoffee.rating = ratingValue;           
                     }        
                } else            
                Toast.makeText(getActivity(), "You must Enter Something for Name and Shop", Toast.LENGTH_SHORT).show();    
                }
        }
```

The last thing we need to do is refactor our Listener interface to reflect the events we want to handle so replace the existing interface with this one

```
public interface OnFragmentInteractionListener {    
    void toggle(View v);    
    void update(View v);
}
```

And use the Android Studio Tools to implement these new methods back in our 'Home' activity \(and fix any residual errors\).

Here's the implementation for the 'toggle'

```
@Override
public void toggle(View v) {    
    EditFragment editFrag = (EditFragment) getFragmentManager().findFragmentById(R.id.homeFrame);    
        if (editFrag != null) {        
                editFrag.toggle(v);    
        }
    }
```

so have a go at implementing the 'update'. 

