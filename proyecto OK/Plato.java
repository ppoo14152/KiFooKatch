import greenfoot.*;

/**
 * This class is used to create recipients that will move along with the hands 
 * in order to catch the food
 * 
 * @author Hugo Limón, Valeria Cortez 
 * @version 0.1
 */
public class Plato extends Actor
{
    public Plato() 
    {
        setImage(imagen());
    } 
    
    /**
     * This method is used to determine wheter if the recipient is touching healthy food or not.
     * 
     * @return true if touching, false if not
     */
    public boolean isTouchComidaS(){
    
            return isTouching(ComidaSana.class);
        
    }
    
    /**
     * This method is used to determine whether if the recipient is touchin junk food or not.
     * 
     * @return true if touching, false if not
     */
    public boolean isTouchComidaM(){
    
            return isTouching(ComidaMala.class);
        
    }
    
    /**
     * This method removes any kind of food touched by the recipient
     */
    public void eliminaComida(){
       removeTouching(Comida.class);
    }
    
     /**
     * This method is used to return an scaled image for the given object
     * @param x is the size in x axis
     * @param y is the size in the y axis
     * @return The scaled image for the object to use
     */
    public GreenfootImage imagen(){
        GreenfootImage i =getImage();
        i.scale(70,50);
        return i;

    }
}
