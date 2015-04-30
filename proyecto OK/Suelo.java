import greenfoot.*;

/**
 * Write a description of class Suelo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Suelo extends Actor
{
    /**
     * Act - do whatever the Suelo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Suelo() 
    {
        setImage(imagen(800,30));// Add your action code here.
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
}
