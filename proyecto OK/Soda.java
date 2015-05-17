import greenfoot.*;
import java.lang.*;
/**
 * Write a description of class Hamburguesa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soda extends ComidaMala

{
    /**
     * Act - do whatever the Hamburguesa wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
 
   
         
    public Soda(int vel){
      setImage(imagen());
      velCaida=vel;
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
