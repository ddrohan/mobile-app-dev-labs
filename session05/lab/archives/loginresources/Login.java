package ie.cm.activities;

import ie.cm.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {

	// used to know if the back button was pressed in the splash screen activity
	// and avoid opening the next activity
	private boolean mIsBackButtonPressed;
	private SharedPreferences settings;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		settings = getSharedPreferences("loginPrefs", 0);
		if (settings.getBoolean("loggedin", false))
			/* The user has already logged in, so start the Home Screen */
			startHomeScreen();

		setContentView(R.layout.login);
		Button login = (Button) findViewById(R.id.btnLogin);
		login.setOnClickListener(this);
	}

	@Override
	public void onBackPressed() {
		// set the flag to true so the next activity won't start up
		mIsBackButtonPressed = true;
		super.onBackPressed();
	}

	@Override
	public void onClick(View arg0) {

	
	}

	private void startHomeScreen() {
		Intent intent = new Intent(Login.this, Home.class);
		Login.this.startActivity(intent);
	}
}
