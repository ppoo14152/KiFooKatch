import greenfoot.*;

/**
 * Write a description of class Plato here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plato extends Actor
{
    public Plato() 
    {
        setImage(imagen());
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
