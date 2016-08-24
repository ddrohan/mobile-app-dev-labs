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

