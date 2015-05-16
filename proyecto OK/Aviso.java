import greenfoot.*;

/**
 * Write a description of class Aviso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aviso extends Actor
{
    
    public Aviso() 
    {
        setImage(imagen(200,200));
        
    }    
    public GreenfootImage imagen(int x,int y){
      GreenfootImage i=getImage();
      i.scale(x,y);
      return i;
    
    }
}
