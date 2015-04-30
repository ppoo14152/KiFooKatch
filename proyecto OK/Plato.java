import greenfoot.*;

/**
 * Write a description of class Plato here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plato extends Actor
{
    /**
     * Act - do whatever the Plato wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Plato() 
    {
        setImage(imagen());// Add your action code here.
    } 

    public boolean isTouchComidaS(){
    
            return isTouching(ComidaSana.class);
        
    }
    public boolean isTouchComidaM(){
    
            return isTouching(ComidaMala.class);
        
    }
    public void eliminaComida(){
       removeTouching(Comida.class);
    }
    
    public GreenfootImage imagen(){
        GreenfootImage i =getImage();
        i.scale(70,50);
        return i;

    }
}
