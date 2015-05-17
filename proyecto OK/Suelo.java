import greenfoot.*;

/**
 * The class Suelo is used to detect when the food is on the floor   
 * @author Hugo Limón, Valeria Cortez 
 * @version 0.1
 */
public class Suelo extends Actor
{
    public Suelo() 
    {
        setImage(imagen(800,30));
    }
    
    /**
     * The act method only check whether if the floor is touching any kind of food,
     * which would mean that the player let the food spill
     */
    
    public void act(){
        
        if(isTouching(Comida.class)){
            eliminaComida();
        }
    
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
    
    /**
     * This method determines whether if the fallen food was healthy
     * @return true if touching, false if not
     */

    public boolean tocaComidaSana(){
        return(this.isTouching(ComidaSana.class));
    }
    
    /**
     * This method determines whether if the floor is touching any kind of food
     * @return true if touching, flase if not
     */
    public boolean tocaComida(){

        return(this.isTouching(Comida.class));
    
    }

    /**
     * This method removes the fallen food
     */
    public void eliminaComida(){
        removeTouching(Comida.class);    
    }
}
