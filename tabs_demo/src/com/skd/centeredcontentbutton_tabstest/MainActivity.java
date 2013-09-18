package com.skd.centeredcontentbutton_tabstest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.skd.centeredcontentbutton.CenteredContentToggleButton;
import com.skd.centeredcontentbutton.CenteredContentToggleGroup;
import com.skd.centeredcontentbutton.CenteredContentToggleGroup.OnCheckedChangeListener;

public class MainActivity extends Activity implements OnCheckedChangeListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		CenteredContentToggleGroup tabs = (CenteredContentToggleGroup) findViewById(R.id.tabs);
		tabs.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(CenteredContentToggleGroup group, int checkedId) {
		CenteredContentToggleButton tab = (CenteredContentToggleButton) findViewById(checkedId);
		Toast.makeText(getApplicationContext(), tab.getText() + " selected", Toast.LENGTH_SHORT).show();
	}
	
}
