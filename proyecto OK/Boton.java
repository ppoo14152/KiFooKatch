import greenfoot.*;

/**
 * Write a description of class boton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boton extends Actor
{
    
    public Boton() 
    {
        setImage(getImage());// Add your action code here.
    }
    public GreenfootImage imagen(int x, int y){
      GreenfootImage i=getImage();
      i.scale(x,y);
      return i;
    
    }
}
