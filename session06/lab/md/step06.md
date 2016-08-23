# Google+ Integration - Updating a Coffee

Before we make a start at updating a coffee, here are the 2 lines of code necessary for adding a coffee (replacing our database insert call)

```
Base.app.coffeeList.add(c);
CoffeeApi.post("/coffees/" + Base.googleToken,c);
```

Unfortunately, this step isn't as simple and straightforward as the last step, in that we need to 
- display the coffee details (that the user has selected) on the Edit Screen via a **GET** request
- send a **PUT** request to update our coffee on the server
- return the user to the screen they were on before they chose to edit their coffee
