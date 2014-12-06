package edu.fau.mods.modsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class EcoscapeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ecoscape);
		findViewById(R.id.imageButton1).setOnClickListener(btnClick);
		findViewById(R.id.imageButton3).setOnClickListener(btnClick);
	}

	private OnClickListener btnClick = new OnClickListener() {
	    public void onClick(View v) {
	    	Intent intent = new Intent();
			switch(v.getId()) {
			case R.id.imageButton1:
				intent.setAction(MODSIntents.AQUARIUM);
				break;
			case R.id.imageButton3:
				intent.setAction(MODSIntents.BUGS);
				break;
			}
			sendBroadcast(intent);
	    }
	};
}
