import greenfoot.*;
import java.lang.*;

/**
 * This class is used to create sodas
 * 
 * @author Hugo Limón, Valeria Cortez
 * @version 0.1
 */
public class Soda extends ComidaMala

{
    /**
     *The constructor of the class Soda, sets the fall velocity
     *@param vel recives the fall velocity
     */
    public Soda(int vel){
        setImage(imagen());
        velCaida=vel;
    } 
    
    /**
     * This method is used for the object to fall when the run button is pressed 
     */
    public void act(){
        super.cae();
    }
    
    /**
     * This method is used to return an scaled image for the given object
     * @param x is the size in x axis
     * @param y is the size in the y axis
     * @return The scaled image for the object to use
     */
    public GreenfootImage imagen(){
        GreenfootImage i =getImage();
        i.scale(50,70);
        return i;
    
    }
}
