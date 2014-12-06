
import ketai.sensors.*;
//import ddf.minim.*;
import apwidgets.*;
import android.os.Environment;


APMediaPlayer wingSound, hitSound, scoreSound, dieSound;
//Minim minim;
Table tsv;

ArrayList<Stump> stumps;

float stumpMIN=0,stumpMAX=0,stumpDiffY=150,stumpDiffX=250;
int stumpCount=0;
int birdX,score=0,nextStump=0,i,TopScore;
PImage[] imgNumBig,imgNumSmall;

Boolean hit=false,hitSnd=false,stumpHit=false,gameOver=false;
PVector birdPosition,velocity,gravity,up;
PImage[] bird;
PImage background,base,stump,stumpi;
int brd=0,deg=0,baseInc=0;
float BY,BGY;


int scene=0;
PImage imgTitle,imgGetReady;
PImage imageGameOver,imageScoreCard,imageClick,goldScoreCard, funFact1, funFact2, funFact3, funFact4, funFact5, funFact6, funFact7, funFact8, funFact9, funFact10, funFact11, funFact12, funFact13, funFact14, funFact15, funFact16, funFact17, funFact18, funFact19, funFact20, funFact21, funFact22, funFact23, funFact24, funFact25;
int gameOverPosY,scoreCardPosY;
int a;
char ch;

void setup(){
  size(displayWidth, displayHeight);
  //topScoreFileLoader();
  orientation(LANDSCAPE);
  frameRate(120);
  a = (int)random(25);
  
  wingSound = new APMediaPlayer(this); //create new APMediaPlayer
  wingSound.setMediaFile("wing.mp3"); //set the file (files are in data folder)
  //wingSound.start(); //start play back
  //wingSound.setLooping(true); //restart playback end reached
  wingSound.setVolume(1.0, 1.0); //Set left and right volumes. Range is from 0.0 to 1.0
  
  hitSound = new APMediaPlayer(this); //create new APMediaPlayer
  hitSound.setMediaFile("hit.mp3"); //set the file (files are in data folder)
  //hitSound.start(); //start play back
  //hitSound.setLooping(true); //restart playback end reached
  hitSound.setVolume(1.0, 1.0); //Set left and right volumes. Range is from 0.0 to 1.0
  
  scoreSound = new APMediaPlayer(this); //create new APMediaPlayer
  scoreSound.setMediaFile("point.mp3"); //set the file (files are in data folder)
  //scoreSound.start(); //start play back
  //scoreSound.setLooping(true); //restart playback end reached
  scoreSound.setVolume(1.0, 1.0); //Set left and right volumes. Range is from 0.0 to 1.0
  
  dieSound = new APMediaPlayer(this); //create new APMediaPlayer
  dieSound.setMediaFile("die.mp3"); //set the file (files are in data folder)
  //dieSound.start(); //start play back
  //dieSound.setLooping(true); //restart playback end reached
  dieSound.setVolume(1.0, 1.0); //Set left and right volumes. Range is from 0.0 to 1.0
  
  /*
  wingSound = minim.loadSample("wing.mp3",512);
  hitSound = minim.loadSample("hit.mp3",512);
  scoreSound  = minim.loadSample("point.mp3",512);
  dieSound = minim.loadSample("die.mp3",512);
  */
  imgNumBig = new PImage[10];
  imgNumSmall = new PImage[10];
    for(i=0;i<10;i++){
      imgNumBig[i]=loadImage(i+".png");
      imgNumBig[i].resize(((26*height)/700),((36*height)/700));
      imgNumBig[i].loadPixels();
      
      imgNumSmall[i]=loadImage(i+".png");
      imgNumSmall[i].resize(((13*height)/700),((18*height)/700));
      imgNumSmall[i].loadPixels();
      
    }
  
  tsv = new Table();
  // make the header columns for the table
  tsv.addColumn("High Score");
  
  bird = new PImage[3];
  bird[0]=loadImage("turtle.png");
  bird[1]=loadImage("turtle.png");
  bird[2]=loadImage("turtle.png");

  bird[0].resize(((34*height)/700), ((24*height)/700));
  bird[0].loadPixels();
  bird[1].resize(((34*height)/700), ((24*height)/700));
  bird[1].loadPixels();
  bird[2].resize(((34*height)/700), ((24*height)/700));
  bird[2].loadPixels();
  
  base=loadImage("turtle_base.png");
  stump=loadImage("stump.png");
  stumpi=loadImage("stumpi.png");
  
  base.resize(width+100, ((111*height)/700));
  base.loadPixels();
  stump.resize(((52*height)/700),((489*height)/700));
  stump.loadPixels();
  stumpi.resize(((52*height)/700),((489*height)/700));
  stumpi.loadPixels();
  
  stumps = new ArrayList<Stump>();
  stumpCount = (int) (width/(stumpDiffX+stump.width));
  stumpCount++;
  stumps.add(new Stump(random(stumpMIN,stumpMAX),0));
  for(int k=1;k<=stumpCount;k++){
    stumps.add(new Stump(random(stumpMIN,stumpMAX),stumpDiffX*k));
  }  
    imgTitle=loadImage("title.png");
    imgTitle.resize(((178*height)/700), ((48*height)/700));
    imgTitle.loadPixels();
    
    imgGetReady=loadImage("getReady.png");
    imgGetReady.resize(((184*height)/700), ((42*height)/700));
    imgGetReady.loadPixels();
    
    imageGameOver=loadImage("gameOver.png");
    imageGameOver.resize(((192*height)/700), ((42*height)/700));
    imageGameOver.loadPixels();
    
    imageScoreCard=loadImage("scoreCard.png");
    imageScoreCard.resize(((226*height)/700), ((114*height)/700));
    imageScoreCard.loadPixels();
    
    imageClick=loadImage("click.png");
    imageClick.resize(((114*height)/700), ((98*height)/700));
    imageClick.loadPixels();
    
    goldScoreCard=loadImage("goldScoreCard.png");
    goldScoreCard.resize(((226*height)/700), ((114*height)/700));
    goldScoreCard.loadPixels();
    
    funFact1 = loadImage("fun fact #1.png");
    funFact2 = loadImage("fun fact #2.png");
    funFact3 = loadImage("fun fact #3.png");
    funFact4 = loadImage("fun fact #4.png");
    funFact5 = loadImage("fun fact #5.png");
    funFact6 = loadImage("fun fact #6.png");
    funFact7 = loadImage("fun fact #7.png");
    funFact8 = loadImage("fun fact #8.png");
    funFact9 = loadImage("fun fact #9.png");
    funFact10 = loadImage("fun fact #10.png");
    funFact11 = loadImage("fun fact #11.png");
    funFact12 = loadImage("fun fact #12.png");
    funFact13 = loadImage("fun fact #13.png");
    funFact14 = loadImage("fun fact #14.png");
    funFact15 = loadImage("fun fact #15.png");
    funFact16 = loadImage("fun fact #16.png");
    funFact17 = loadImage("fun fact #17.png");
    funFact18 = loadImage("fun fact #18.png");
    funFact19 = loadImage("fun fact #19.png");
    funFact20 = loadImage("fun fact #20.png");
    funFact21 = loadImage("fun fact #21.png");
    funFact22 = loadImage("fun fact #22.png");
    funFact23 = loadImage("fun fact #23.png");
    funFact24 = loadImage("fun fact #24.png");
    funFact25 = loadImage("fun fact #25.png");

 initORreset();
  
}
void draw(){
  
 //if(ch=='L'){ lc=1;}
 //if(ch=='R'){ lc=0;}
 if (keyPressed) {
 if(key =='R'|| key =='L')//if(lc==1)
 {
    switch(scene)
  {
    case 0:    //title screen
      scene=1;
      break;
    case 1:   //get ready
      scene=2;
      break;
    case 2:   //game
      if(!stumpHit)
      {
        velocity.add(up);
        wingSound.start();
      }
      break;
    case 3:   //game over
      initORreset();
      scene=1;
      break;
  }
 }
 }
 
  TableRow row  = tsv.addRow();
  row.setInt("High Score", TopScore);
  drawBackground();
  textSize(35);
  fill(255,100);
  textAlign(CENTER);  
  
  switch(scene)
  {
    case 0:
    case 1:
             image(base,baseInc,BY);
             if(scene==0)
             {
               image(imgTitle,width/2 - imgTitle.width/2,height/4);
               image(bird[brd/10],width/2 - bird[0].width/2,height/2 + sin(radians(deg)*10)*5 -50);
             }
             else
             {
               image(imgGetReady,width/2 - imgGetReady.width/2,height/4);
               image(bird[brd/10],width/4,height/2 + sin(radians(deg)*10)*5 -50);
               image(imageClick,width/2 - imageClick.width/2,height/3 +50);
             }
             
             brd+=1;
              deg+=1;
           if(brd>20) brd=0;
           if(deg>360) deg=0;
            break;
    
    case 2:
      for(int k=0;k<stumps.size();k++){
        Stump st = stumps.get(k);
        st.checkHit();
        if(!stumpHit && !hit)
        {
          st.checkPassed();
          checkScored();
          st.update();
        }
        else
        {
          gameOver=true;
        }
        st.display();
      }
      
      
      image(base,baseInc,BY);
      flyingBird();
      /*stroke(0);
      line(0,stumpMIN,width,stumpMIN);
      stroke(#ffffff);
      line(0,stumpMAX,width,stumpMAX);*/
      if(hitSnd){hitSound.start(); fill(255); for(int z=0;z<100;z++) rect(0,0,width,height); hitSnd=false; if(stumpHit) dieSound.start();}
      printNum(score,width/2,height/6,'b');
      break;
    case 3:
        for(int k=0;k<stumps.size();k++){
          Stump st1 = stumps.get(k);
          println(stumps.get(k));
          st1.display();
        }
        image(base,baseInc,BY);
        translate(birdPosition.x,birdPosition.y);
        rotate(radians(90));
        image(bird[0],-bird[0].width/2,-bird[0].height/2);
        resetMatrix();
        if(gameOverPosY<height/6) gameOverPosY+=5;
        if(scoreCardPosY>height/6 +100) scoreCardPosY-=10;
        image(imageGameOver,width/2 - imageGameOver.width/2,gameOverPosY + 100);
        if(score>TopScore)
        image(goldScoreCard,width/2 - goldScoreCard.width/2,height/2 - 175);
        else
        image(imageScoreCard,width/2 - imageScoreCard.width/2,height/2 - 175);
        //print Topscore
        printNum(score>TopScore?score:TopScore,width/2 + 120,scoreCardPosY+215,'s');
       
        printNum(score,width/2 + 120,scoreCardPosY+145,'s');
        if(a == 1){
        image(funFact1, (width*3)/5+25, height/10);  
        }
        else if(a == 2){
        image(funFact2, (width*3)/5+25, height/10);  
        }
      else if(a == 3){
        image(funFact3, (width*3)/5+25, height/10);  
        }
      else if(a == 4){
        image(funFact4, (width*3)/5+25, height/10);  
        }
      else if(a == 5){
        image(funFact5, (width*3)/5+25, height/10);  
        }
      else if(a == 6){
        image(funFact6, (width*3)/5+25, height/10);  
        }
      else if(a == 7){
        image(funFact7, (width*3)/5+25, height/10);  
        }
      else if(a == 8){
        image(funFact8, (width*3)/5+25, height/10);  
        }
      else if(a == 9){
        image(funFact9, (width*3)/5+25, height/10);  
        }
      else if(a == 10){
        image(funFact10, (width*3)/5+25, height/10);  
        }
      else if(a == 11){
        image(funFact1, (width*3)/5+25, height/10);  
        }
      else if(a == 12){
        image(funFact12, (width*3)/5+25, height/10);  
        }
      else if(a == 13){
        image(funFact13, (width*3)/5+25, height/10);  
        }
      else if(a == 14){
        image(funFact14, (width*3)/5+25, height/10);  
        }
      else if(a == 15){
        image(funFact15, (width*3)/5+25, height/10);  
        } 
       else if(a == 16){
        image(funFact16, (width*3)/5+25, height/10);  
        }  
       else if(a == 17){
        image(funFact17, (width*3)/5+25, height/10);  
        }  
       else if(a == 18){
        image(funFact18, (width*3)/5+25, height/10);  
        }  
       else if(a == 19){
        image(funFact19, (width*3)/5+25, height/10);  
        }  
       else if(a == 20){
        image(funFact20, (width*3)/5+25, height/10);  
        }  
       else if(a == 21){
        image(funFact21, (width*3)/5+25, height/10);  
        }  
       else if(a == 22){
        image(funFact22, (width*3)/5+25, height/10);  
        }  
       else if(a == 23){
        image(funFact23, (width*3)/5+25, height/10);  
        }  
       else if(a == 24){
        image(funFact24, (width*3)/5+25, height/10);  
        }
       else {
        image(funFact25, (width*3)/5+25, height/10);  
        } 

        
        break;
  }
  
  
        
  
}
void mousePressed(){
    switch(scene)
  {
    case 0:    //title screen
      scene=1;
      break;
    case 1:   //get ready
      scene=2;
      break;
    case 2:   //game
      if(!stumpHit)
      {
        velocity.add(up);
        wingSound.start();
      }
      break;
    case 3:   //game over
      initORreset();
      scene=1;
      a = (int) random(25);
      break;
  }
}

void initORreset()
{
  if(score>TopScore)
  {
    TopScore=score;
    saveFile("high_score_data", tsv);
    //topScoreFileUpdator();
  }
  hit=false;hitSnd=false;stumpHit=false;gameOver=false;
  score=0;nextStump=0;
  birdX=width/4;
  birdPosition = new PVector(birdX,height/2 -50);
  velocity = new PVector(0,0);
  gravity = new PVector(0,0.4);
  up = new PVector(0,-8);
    if((int)random(2)<1){
    background=loadImage("turtle_background.png");
    background.resize(width, ((683*height)/700));
   background.loadPixels(); 
  }
  else{
    background=loadImage("turtle_background.png");
    background.resize(width, ((683*height)/700));
   background.loadPixels(); 
  }
    BGY=-1*(background.height-height+base.height);
  BY=height-base.height;
  
  stumpMIN = BY/6;
  stumpMAX = BY-stumpDiffY-stumpMIN;
      gameOverPosY=imageGameOver.height*-1;
    scoreCardPosY=height;
     
 // print(stumps.size());
  for(int k=0;k<stumps.size();k++){
        Stump st2 = stumps.get(k);
        st2.posY=random(stumpMIN,stumpMAX);
        st2.posX=stumpDiffX*k+width;
  }  
}

void saveFile(String name, Table table){
  
  String directory;
  
  try{
    
    directory = new String(Environment
           .getExternalStorageDirectory()
            .getAbsolutePath());
    table.save(new File(directory+"/"+name+".tsv"), "tsv");
    
    println("File write successful");
    
  }catch(IOException iox){
    println("Failed to write file: "+iox.getMessage());
  } 
}

