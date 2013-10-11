package com.skd.centeredcontentbuttontest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.skd.centeredcontentbutton.CenteredContentButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final CenteredContentButton btn1 = (CenteredContentButton) findViewById(R.id.btn1);
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), btn1.getText(), Toast.LENGTH_SHORT).show();
			}
		});
		
		final CenteredContentButton btn2 = (CenteredContentButton) findViewById(R.id.btn2);
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), btn2.getText(), Toast.LENGTH_SHORT).show();
			}
		});
		
		final CenteredContentButton btn3 = (CenteredContentButton) findViewById(R.id.btn3);
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), btn3.getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}

}
