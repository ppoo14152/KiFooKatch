import greenfoot.*;

/**
 * This class is used to create a signal at the begining of the game
 * 
 * @author Hugo Limón, Valeria Cortez 
 * @version 0.1
 */
public class Aviso extends Actor
{
    
    public Aviso() 
    {
        setImage(imagen(200,200));
        
    }    
    
    /**
     * This method is used to return an scaled image for the given object
     * @param x is the size in x axis
     * @param y is the size in the y axis
     * @return The scaled image for the object to use
     */
    public GreenfootImage imagen(int x,int y){
      GreenfootImage i=getImage();
      i.scale(x,y);
      return i;
    
    }
}
