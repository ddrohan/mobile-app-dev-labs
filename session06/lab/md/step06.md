# Google+ Integration - Updating a Coffee

Before we make a start at updating a coffee, here are the 2 lines of code necessary for adding a coffee \(replacing our database insert call\)

```

Base.app.coffeeList.add(c);

CoffeeApi.post("/coffees/" + Base.googleToken,c);

```

Unfortunately, this step isn't as simple and straightforward as the last step, in that we need to

* display the coffee details \(that the user has selected\) on the Edit Screen via a **GET** request

* send a **PUT** request to update our coffee on the server

* return the user to the screen they were on before they chose to edit their coffee \(NOT the Home Screen as with the 'Add' option\)


So, the first thing to do \(as I've made a few changes to the following\) is replace your current **CoffeeApi** class with this one

```
package ie.cm.api;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ie.cm.activities.Base;
import ie.cm.models.Coffee;

/**
 * Created by ddrohan on 18/07/2016.
 */


public class CoffeeApi {

    private static final String hostURL = "http://coffeemateweb.herokuapp.com";
    private static final String LocalhostURL = "http://192.168.0.13:3000";
    private static       VolleyListener vListener;
    private static final String TAG = "coffeemate";

    public static void attachListener(VolleyListener fragment)
    {
        vListener = fragment;
    }
    public static void detachListener()
    {
        vListener  = null;
    }
    private static void showDialog(String message) {
        //Log.v(TAG, "Showing Dialog because " + Base.dialog.isShowing());
        Base.dialog.setMessage(message);
        if (!Base.dialog.isShowing())
                Base.dialog.show();
    }
    private static void hideDialog() {
        //Log.v(TAG, "Hiding Dialog because " + Base.dialog.isShowing());
        if (Base.dialog.isShowing())
            Base.dialog.dismiss();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    public static void getAll(String url, final SwipeRefreshLayout mSwipeRefreshLayout) {
        Log.v(TAG, "GETing from " + url);
            showDialog("Downloading Coffees...");
        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, hostURL + url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Result handling
                        List<Coffee> result = null;
                        Type collectionType = new TypeToken<List<Coffee>>(){}.getType();
                        result = new Gson().fromJson(response, collectionType);
                        vListener.setList(result);
                        mSwipeRefreshLayout.setRefreshing(false);
                        hideDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Error handling
                System.out.println("Something went wrong!");
                mSwipeRefreshLayout.setRefreshing(false);
                error.printStackTrace();
            }
        });
        // Add the request to the queue
        Base.app.add(stringRequest);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    public static void get(String url) {
        Log.v(TAG, "GETing from " + url);
        showDialog("Downloading a Coffee...");
        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, hostURL + url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Result handling
                        Coffee result = null;
                        Type objType = new TypeToken<Coffee>(){}.getType();
                        result = new Gson().fromJson(response, objType);
                        vListener.setCoffee(result);
                        hideDialog();
                        //vListener.updateUI((Fragment)vListener);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();
            }
        });

        // Add the request to the queue
        Base.app.add(stringRequest);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    public static void post(String url,Coffee aCoffee) {

        Log.v(TAG, "POSTing to : " + url);
        showDialog("Adding a Coffee...");
        Type objType = new TypeToken<Coffee>(){}.getType();
        String json = new Gson().toJson(aCoffee, objType);

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest gsonRequest = new JsonObjectRequest( Request.Method.POST, hostURL + url,

                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        hideDialog();
                        Log.v(TAG, "insert new Coffee " + response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Handle Error
                        Log.v(TAG, "Unable to insert new Coffee");
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                //headers.put("User-agent", System.getProperty("http.agent"));
                return headers;
            }
        };

        // Add the request to the queue
        Base.app.add(gsonRequest);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    public static void put(String url,Coffee aCoffee) {

        Log.v(TAG, "PUTing to : " + url);
        showDialog("Updating a Coffee...");
        Type objType = new TypeToken<Coffee>(){}.getType();
        String json = new Gson().toJson(aCoffee, objType);

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest gsonRequest = new JsonObjectRequest( Request.Method.PUT, hostURL + url,

                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Result handling
                        Coffee result = null;
                        Type objType = new TypeToken<Coffee>(){}.getType();

                        try {
                            result = new Gson().fromJson(response.getString("data"), objType);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        vListener.setCoffee(result);
                        hideDialog();
                        Log.v(TAG, "Updating a Coffee successful with :" + result);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Handle Error
                        Log.v(TAG, "Unable to update Coffee with error : " + error.getMessage());
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                //headers.put("User-agent", System.getProperty("http.agent"));
                return headers;
            }
        };

        // Add the request to the queue
        Base.app.add(gsonRequest);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    public static void delete(String url) {
        Log.v(TAG, "DELETEing from " + url);

        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, hostURL + url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Result handling
                        Log.v(TAG, "DELETE success " + response);
                        //vListener.updateUI((Fragment)vListener);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();
            }
        });

        // Add the request to the queue
        Base.app.add(stringRequest);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    public static void getGooglePhoto(String url,final ImageView googlePhoto) {

        ImageRequest imgRequest = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        Base.googlePhoto = response;
                        googlePhoto.setImageBitmap(Base.googlePhoto);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Something went wrong!");
                error.printStackTrace();
            }
        });

// Add the request to the queue
        Base.app.add(imgRequest);
    }
}

```

and your VolleyListener with this

```
public interface VolleyListener {

 void setList(List list);

 void setCoffee(Coffee c);

}

```

You'll get a few errors, but don't worry, we'll fix those now, so go ahead and open up your _CoffeeFragment.java_ and replace your current class with this one

```
package ie.cm.fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import ie.cm.R;
import ie.cm.activities.Base;
import ie.cm.adapters.CoffeeFilter;
import ie.cm.adapters.CoffeeListAdapter;
import ie.cm.api.CoffeeApi;
import ie.cm.api.VolleyListener;
import ie.cm.models.Coffee;

public class CoffeeFragment  extends Fragment implements AdapterView.OnItemClickListener,
                                                         View.OnClickListener,
                                                         VolleyListener
{
  protected static  CoffeeListAdapter     listAdapter;
  protected         ListView             listView;
  protected         CoffeeFilter        coffeeFilter;
  public            boolean             favourites = false;
  protected         TextView            titleBar;
  protected         SwipeRefreshLayout  mSwipeRefreshLayout;

  public CoffeeFragment() {
    // Required empty public constructor
  }

  public static CoffeeFragment newInstance() {
    CoffeeFragment fragment = new CoffeeFragment();
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = null;

    v = inflater.inflate(R.layout.fragment_home, container, false);

    listView = (ListView) v.findViewById(R.id.coffeeList);
    mSwipeRefreshLayout =   (SwipeRefreshLayout) v.findViewById(R.id.coffee_swipe_refresh_layout);

    setSwipeRefreshLayout();

    return v;
  }

  protected void setSwipeRefreshLayout()
  {
    mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        CoffeeApi.getAll("/coffees/" + Base.googleToken,mSwipeRefreshLayout);
      }
    });
  }

  @Override
  public void onResume() {
    super.onResume();
    //updateUI(this);
    CoffeeApi.attachListener(this);
    CoffeeApi.getAll("/coffees/" + Base.googleToken, mSwipeRefreshLayout);
  }

  @Override
  public void onPause() {
    super.onPause();
    CoffeeApi.detachListener();
  }

  @Override
  public void onStart()
  {
    super.onStart();
  }

  @Override
  public void onClick(View view)
  {
    if (view.getTag() instanceof Coffee)
    {
      onCoffeeDelete ((Coffee) view.getTag());
    }
  }

  public void onCoffeeDelete(final Coffee coffee)
  {
    String stringName = coffee.name;
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setMessage("Are you sure you want to Delete the \'Coffee\' " + stringName + "?");
    builder.setCancelable(false);

    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface dialog, int id)
      {
        CoffeeApi.delete("/coffees/" + Base.googleToken +"/" + coffee._id);
        //Base.app.coffeeList.remove(coffee); // remove from our list
        listAdapter.coffeeList.remove(coffee); // update adapters data
        listAdapter.notifyDataSetChanged(); // refresh adapter
      }
    }).setNegativeButton("No", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface dialog, int id)
      {
        dialog.cancel();
      }
    });
    AlertDialog alert = builder.create();
    alert.show();
  }

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Bundle activityInfo = new Bundle();
    activityInfo.putString("coffeeID", (String)view.getTag());

    FragmentTransaction ft = getFragmentManager().beginTransaction();
    Fragment fragment = EditFragment.newInstance(activityInfo);
    ft.replace(R.id.homeFrame, fragment);
    ft.addToBackStack(null);
    ft.commit();
  }

  @Override
  public void setCoffee(Coffee c) {}

  @Override
  public void setList(List list) {
    Base.app.coffeeList = list;
    updateUI(this);
  }

  public void updateUI(Fragment fragment) {
    //System.out.println("CALLING updateUI in CoffeeFragment");
    titleBar = (TextView)getActivity().findViewById(R.id.recentAddedBarTextView);
    titleBar.setText(R.string.recentlyViewedLbl);
    ((TextView)getActivity().findViewById(R.id.empty_list_view)).setText(R.string.recentlyViewedEmptyMessage);

    listAdapter = new CoffeeListAdapter(getActivity(), this, Base.app.coffeeList);
    listView.setAdapter (listAdapter);
    coffeeFilter = new CoffeeFilter(Base.app.coffeeList,"all",listAdapter);

    if (favourites) {
      titleBar.setText(R.string.favouritesCoffeeLbl);
      ((TextView)getActivity().findViewById(R.id.empty_list_view)).setText(R.string.favouritesEmptyMessage);

      coffeeFilter.setFilter("favourites"); // Set the filter text field from 'all' to 'favourites'
      coffeeFilter.filter(null); // Filter the data, but don't use any prefix
    }

    listView.setOnItemClickListener(this);
    listView.setEmptyView(getActivity().findViewById(R.id.empty_list_view));
    listAdapter.notifyDataSetChanged(); // Update the adapter
  }
}

```

**I strongly recommend that you take some time and review this class and compare it to your previous class to understand the changes that have been made, particularly the introduction of the _SwipeRefreshLayout_ and the refactoring of the _onItemClick()_ method**.

Now, open your EditFragment

