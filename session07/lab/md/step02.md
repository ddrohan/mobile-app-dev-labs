#Obtaining your Google Maps Key

First of all, you need to visit [Get an API Key](https://developers.google.com/maps/documentation/android-api/signup) on the Android Developer site as it contains all the info you need to obtain your Key. You'll have some of the work done already (from the previous lab) but there's still a bit of work to do, so if you get stuck just ask!

Once you have your key, the next thing to do is add the following to your strings.xml

```
<string name="title_map">Map</string>
<string name="google_maps_key">abcdefghijklmnopetcetcetc</string>
```

where 'abcdefghijklmnopetcetcetc' is your API Key.

Next, open up your manifest file and add the following just before the **closing** "<application>" tag






Congratulations - you can now go ahead and build map based apps!
