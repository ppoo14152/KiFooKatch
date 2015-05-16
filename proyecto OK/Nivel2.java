import greenfoot.*;

/**
 * Write a description of class Nivel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel2 extends Actor
{
   
    public Nivel2(){
        setImage(imagen(300, 75));
    
    }
    
     public GreenfootImage imagen(int x, int y){
      GreenfootImage i=getImage();
      i.scale(x,y);
      return i;
    
    }
}
