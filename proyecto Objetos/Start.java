import greenfoot.*;

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Boton
{
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   World w=getWorld();
    
    public Start(){
        w=new Mundo(); 
       super.imagen(150,150); 
    }
    public void act() 
    {
        if(Greenfoot.mouseMoved(this)){
         
         Greenfoot.setWorld(w);
            
        // Add your action code here.
    }    
   }
} 
