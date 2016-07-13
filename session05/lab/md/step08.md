# App Refactoring - Our 'Edit' Option \(Part 2\)

The problem with the previous step was the Main Activity \(in out case 'Home' must implement the **OnFragmentInteractionListener** interface \(for the callbacks\) so you can carry out a quick fix like so

![](/assets/lab510.png)

choosing to Implement methods.

Run your app again just to make sure everything is working as expected. **OnFragmentInteractionListener **isn't really a suitable name for our needs, but we'll come back to that later.

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

```
public class EditFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public EditFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static EditFragment newInstance(Bundle coffeeBundle) {
        EditFragment fragment = new EditFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
```

Now, we need to first of all, be able to display our coffee data on our Edit screen, so see can you reuse what you already have in your existing activity and incorporate it in your new EditFragment. What you're looking for is something like this \(if we selected 'Regular Joe' from our list\)

![](/assets/coffeemate.7.png)

So revisit how it's implemented in the Edit Activity and how you can leverage that to get it to work in the EditFragment.

**Hint:** You need to do something very similar to what you did with the AddFragment insofar as you need to refactor the onCreateView\(\) method but also add the following to your onCreate\(\) method, to retrieve the correct coffee data before you display it

```
@Overridepublic void onCreate(Bundle savedInstanceState) 
{    
    super.onCreate(savedInstanceState);    
        if(getArguments() != null)        
            aCoffee = getCoffeeObject(getArguments().getInt("coffeeID"));
}
```

