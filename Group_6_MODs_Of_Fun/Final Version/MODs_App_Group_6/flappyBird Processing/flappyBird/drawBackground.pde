void drawBackground(){
  image(background,0,BGY); 
  if(!hit)
  {
  baseInc-=10;
  if(baseInc<-100) baseInc=0;
  }
}
