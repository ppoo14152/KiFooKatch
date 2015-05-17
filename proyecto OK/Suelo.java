import greenfoot.*;

/**
 * Write a description of class Suelo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Suelo extends Actor
{
    public Suelo() 
    {
        setImage(imagen(800,30));
    }
    
    public void act(){
        
        if(isTouching(Comida.class)){
            removeTouching(Comida.class);
        }
    
    }
    public GreenfootImage imagen(int x, int y){
      GreenfootImage i=getImage();
      i.scale(x,y);
      return i;
    
    }
    
    public boolean tocaComidaSana(){
    return(this.isTouching(ComidaSana.class));
    }
    
    public boolean tocaComida(){
        return(this.isTouching(Comida.class));
    
    }
    
    public void eliminaComida(){
        removeTouching(Comida.class);    
    }
}
