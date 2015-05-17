import greenfoot.*;

/**
 * Write a description of class Comida here.
 * 
 * @author Hugo Limón, Valeria Cortez 
 * @version 1.0
 */
public class Comida extends Actor
{
    /**
     * Act - do whatever the Comida wants to do. This method is called whenever
     * 
     */
    private SimpleTimer timer;
    /**
     * this varible is used to set velocity of food's fall
     */
    public int velCaida;
    public Comida(){
        timer=new SimpleTimer();
        timer.mark();
        

    }
    /**
     * this method is make the food fall from the sky
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
     * this method is for check the object which touch the food
     */
    public boolean tocaComida(){
        return(this.isTouching(Comida.class));
    
    }
}
