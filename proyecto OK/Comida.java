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
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private SimpleTimer timer;
    public int velCaida;
    public Comida(){
        timer=new SimpleTimer();
        timer.mark();
        

    }

    public void cae() 
    {
        if(timer.millisElapsed()>(Greenfoot.getRandomNumber(10))*velCaida)
        {

            this.setLocation(getX(),getY()+5);
            timer.mark();

        }
        
    }   
    
    public boolean tocaComida(){
        return(this.isTouching(Comida.class));
    
    }
}
