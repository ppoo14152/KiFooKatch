import greenfoot.*;

/**
 * Write a description of class Platano here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platano extends ComidaSana
{
    /**
     * Act - do whatever the Platano wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   SimpleTimer timer=new SimpleTimer();
    int velCaida;
   
         
    public Platano(){
      setImage(imagen());
    } 
    public void act(){
     super.cae();
    }
    public GreenfootImage imagen(){
      GreenfootImage i =getImage();
      i.scale(70,50);
      return i;
    
    }
}
