#Adding a Coffee - Switching to our 'Coffee Check In' Screen

First of all, have a quick look at the resource layout (content_home.xml) we will be referring to, and familiarise yourself with the properties of the different buttons, especially the <b>onClick</b>, as you will have to refer to these in the following steps.

![](../img/lab2s201.png)

We <b>won't</b> need to implement specific Event Listeners for this step, instead we will use the simpler 'direct binding' approach where we associate a method to be triggered when our button is pressed. 

So, navigate to the <b>onClick</b> property of the 'Check In' button and enter <b>add</b> for the method name.

Next, open your <b>Home.java</b> activity and add the following method

~~~java
    public void add(View v)
    {
    gotToActivity(this,add.class,null);
    }
~~~

NOTE: Ensure you insert this code <b>AFTER</b> the layout has been set - what are the implications if the code was inserted BEFORE the layout was set?

Your <b><i>onClick()</i></b> code should look something like this

~~~Java
switch(v.getId()) {
    case R.id.addACoffeeBtn:
        goToActivity(this,Add.class,null);
        break;
    case R.id.searchCoffeesBtn:

        break;
    case R.id.favouritesCoffeeBtn: 

        break;
    }
~~~

Be sure you understand what's happening here as we will be revisiting this method throughout the labs and adding in the extra functionality as we go along. 

Finally, your <b><i>onResume()</i></b> method is already complete, but again, familiarise yourself with the inner workings of the method as you will need to do something similar in your <b>Add.java</b> Activity class later on.  

You should run your app at this stage just to see if it behaves like it should.

You will, more than likely, get an error along the lines of 

~~~
android.content.ActivityNotFoundException: Unable to find explicit activity class {ie.cm.models/ie.cm.activities.Add};
~~~

Can you work out why, and more importantly, how to fix it? (Hint : it involves the AndroidManifest.xml file and you can find the answer in the section on Intents already covered in the lectures).

Run the app again once you have solved this issue, to confirm everything is ok so far.

![](../img/starterapp1.png)

Next we'll start with implementing the menu.