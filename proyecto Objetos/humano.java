import greenfoot.*;

/**
 * Write a description of class humano here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class humano extends Actor
{
    /**
     * Act - do whatever the humano wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
       
        int RIGHT=1;
        int LEFT=2;
        Comida h=new Comida();
       
     public  humano(){
         setImage(imagen());
         
        }   
     public void act(){
        if(Greenfoot.isKeyDown("left")){
         setDireccion(LEFT); 
        }  
        if(Greenfoot.isKeyDown("right")){
         setDireccion(RIGHT); 
        }  
        removeTouching(h.getClass());    
    
      }
      public void setDireccion(int direccion){
          switch(direccion){
              case 1:
                setLocation(getX()+5,getY());    
              break;
              case 2: 
                setLocation(getX()-5,getY());    
              break;     
        }

    }    
    public GreenfootImage imagen(){
      GreenfootImage i=getImage();
      i.scale(100,300);
      return i;
      
    }
}
