package processing.test.location_mods;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import apwidgets.*; 
import android.text.InputType; 
import android.view.inputmethod.*; 
import ketai.sensors.*; 
import ketai.ui.*; 
import android.view.MotionEvent; 
import android.location.Location; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class location_mods extends PApplet {





APWidgetContainer widgetContainer; 
APEditText textField;
APButton submit;





boolean b = false;

KetaiLocation location;
KetaiSensor sensor;
KetaiGesture gesture;
Location destination;
PVector locationVector = new PVector();
float compass;  //(1)

PImage img1;

int h, w;
int a;

public void setup() {
  
  img1 = loadImage("floor1.png");
  image(img1, 0, 0);
  orientation(PORTRAIT);
  
  widgetContainer = new APWidgetContainer(this); //create new container for widgets
  textField = new APEditText((width/2)-100, height/10, 200, 100); //create a textfield from x- and y-pos., width and height
  submit = new APButton(((width*4)/5), 50, "submit");
  widgetContainer.addWidget(textField); //place textField in container
  widgetContainer.addWidget(submit); 
 

  gesture = new KetaiGesture(this);
  
  location = new KetaiLocation(this);
  sensor = new KetaiSensor(this);
  sensor.start();
  orientation(PORTRAIT);
  textAlign(CENTER, CENTER);
  textSize(28);
  smooth(); 

}

public void draw(){
  
    image(img1, 0, 0);
    ellipse(w, h, 100, 100);
    fill(0);
    text("LONG PRESS THE SCREEN TO ENTER NAVIGATION MODE", width/2, (4*height)/7);
    text("PLEASE ENTER WHICH DESTINATION YOU WOULD LIKE TO TRAVEL TO", width/2, (4*height)/7 - 100);
    text("WHEN YOU ARE IN NAVIGATION MODE, PLACE DEVICE FLAT FOR BEST RESULTS", width/2, ((4*height)/7) + 75);
    text("WHEN YOU ARE IN NAVIGATION MODE, TAP SCREEN TO RETURN TO MAP", width/2, ((4*height)/7) + 150);
     //display the text in the text field
  if(b) {
 
  if(w == width/2 && h == height/2) {
    widgetContainer.removeWidget(textField);
  widgetContainer.removeWidget(submit);
    background(78, 93, 75);
    print("IT WORKS");
   float bearing = location.getLocation().bearingTo(destination);  //(2)
   float distance = location.getLocation().distanceTo(destination);
    translate(width/2, height/2);  //(3)
    rotate(radians(bearing) - radians(compass));  //(4)
    stroke(255);
    fill(0);
    triangle(-width/4, 0, width/4, 0, 0, -width/2);  //(5)
    text((int)distance + " m", 0, 50);
    text(nf(distance*3.28084f, 0, 2) + " ft", 0, 100);  //(6)
    fill(0);
    text("TAP TO GO BACK TO PREVIOUS SCREEN", width/2, height*5/7);
    
    
    //text("Tap to exit this screen", width/2,((3*height)/4));
    //text("Lay your device flat to achieve the best results", width/2+100,((3*height)/4)+100); 
  }
  }
  
}



public void onClickWidget(APWidget widget){
  
  if(widget == submit){ //if it was button1 that was clicked
  w = width/2;
   h = height/2;
    if((textField.getText().equals("restroom") == true) || (textField.getText().equals("Restroom") == true) || (textField.getText().equals("restroom ") == true) || (textField.getText().equals("Restroom ") == true)) {
   destination = new Location("restroom"); 
    destination.setLatitude(26.121337f);
   destination.setLongitude(-80.147814f);
   fill(82);
   
  }
  else if((textField.getText().equals("airboat") == true) || (textField.getText().equals("airboat ") == true) || (textField.getText().equals("Airboat ") == true) || (textField.getText().equals("Airboat ") == true)|| (textField.getText().equals("Airboat Ride ") == true)|| (textField.getText().equals("Airboat Ride") == true) || (textField.getText().equals("airboat ride ") == true) || (textField.getText().equals("airboat ride") == true)) {
   destination = new Location("airboat ride"); 
   destination.setLatitude(26.121357f);
   destination.setLongitude(-80.148092f);
   
  }
  else if((textField.getText().equals("prehistoric florida") == true) || (textField.getText().equals("prehistoric florida ") == true) || (textField.getText().equals("Prehistoric Florida ") == true) || (textField.getText().equals("Prehistoric Florida") == true)|| (textField.getText().equals("prehistoric ") == true)|| (textField.getText().equals("prehistoric") == true) || (textField.getText().equals("Prehistoric ") == true) || (textField.getText().equals("Prehistoric") == true)) {
   destination = new Location("prehistoric florida"); 
   destination.setLatitude(26.121364f);
   destination.setLongitude(-80.147918f);
  }
  else if((textField.getText().equals("otter viewing") == true) || (textField.getText().equals("otter viewing ") == true) || (textField.getText().equals("Otter Viewing ") == true) || (textField.getText().equals("Otter Viewing") == true)|| (textField.getText().equals("otters ") == true)|| (textField.getText().equals("otters") == true) || (textField.getText().equals("Otters ") == true) || (textField.getText().equals("Otters") == true)) {
   destination = new Location("otter viewing"); 
   destination.setLatitude(26.121404f);
   destination.setLongitude(-80.147778f);
  }
  else if((textField.getText().equals("storm center") == true) || (textField.getText().equals("storm center ") == true) || (textField.getText().equals("Storm Center ") == true) || (textField.getText().equals("Storm Center") == true)|| (textField.getText().equals("storm ") == true)|| (textField.getText().equals("storm") == true) || (textField.getText().equals("Storm ") == true) || (textField.getText().equals("Storm") == true)) {
   destination = new Location("storm center"); 
   destination.setLatitude(26.12128f);
   destination.setLongitude(-80.148053f);
  }
  else if((textField.getText().equals("go green") == true) || (textField.getText().equals("go green ") == true) || (textField.getText().equals("Go Green ") == true) || (textField.getText().equals("Go Green") == true)|| (textField.getText().equals("green ") == true)|| (textField.getText().equals("green") == true) || (textField.getText().equals("Green ") == true) || (textField.getText().equals("Green") == true)) {
   destination = new Location("go green"); 
   destination.setLatitude(26.121232f);
   destination.setLongitude(-80.148052f);
  }
  else if((textField.getText().equals("discovery center") == true) || (textField.getText().equals("discovery center ") == true) || (textField.getText().equals("Discovery Center ") == true) || (textField.getText().equals("Discovery Center") == true)|| (textField.getText().equals("discovery ") == true)|| (textField.getText().equals("discovery") == true) || (textField.getText().equals("Discovery ") == true) || (textField.getText().equals("Discovery") == true)) {
   destination = new Location("discovery center"); 
   destination.setLatitude(26.121072f);
   destination.setLongitude(-80.148069f);
  }
  else if((textField.getText().equals("florida ecoscapes") == true) || (textField.getText().equals("florida ecoscapes ") == true) || (textField.getText().equals("Florida Ecoscapes ") == true) || (textField.getText().equals("Florida Ecoscapes") == true)|| (textField.getText().equals("ecoscapes ") == true)|| (textField.getText().equals("ecoscapes") == true) || (textField.getText().equals("Ecoscapes ") == true) || (textField.getText().equals("Ecoscapes") == true)) {
   destination = new Location("florida ecoscapes"); 
   destination.setLatitude(26.121039f);
   destination.setLongitude(-80.147998f);
  }
  else if((textField.getText().equals("elevator") == true) || (textField.getText().equals("elevator ") == true) || (textField.getText().equals("Elevator ") == true) || (textField.getText().equals("Elevator") == true)|| (textField.getText().equals("stairs ") == true)|| (textField.getText().equals("stairs") == true) || (textField.getText().equals("Stairs ") == true) || (textField.getText().equals("Stairs") == true)) {
	   destination = new Location("elevator"); 
	   destination.setLatitude(26.121237f);
	   destination.setLongitude(-80.147805f);
  }
  else if((textField.getText().equals("store") == true) || (textField.getText().equals("store ") == true) || (textField.getText().equals("Store ") == true) || (textField.getText().equals("Store") == true)|| (textField.getText().equals("shop ") == true)|| (textField.getText().equals("shop") == true) || (textField.getText().equals("Shop ") == true) || (textField.getText().equals("Shop") == true)) {
	   destination = new Location("store"); 
	   destination.setLatitude(26.120757f);
	   destination.setLongitude(-80.148014f);
  }
  else if((textField.getText().equals("help") == true) || (textField.getText().equals("Help ") == true) || (textField.getText().equals("help ") == true) || (textField.getText().equals("Help") == true)|| (textField.getText().equals("information ") == true)|| (textField.getText().equals("information") == true) || (textField.getText().equals("Information ") == true) || (textField.getText().equals("Information") == true)) {
	   destination = new Location("help desk"); 
	   destination.setLatitude(26.120924f);
	   destination.setLongitude(-80.147887f);
  }
  else if((textField.getText().equals("box office") == true) || (textField.getText().equals("box office ") == true) || (textField.getText().equals("Box Office ") == true) || (textField.getText().equals("Box Office") == true)|| (textField.getText().equals("tickets ") == true)|| (textField.getText().equals("tickets") == true) || (textField.getText().equals("Tickets ") == true) || (textField.getText().equals("Tickets") == true)) {
	   destination = new Location("box office"); 
	   destination.setLatitude(26.120822f);
	   destination.setLongitude(-80.147999f);
 }
  else if((textField.getText().equals("imax theater") == true) || (textField.getText().equals("imax theater ") == true) || (textField.getText().equals("Imax Theater ") == true) || (textField.getText().equals("Imax Theater") == true)|| (textField.getText().equals("theater ") == true)|| (textField.getText().equals("theater") == true) || (textField.getText().equals("Theater ") == true) || (textField.getText().equals("Theater") == true)) {
	   destination = new Location("imax theater"); 
	   destination.setLatitude(26.120784f);
	   destination.setLongitude(-80.147894f);
}
  else if((textField.getText().equals("entrance") == true) || (textField.getText().equals("entrance ") == true) || (textField.getText().equals("Entrance ") == true) || (textField.getText().equals("Entrance") == true)) {
	   destination = new Location("imax theater"); 
	   destination.setLatitude(26.120884f);
	   destination.setLongitude(-80.147919f);
}
    
  
  fill(82);
  //set the smaller size
  }
  
}


public void onLongPress(float x, float y) {
  b = true;
  print("HI");
  
 
}

public void onTap (float x, float y) {
  println("WORKS YAY");
  b = false;
  setup();
}

public void onLocationEvent(Location _location) {
  println("onLocation event: " + _location.toString());
  locationVector.x = (float)_location.getLatitude();  //(7)
  locationVector.y = (float)_location.getLongitude();
}
public void onOrientationEvent(float x, float y, float z, long time, int accuracy) { //(8)
  compass = x;  
  // Azimuth angle between magnetic north and device y-axis, around z-axis.
  // Range: 0 to 359 degrees
  // 0=North, 90=East, 180=South, 270=West 
}

public boolean surfaceTouchEvent(MotionEvent event) {
  super.surfaceTouchEvent(event);
  return gesture.surfaceTouchEvent(event);
  
}

}
