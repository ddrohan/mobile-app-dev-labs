# Google+ Integration - Retrieving 'My Coffees'


At the moment the user is seeing a list of **_all_** coffees stored on the server, so let's make the app a bit more user friendly and download **_only_** the users coffees.

This is actually a very simple step, all we need to do is modify our APi call and add the users Google+ credentials to the request (which we already have) like so:

```
CoffeeApi.get("/coffees/" + Base.googleToken);
```

so now when we run the app we only see the current users coffees - here's mine!


![](/session06/lab/img/lab0609.png)

and

![](/session06/lab/img/lab0610.png)
