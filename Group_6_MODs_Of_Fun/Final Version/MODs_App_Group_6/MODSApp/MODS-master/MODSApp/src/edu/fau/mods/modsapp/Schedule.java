package edu.fau.mods.modsapp;

import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;

public class Schedule extends ExpandableListActivity {

	private ArrayList<String> parentItems = new ArrayList<String>();
	private ArrayList<Object> childItems = new ArrayList<Object>();

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		ExpandableListView expandableList = getExpandableListView(); 

		expandableList.setDividerHeight(2);
		expandableList.setGroupIndicator(null);
		expandableList.setClickable(true);

		setGroupParents();
		setChildData();

		ExpandableAdapter adapter = new ExpandableAdapter(parentItems,
				childItems);

		adapter.setInflater(
				(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),
				this);
		expandableList.setAdapter(adapter);
		expandableList.setOnChildClickListener(this);
	}

	public void setGroupParents() {
		parentItems.add("Mar 8-9: Babies, Blooms and Butterflies");
		parentItems.add("Mar 21-26: Lady Bug Release");
		parentItems.add("Mar 27-30: Spring Into Action");
		parentItems.add("Apr 5-6: Leapin' Lemurs");
		parentItems.add("May 3-4: Asian-Pacific American Heritage Celebration");
		parentItems.add("May 24-26: Maker's Square Faire");
		parentItems.add("May 31-Jun 1: Changing Seas");
	}

	public void setChildData() {

		// Babies, Blooms and Butterflies
		ArrayList<String> child = new ArrayList<String>();
		child.add("A Flurry of Butterflies");
		child.add("Make and Take");
		child.add("IMAX: Flight of the Butteflies");
		child.add("South Florida Burd Club");
		child.add("Eco-Gardening Techniques");
		childItems.add(child);

		// Lady Bug Release
		child = new ArrayList<String>();
		child.add("Lady Bug Release");
		child.add("Scavenger Hunt");
		child.add("Camouflage Game Show");
		childItems.add(child);

		// Spring Into Action
		child = new ArrayList<String>();
		child.add("Mar 27: Dietition/Nutrition");
		child.add("Mar 28: Athletic Trainers/Sports Medicine");
		child.add("Mar 29: Exercise Physiologists/Exercise Demo");
		child.add("Mar 30: Fitness Demonstrations");
		childItems.add(child);

		// Leapin' Lemus
		child = new ArrayList<String>();
		child.add("IMAX:Island of Lemurs");
		child.add("Saving the Lemurs");
		child.add("Become a Lemur");
		childItems.add(child);

		// Asian...Celebration
		child = new ArrayList<String>();
		child.add("Polynesian Proud Productions");
		child.add("\"Big Kahuna\" Surf School");
		child.add("Tama Warrior Arts");
		child.add("Ronin Taiko Japanese Drummers");
		childItems.add(child);

		// Makers Square Faire
		child = new ArrayList<String>();
		child.add("3D Fabrication");
		child.add("Carpentry");
		child.add("Metalwork");
		child.add("Aquaponics");
		child.add("Textiles/Sewing");
		childItems.add(child);

		// Changing Seas
		child = new ArrayList<String>();
		child.add("1pm & 3pm: Narrated Screenings");
		child.add("Meet the Experts");
		child.add("12pm-4pm: The \"Changing Seas\" Lab");
		childItems.add(child);
	}

}
