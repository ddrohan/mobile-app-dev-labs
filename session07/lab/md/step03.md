#View Users Current Location

Before you go any further, here's where we're at so far

- [CoffeeMate.6.0.sofar](../archives/CoffeeMate.7.0.sofar.zip)


At the moment, when the user selects the 'Map' menu option, they get to see a standard map, but not their own location (or even their coffees locations), so this step is about implementing the that (we'll look at the coffees location in the next step).

As we want to keep in line with the UI guidelines and approach, it makes sense to use a <i>Fragment</i> so first of all go ahead and create a new (Blank) Fragment called **MapsFragment** (NOT MapFragment) but DON'T create a layout or include interface callbacks

![](/session07/lab/img/lab0704.png)

Make sure it **_extends_** from _MapFragment_ and **_implements_** the following interfaces, like so

```
public class MapsFragment extends MapFragment implements 
    GoogleApiClient.ConnectionCallbacks, 
    GoogleApiClient.OnConnectionFailedListener, 
    GoogleMap.OnInfoWindowClickListener, 
    GoogleMap.OnMapLongClickListener, 
    GoogleMap.OnMapClickListener, 
    GoogleMap.OnMarkerClickListener, 
    LocationListener {
...
}
```
Fix the errors and replace the existing newInstance() method with this one

```
public static MapsFragment newInstance() { 
    MapsFragment fragment = new MapsFragment(); 
return fragment;
}
```

Remove onCreate() and onCreateView() and replace with

```
@Overridepublic void onViewCreated(View view, Bundle savedInstanceState) { 
super.onViewCreated(view, savedInstanceState); setHasOptionsMenu(true); mGoogleApiClient = new GoogleApiClient.Builder( getActivity() ) .addConnectionCallbacks( this ) .addOnConnectionFailedListener( this ) .addApi( LocationServices.API ) .build();}
```
