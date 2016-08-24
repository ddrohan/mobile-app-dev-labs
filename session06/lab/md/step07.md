# Google+ Integration - Updating a Coffee


As promised, here's the code necessary for initially retrieving a coffee from the server and displaying it on the Edit Screen

```
@Override
public void setList(List list) { 
    Base.app.coffeeList = list;
}

@Override
public void setCoffee(Coffee c) { 
    this.aCoffee = c; 
    updateUI();
}

public void updateUI() { 
    titleName.setText(aCoffee.name); 
    titleShop.setText(aCoffee.shop); 
    name.setText(aCoffee.name); 
    shop.setText(aCoffee.shop); 
    price.setText(""+aCoffee.price); 
    ratingBar.setRating((float)aCoffee.rating); 

        if (aCoffee.favourite == true) { 
                favouriteImage.setImageResource(R.drawable.ic_favourite_on); 
                isFavourite = true; 
            } 
            else { 
                favouriteImage.setImageResource(R.drawable.ic_favourite_off); 
                isFavourite = false; 
            }
    }
```
Run your app again to confirm everything is as expected.

The last part of updating a coffee, is just that - **PUT**ing our data back on the server and there's actually not too much to this. To get you started, here's the APi call you'll need to make, 

```
CoffeeApi.put("/coffees/" + Base.googleToken +"/" + aCoffee._id, aCoffee);
```

but the existing _update()_ method needs a small bit of refactoring so see if you can make the necessary changes to get everything working.

Once that's done you can move onto the next step - Deleting a Coffee.
