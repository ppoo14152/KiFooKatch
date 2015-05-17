import greenfoot.*;

/**
 * this class is for define fruit orange
 * 
 * @author Hugo Enrique Limon Castillo, Estefani Cortez Gutierrez
 * @version 0.1
 */
public class Naranja extends ComidaSana
{
    /**
     * the construct of class Naranja is for set its image and set velocity
      @param vel recive the velocity which it fall
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
