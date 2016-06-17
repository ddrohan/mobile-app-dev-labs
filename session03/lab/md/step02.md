#Our 'new look' Home Screen

When we're finsihed this lab, we'll have something like this

![](../img/lab0301.png)

So, first of all, have a quick look again at the resource layout (home.xml). Notice that the buttons don't look like buttons in the conventional sense anymore. They're still buttons, we've just applied a <b><i>Style</i></b> to make them a bit more presentable. The style <i>@style/homeScreenButton</i> is being used to give the buttons a different look and feel, so ensure your buttons look similar. 

Also, we're using a <b><i>FrameLayout</i></b> as the container for our List of Coffees, which ultimately holds a <b>Fragment</b>, but we'll talk more about that later.

Once you've had a look at the layout, open your <b>Base.java</b> Activity class and familiarise yourself with the new variables/methods this class now has. 

There's two new instance variables 

~~~java
  protected Bundle            activityInfo; // Used for persistence (of sorts)
  protected CoffeeFragment    coffeeFragment; // How we'll 'share' our List of Coffees between Activities
~~~

And there's a number of helper methods for accessing different widgets on our layouts, for example:

~~~java
  protected EditText getEditText(int id) {
    return ((EditText) findViewById(id));
  }

  protected String getEditString(int id) {
    return (getEditText(id)).getText().toString();
  }
~~~

Make sure you understand how all these methods in <b>Base.java</b> work, as you'll be referring to them quite a lot!

The first thing to do is refactor the Home Screen <b><i>onCreate()</i></b> method to make use of these helper methods, so have a look again at the current implementation:

~~~java
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.home);
    coffeeListTextView = (TextView) findViewById(R.id.recentlyAddedListEmpty);

    Button addACoffeeButton = (Button) findViewById(R.id.addACoffeeBtn);
    addACoffeeButton.setOnClickListener(this);
  }
~~~

Make sure your new <b><i>onCreate()</i></b> method looks something like this:

~~~java
  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     
        setContentView(R.layout.home);
        // Comment out on first run of app
        setupCoffees(); 
    }
~~~

and you understand it. Note that we have removed the Eventlistener settings - we now handle <b><i>onClick()</i></b> events in the layout (via the xml).

The <b><i>setupCoffees()</i></b> method adds a few Coffee objects to our static <b><i>coffeeList</i></b>, so have a go at implementing this in <b>Home.java</b>.

Run the App again just to confirm you're not seeing a blank screen anymore.

Next we'll start with the task of displaying our Coffees in a custom ListView.