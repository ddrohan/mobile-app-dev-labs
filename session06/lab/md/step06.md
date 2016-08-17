# Google+ Integration - Updating a Coffee

Before we maek a start at updating a coffee, here's the 2 lines of code necessary for adding a coffee (replacing our database insert call)

```
Base.app.coffeeList.add(c);
CoffeeApi.post("/coffees/" + Base.googleToken,c);
```

There's quite a lot of code \(relatively speaking\) to get this off the ground, so we'll use th
