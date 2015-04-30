import greenfoot.*;

/**
 * Write a description of class Cheetos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cheetos extends ComidaMala
{
    /**
     * Act - do whatever the Cheetos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
  
     public Cheetos(int vel){
      setImage(imagen());
      velCaida=vel;
    } 
    public void act(){
     super.cae();
    }
    public GreenfootImage imagen(){
      GreenfootImage i=getImage();
      i.scale(70,50);
      return i;
    
    }
}
