#Our 'new look' Home Screen - Edit a Coffee

#Updating the data in our coffeeList

The first issue was no matte which coffee we 'clicked' on we always got the first coffee to edit - this is because the coffee id never gets set, so you need to refactor the <b>Coffee</b> model and add an autoincrement number to act as a unique id. I'ts a bit crude but it'll do the job until we move on to more sophisticated approaches in later labs.

probably easiest to do something like this

~~~java
public class Coffee implements Serializable
{

	public static int autoid = 1;
	public int coffeeId;
	public String name;
	public String shop;
	public double rating;
	public double price;
	public boolean favourite;


	public Coffee() {}

	public Coffee(String name, String shop, double rating, double price, boolean fav)
	{
		this.coffeeId = autoid++;
		this.name = name;
		this.shop = shop;
		this.rating = rating;
		this.price = price;
		this.favourite = fav;
	}

	@Override
	public String toString() {
		return "Coffee [name=" + name
				+ ", shop =" + shop + ", rating=" + rating + ", price=" + price
				+ ", fav =" + favourite + "]";
	}
}
~~~

And you probably worked out that the problem was, even if we changed the data, it was only updated in our list of coffees if we clicked the 'Update' Button, but nothing else happens - we'd need to hit the 'back' button to return to the previous screen.

It's worth noting that we never actually 'put it back' in the list after we updated it, but because our list is <i>static</i>, that's ok - any changes to a single coffee are updated in the global list. We might need to revisit this in later labs, but for now, it's all good.

In the <i><b>update()</b></i> method we need something like this

~~~java
goToActivity(this,Home.class, activityInfo);
~~~

so see if you can work out where this should be inserted.

You should run you app once more and fully test it for the features now implemented.
