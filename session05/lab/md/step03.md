#Adding a Login Screen

Now we'll add in a very basic level of security - we'll get the user to login before they can use the app. First thing to do is download the necessary resources in [loginresources](../archives/loginresources.zip) and add them to the relevant packages/folders in your project. 

(You can literally drag-and-drop the files into eclipse! <b>NOTE : Make sure you drop in the images first or you'll get a number of errors in your resources file</b>)

You may also get a resource error on the layout regarding a colour, so if you do, update your 'colors.xml' with the following

~~~java
 <color name="bar_black_text">#000000</color>
~~~

The Login Screen looks like this:

 ![](../img/lab504.png)