package edu.fau.mods.modsapp;

// test comment
import java.util.Arrays;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends Activity {

	public String nfcData;

	Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);

		Button flr = (Button) findViewById(R.id.flr_btn);
		flr.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(context, FloorMap.class);
				startActivity(i);
			}

		});

		Button event = (Button) findViewById(R.id.sched_btn);
		event.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(context, Schedule.class);
				startActivity(i);
			}

		});

		Intent intent = getIntent();
		if (intent.getAction().equals(NfcAdapter.ACTION_NDEF_DISCOVERED)) {
			// Read the first record which contains the NFC data
			Parcelable[] rawMsgs = intent
					.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
			NdefRecord record = ((NdefMessage) rawMsgs[0]).getRecords()[0];
			nfcData = new String(record.getPayload());
			String[] parts = nfcData.split("/");
			String[] actions = Arrays.copyOfRange(parts, 3, parts.length);

			// uncomment for testing in order to see the string read from the
			// tag
			String testString = "";
			for (String str : actions) {

				testString += str;
			}
			Toast.makeText(this, testString, Toast.LENGTH_SHORT).show();

			// parse URI from RFID tag
			if (actions[0].equals("ecoscapes")) {
				intent = new Intent();
				
				if (actions[1].equals("sharktank")) {
					intent.setAction(MODSIntents.SHARK);
				}
				if (actions[1].equals("lobstertank")) {
					intent.setAction(MODSIntents.LOBSTER);
				}
				if (actions[1].equals("livingreef")) {
					intent.setAction(MODSIntents.LIVING);
				}
				if (actions[1].equals("poisontank")) {
					intent.setAction(MODSIntents.POISON);
				}
				if (actions[1].equals("artificialreef")) {
					intent.setAction(MODSIntents.ARTIFICIAL);
				}
				if (actions[1].equals("schooltank")) {
					intent.setAction(MODSIntents.SCHOOL);
				}
				if (actions[1].equals("blindtank")) {
					intent.setAction(MODSIntents.BLIND);
				}

				if (actions[1].equals("horseshoe")) {
					intent.setAction(MODSIntents.HORSESHOE);
				}
				
				if (actions[1].equals("african_flat_rock_scorpion")) {
					intent.setAction(MODSIntents.AFRICAN_FLAT_ROCK_SCORPION);
				}
				if (actions[1].equals("asian_forest_scorpion")) {
					intent.setAction(MODSIntents.ASIAN_FOREST_SCORPION);
				}
				if (actions[1].equals("emperor_scorpion")) {
					intent.setAction(MODSIntents.EMPEROR_SCORPION);
				}
				if (actions[1].equals("tailless_whip_scorpion")) {
					intent.setAction(MODSIntents.TAILLESS_WHIP_SCORPION);
				}
				if (actions[1].equals("red_claw_scorpion")) {
					intent.setAction(MODSIntents.RED_CLAW_SCORPION);
				}
				if (actions[1].equals("madagascar_hissing_cockroach")) {
					intent.setAction(MODSIntents.MADAGASCAR_HISSING_COCKROACH);
				}
				if (actions[1].equals("mexican_red_knee_tarantula")) {
					intent.setAction(MODSIntents.MEXICAN_RED_KNEE_TARANTULA);
				}
				if (actions[1].equals("mexican_blond_tarantula")) {
					intent.setAction(MODSIntents.MEXICAN_BLOND_TARANTULA);
				}
				if (actions[1].equals("pink_toe_tarantula")) {
					intent.setAction(MODSIntents.PINK_TOE_TARANTULA);
				}
				if (actions[1].equals("rose_haired_tarantula")) {
					intent.setAction(MODSIntents.ROSE_HAIRED_TARANTULA);
				}
				if (actions[1].equals("florida_ivory_millipede")) {
					intent.setAction(MODSIntents.FLORIDA_IVORY_MILLIPEDE);
				}
				
				sendBroadcast(intent);
			}
		}
	}
}