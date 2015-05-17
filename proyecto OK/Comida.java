import greenfoot.*;

/**
 * This class is used for the food
 * 
 * @author Hugo Limón, Valeria Cortez 
 * @version 1.0
 */
public class Comida extends Actor
{
    
    private SimpleTimer timer;
    /**
     * This varible is used to set the velocity of the food's fall.
     */
    public int velCaida;
    public Comida(){
        timer=new SimpleTimer();
        timer.mark();
        

    }
    /**
     * This method is used to make the food fall from the sky.
     */
    public void cae() 
    {
        if(timer.millisElapsed()>(Greenfoot.getRandomNumber(10))*velCaida)
        {

            this.setLocation(getX(),getY()+5);
            timer.mark();

        }
        
    }   
    /**
     * This method is used to check whether if the food fell to the floor.
     * @return true if it feel, false if it didn't.
     */
    public boolean tocaComida(){
        return(this.isTouching(Comida.class));
    
    }
}
