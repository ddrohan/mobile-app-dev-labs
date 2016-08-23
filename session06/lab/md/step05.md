# Google+ Integration - Adding a Coffee

At this stage, we've made a few simple **GET** requests on the Server - now let's make some **POST** Requests and add a coffee to our list.

The first thing we need to do is update our **CoffeeApi** class and add in a new method to allow us to POST our coffee to the server, so open up your **_CoffeeApi.java_** and add the following:

```
public static void post(String url,Coffee aCoffee) { 
    Log.v(TAG, "POSTing to : " + url); 
    Type objType = new TypeToken<Coffee>(){}.getType(); 
    String json = new Gson().toJson(aCoffee, objType); 
    JSONObject jsonObject = null; 

    try { 
        jsonObject = new JSONObject(json); 
        } 
    catch (JSONException e) { 
        e.printStackTrace(); 
       }     

    JsonObjectRequest gsonRequest = new JsonObjectRequest( Request.Method.POST, hostURL + url, jsonObject, 
            new Response.Listener<JSONObject>() { 
                @Override 
                public void onResponse(JSONObject response) { 
                    Log.v(TAG, "insert new Coffee " + response.toString()); 
                    } 
            }, 
            new Response.ErrorListener() { 
                @Override 
                public void onErrorResponse(VolleyError error) { // Handle Error 
                    Log.v(TAG, "Unable to insert new Coffee"); 
                } 
            }) { 

        @Override 
        public Map<String, String> getHeaders() throws AuthFailureError { 
               HashMap<String, String> headers = new HashMap<String, String>(); 
               headers.put("Content-Type", "application/json; charset=utf-8"); 
               //headers.put("User-agent", System.getProperty("http.agent")); return headers; } }; 
    
    // Add the request to the queue 
    Base.app.add(gsonRequest);
}
```
Fix any import errors you have and take some time to investigate how this method achieves our goal of

- accepting a coffee object as a parameter
- converting this object into a JSON String (using Gson)
- POSTing this JSON String to the server

You can always ask the Lecturer for some more detail if necessary.

The next thing we need to do is refactor our **Add Fragment** and integrate our APi class so open up your _AddFragment.java_ and have a go at implementing what we need.

There's actually verry little to this so if you've added the necessary code correctly, you should be able to add a coffee in the same way as in **CoffeeMate.4.0** but this time, the coffee is added to the list of your coffees on the server **NOT** on the device (via the database).

And don't worry, the solution is next :)

