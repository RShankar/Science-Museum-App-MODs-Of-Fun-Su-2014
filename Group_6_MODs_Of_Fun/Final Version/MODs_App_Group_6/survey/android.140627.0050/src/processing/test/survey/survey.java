package processing.test.survey;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ketai.sensors.*; 
import ketai.ui.*; 
import android.view.MotionEvent; 
import com.parse.Parse; 
import java.util.List; 
import com.parse.ParseAnalytics; 
import com.parse.ParseObject; 
import apwidgets.*; 
import android.text.InputType; 
import android.view.inputmethod.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class survey extends PApplet {













APWidgetContainer widgetContainer; 
APButton submit;

PImage img1;
PImage ystar;
PImage gstar;
PImage image1, image2, image3, image4, image5;
KetaiGesture gesture;

List<Record> recordList;

public void setup(){
Parse.initialize(this, "uwezT1TXov6KAkO0r7IZwKgN6w8DHxFWJfW6WXAR", "eKdJ4jxto7yfUpoRgJ6ezI8PSRLcirgrATIgXIeP");
  
recordList = new ArrayList<Record>();

widgetContainer = new APWidgetContainer(this); //create new container for widgets
 submit = new APButton(width/2, 9*height/10, "submit");
  widgetContainer.addWidget(submit);  
  
img1 = loadImage("Survey Screen.png");
ystar = loadImage("yellow_star.png");
gstar = loadImage("grey_star.png");
ystar.resize(150, 150);
gstar.resize(150, 150);
ystar.loadPixels();
gstar.loadPixels();
gesture = new KetaiGesture(this);
image1 = gstar;
image2 = gstar;
image3 = gstar;
image4 = gstar;
image5 = gstar;
}
 
public void draw() {
  
  image(img1, 0, 0);
  image(image1, 100, 1459);
  image(image2, 330, 1459);
  image(image3, 563, 1459);
  image(image4, 753, 1459);
  image(image5, 1018, 1459);
  text("What do you think \n " + " of this app? Rate it \n " + " down below! \n \n" + "Double tap to \n" + " set stars to 0." , width/2, 4*height/7);
  textSize(90);
  textAlign(CENTER, CENTER);
  
}

public void onTap(float x, float y) {
  if((mouseX <= 300) && (mouseX >= 100) &&(mouseY >= 1550) && (mouseY <= 1650)){
  image1 = ystar;
  recordList.add(new Record(1));
  }
  else if((mouseX <= 500) && (mouseX >= 300) &&(mouseY >= 1550) && (mouseY <= 1650)){
  image1 = ystar;
  image2 = ystar;
  recordList.add(new Record(2));
  }
  else if((mouseX <= 750) && (mouseX >= 550) &&(mouseY >= 1550) && (mouseY <= 1650)){
  image1 = ystar;
  image2 = ystar;
  image3 = ystar;
  recordList.add(new Record(3));
  }
  else if((mouseX <= 1000) && (mouseX >= 800) &&(mouseY >= 1550) && (mouseY <= 1650)){
  image1 = ystar;
  image2 = ystar;
  image3 = ystar;
  image4 = ystar;
  recordList.add(new Record(4));
  }
  else if((mouseX <= 1300) && (mouseX >= 1000) &&(mouseY >= 1550) && (mouseY <= 1650)){
  image1 = ystar;
  image2 = ystar;
  image3 = ystar;
  image4 = ystar;
  image5 = ystar;
  recordList.add(new Record(5));
  }
  print("YES");
}

public void onDoubleTap(float x, float y){
image1 = gstar;
image2 = gstar;
image3 = gstar;
image4 = gstar;
image5 = gstar;

}

public void onClickWidget(APWidget widget){
  
  if(widget == submit){ 
    saveToParse("TestClass", recordList);//if it was button1 that was clicked
  //set the smaller size
  }
  
}

public void saveToParse(String className, List<Record> recordList)

{

for(Record r : recordList)

 {

ParseObject pObj = new ParseObject(className);

pObj.put("Rating", r.getRating());

pObj.saveInBackground();

 }

}

public boolean surfaceTouchEvent(MotionEvent event) {
  super.surfaceTouchEvent(event);
  return gesture.surfaceTouchEvent(event);
  
}

class Record
{
  int rating;
  
  /**
   * Class constructor.
   *
   * @param   timestamp  The timestamp in nanoseconds
   * @param   x          The x force in m/s^2
   * @param   y          The y force in m/s^2
   * @param   z          The z force in m/s^2
   */
  Record(int rating)
  {
    this.rating = rating;
  }
  
  public int getRating() {
    return rating;
  }
}

}
