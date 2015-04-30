import greenfoot.*;

/**
 * Write a description of class Titulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Titulo extends Actor
{
    /**
     * Act - do whatever the Titulo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        setImage(imagen(600,100));
    }
     public GreenfootImage imagen(int x, int y){
      GreenfootImage i=getImage();
      i.scale(x,y);
      return i;
    
    }
}
