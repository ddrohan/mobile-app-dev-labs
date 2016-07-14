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



