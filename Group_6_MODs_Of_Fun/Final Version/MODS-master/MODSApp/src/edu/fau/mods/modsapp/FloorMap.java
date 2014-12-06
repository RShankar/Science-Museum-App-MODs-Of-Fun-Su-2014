package edu.fau.mods.modsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FloorMap extends Activity {

	Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.floor_map);
	}

	/*
	 * onClick, launch the EcoScapes Thematic Layout
	 */
	public void launchEcoscapeLayout(View v) {
		Intent i = new Intent(context, EcoscapeActivity.class);
		startActivity(i);
	}

	/*
	 * onClick, launch the Storm Center Thematic Layout
	 */
	public void launchStormLayout(View v) {
		Intent i = new Intent(context, StormActivity.class);
		startActivity(i);
	}

	/*
	 * onClick, launch the First Floor Layout
	 */
	public void launchFirstFloor(View v) {
		Intent i = new Intent(context, FirstFloor.class);
		startActivity(i);
	}

	/*
	 * onClick, launch the Second Floor Layout
	 */
	public void launchSecondFloor(View v) {
		Intent i = new Intent(context, SecondFloor.class);
		startActivity(i);
	}

}
