import greenfoot.*;

/**
<<<<<<< .mine
 * This class is used to create the floor
 * 
 * @author Hugo Limón, Valeria Cortez 
 * @version 17/05/13
=======
 * The class Suelo is used to detect when the food is on the floor  
 * @author Hugo Enrique Limon Castillo, Estefani Cortez Gutierrez
 * @version 0.1
>>>>>>> .r85
 */
public class Suelo extends Actor
{
    public Suelo() 
    {
        setImage(imagen(800,30));
    }
    /**
     * act remove the food that touch its 
     */
    /**
     * The act method only check whether if the floor is touching any kind of food,
     * which would mean that the player let the food spill
     */
    
    public void act(){
        
        if(isTouching(Comida.class)){
            eliminaComida();
        }
    
    }
<<<<<<< .mine
    
    /**
     * This method is used to return an scaled image for the given object
     * @param x is the size in x axis
     * @param y is the size in the y axis
     * @return The scaled image for the object to use
     */
=======
    /**
     * this method is for change the size of the image
     */
>>>>>>> .r85
    public GreenfootImage imagen(int x, int y){
        GreenfootImage i=getImage();
        i.scale(x,y);
        return i;
    }
    
<<<<<<< .mine
    /**
     * This method determines whether if the fallen food was healthy
     * @return true if touching, false if not
     */
    
=======
    /**
     *  tocaComidaSana()
     *  @return it return boolean when it is touching an object of kind ComidaSana
     */
>>>>>>> .r85
    public boolean tocaComidaSana(){
        return(this.isTouching(ComidaSana.class));
    }
<<<<<<< .mine
    
    /**
     * This method determines wheter if the floor is touching any kind of food
     * @return true if touching, flase if not
     */
    public boolean tocaComida(){
=======
    /**
     *  tocaComidaSana()
     *  @return it return boolean when it is touching an object of kind Comida
     */public boolean tocaComida(){
>>>>>>> .r85
        return(this.isTouching(Comida.class));
    
    }
    /**
    tocaComidaSana()
    * this method it for revome the foot that touch the floor
    */
    /**
     * This method removes the fallen food
     */
    public void eliminaComida(){
        removeTouching(Comida.class);    
    }
}
