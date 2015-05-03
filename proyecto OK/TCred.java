import greenfoot.*;

/**
 * Write a description of class TextoCreditos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TCred extends Texto
{
    /**
     * Act - do whatever the TextoCreditos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public void act() 
    {
        // Add your action code here.
        
        setImage(imagen(250,250));
    }
     public GreenfootImage imagen(int x, int y){
      GreenfootImage i=getImage();
      i.scale(x,y);
      return i;
    
    }  
}
