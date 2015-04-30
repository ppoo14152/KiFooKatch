import greenfoot.*;

/**
 * Write a description of class Naranja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Naranja extends ComidaSana
{
    /**
     * Act - do whatever the Naranja wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Naranja(int vel){
      setImage(imagen());
      velCaida=vel;
    }
    public void act() 
    {
        super.cae();
    }
    public GreenfootImage imagen(){
      GreenfootImage i =getImage();
      i.scale(50,50);
      return i;
    
    }
}
