# Google+ Integration - Deleting a Coffee


As we already have all the necessary code in place from previous versions of CoffeeMate, AND we have a full APi class available to us, this step is very simple - we just need to change our delete method to delete the specific coffee from the server, and not the database, as is currently the case.

we achieve this by calling our **CoffeeApi** 'delete' method like so

```
CoffeeApi.delete("/coffees/" + Base.googleToken +"/" + coffee._id);
```
so see if you can work out where this call should go, and what code it should replace?



