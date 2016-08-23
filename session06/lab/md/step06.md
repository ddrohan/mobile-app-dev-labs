# Google+ Integration - Updating a Coffee

Before we make a start at updating a coffee, here are the 2 lines of code necessary for adding a coffee (replacing our database insert call)

```
Base.app.coffeeList.add(c);
CoffeeApi.post("/coffees/" + Base.googleToken,c);
```

Unfortunately, this step isn't as simple and straightforward as the last step, in that we need to 
- display the coffee details on the Edit Screen
- 
