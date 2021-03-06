#The Help Screen

To implement the Help feature of our App we need to :

- create a new Activity (<b>Help.java</b>) and associate it with our help layout.
- associate this activity with our menu.

Using Android Studio, go to File->New->Activity and create a new <b>Empty Activity</b> in the <b><i>ie.cm.activities</i></b> package and <b>Deselect 'Generate layout file'</b> (like below) as we already have one in our resources.

![](../img/lab2s401.png)

Make sure to DESELECT the option to create a menu for this screen - we will be using our own menu for all screens, so if one gets created for you, delete this menu resource and remove the associated method in the Activity class. 

Extend your <b>Help.java</b> Activity from "Base" as the parent class and set the correct layout, so your <b><i>onCreate()</i></b> method should look something like this

~~~
public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.help);
}
~~~

Your Help Screen layout is already completed but you can design it whatever way you want really, so take some time to customise this layout to your own liking.

Once you're happy with your own Help Screen, you can now 'uncomment' your <b>menuHelp</b> method in your Base class, so go ahead and do that and test again to confirm and you should have something like this

![](../img/starterapphelp.png)

Now we can move on to actually adding a Coffee to our App.
