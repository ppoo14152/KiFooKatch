import greenfoot.*;

/**
 * Write a description of class boton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boton extends Actor
{
    /**
     * Act - do whatever the boton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
