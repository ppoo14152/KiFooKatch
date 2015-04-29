import greenfoot.*;

/**
 * Write a description of class Aviso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aviso extends Actor
{
    /**
     * Act - do whatever the Aviso wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(imagen(200,200));
        
    }    
    public GreenfootImage imagen(int x,int y){
      GreenfootImage i=getImage();
      i.scale(x,y);
      return i;
    
    }
}
