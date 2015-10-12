#The Help Screen

To implement the Help feature of our App we need to :

- create a new Activity (<b>Help.java</b>) and associate it with our new help layout.
- associate this activity with our menu.

Using Android Studio, go to File->New->Activity and create a new <b>Empty Activity</b> in the <b><i>ie.cm.activities</i></b> package and <b>Deselect 'Generate layout file'</b> as we already have one in our resources. (like below)



Make sure to DESELECT the option to create a menu for this screen - we will be using our own menu for all screens, so if one gets created for you, delete this menu resource and remove the associated method in the Activity class. 

Extend your <b>Help.java</b> Activity from "Base" as the parent class so your <b><i>onCreate()</i></b> method should look something like this

~~~
public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.help);
}
~~~

Your Help Screen layout is already completed but you can design it whatever way you want really, so take some time to customise this layout to your own liking.

Once you're happy with your own Help Screen, as a final step, we need to refactor our <b><i>onMenuItemSelected()</i></b> method in our <b>Base</b> class to handle the user selecting the help option from the menu. We can make use of our helper <b><i>goToActivity()</i></b> method again so our updated code should look something like this

~~~
@Override 
public boolean onMenuItemSelected(int featureId, MenuItem item) {  
        switch(item.getItemId()) { 
            case R.id.help : goToActivity(this,Help.class,null);  
                             break; 
            case R.id.info : openInfoDialog(this);  
                             break; 
            case R.id.home : goToActivity(this,Home.class,null); 
                             break; 
        } 
    return super.onMenuItemSelected(featureId, item); 
}
~~~

Now we can move on to actually adding a Coffee to our App.
