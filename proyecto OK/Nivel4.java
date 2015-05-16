import greenfoot.*;

/**
 * Write a description of class Nivel4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel4 extends Actor
{
   
    public Nivel4(){
    setImage(imagen(300,75));
    }
     public GreenfootImage imagen(int x, int y){
      GreenfootImage i=getImage();
      i.scale(x,y);
      return i;
    
    } 
}
