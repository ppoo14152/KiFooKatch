import greenfoot.*;

/**
 * Class for all the butons used in tthe menu
 * 
 * @author Hugo Limón, Valeria Cortez 
 * @version 0.1
*/
public class Boton extends Actor
{
    
    public Boton() 
    {
        setImage(getImage());
    }
    
    /**
     * This method is used to return an scaled image for the given object
     * @param x is the size in x axis
     * @param y is the size in the y axis
     * @return The scaled image for the object to use
     */    
    public GreenfootImage imagen(int x, int y){
       GreenfootImage i=getImage();
       i.scale(x,y);
       return i;
    
    }
}
