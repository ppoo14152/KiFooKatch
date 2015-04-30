import greenfoot.*;

/**
 * Write a description of class Comida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comida extends Actor
{
    /**
     * Act - do whatever the Comida wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private SimpleTimer timer;
    private int velCaida;
    public Comida(){
        timer=new SimpleTimer();
        timer.mark();
        velCaida=Greenfoot.getRandomNumber(10)*5;

    }

    public void cae() 
    {
        if(timer.millisElapsed()>velCaida){

            this.setLocation(getX(),getY()+5);
            timer.mark();

        }// Add your action code here.
    }    
}
