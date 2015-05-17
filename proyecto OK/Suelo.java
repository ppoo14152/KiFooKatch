import greenfoot.*;

/**
 * The class Suelo is used to detect when the food is on the floor  
 * @author Hugo Enrique Limon Castillo, Estefani Cortez Gutierrez
 * @version 0.1
 */
public class Suelo extends Actor
{
    public Suelo() 
    {
        setImage(imagen(800,30));
    }
    /**
     * act remove the food that touch its 
     */
    public void act(){
        
        if(isTouching(Comida.class)){
            removeTouching(Comida.class);
        }
    
    }
    /**
     * this method is for change the size of the image
     */
    public GreenfootImage imagen(int x, int y){
      GreenfootImage i=getImage();
      i.scale(x,y);
      return i;
    }
    
    /**
     *  tocaComidaSana()
     *  @return it return boolean when it is touching an object of kind ComidaSana
     */
    public boolean tocaComidaSana(){
    return(this.isTouching(ComidaSana.class));
    }
    /**
     *  tocaComidaSana()
     *  @return it return boolean when it is touching an object of kind Comida
     */public boolean tocaComida(){
        return(this.isTouching(Comida.class));
    
    }
    /**
    tocaComidaSana()
    * this method it for revome the foot that touch the floor
    */
    public void eliminaComida(){
        removeTouching(Comida.class);    
    }
}
