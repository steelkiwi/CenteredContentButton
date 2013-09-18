package com.skd.centeredcontentbutton_toggletest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.skd.centeredcontentbutton.CenteredContentToggleButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final CenteredContentToggleButton btn1 = (CenteredContentToggleButton) findViewById(R.id.btn1);
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String state = (btn1.isChecked()) ? "On" : "Off";
				Toast.makeText(getApplicationContext(), btn1.getText() + " - " + state, Toast.LENGTH_SHORT).show();
			}
		});
		
		final CenteredContentToggleButton btn2 = (CenteredContentToggleButton) findViewById(R.id.btn2);
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String state = (btn2.isChecked()) ? "On" : "Off";
				Toast.makeText(getApplicationContext(), btn2.getText() + " - " + state, Toast.LENGTH_SHORT).show();
			}
		});
	}
	
}
