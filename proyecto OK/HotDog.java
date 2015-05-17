import greenfoot.*;
import java.lang.*;
/**
 * Write a description of class Hamburguesa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HotDog extends ComidaMala

{
    
         
    public HotDog(int vel){
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
