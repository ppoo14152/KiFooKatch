import greenfoot.*;

/**
 * Write a description of class puntero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puntero extends Actor
{
    /**
     * Act - do whatever the puntero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x; 
    int y;
   World w;
    MouseInfo m;
    
    public Puntero(){
     w=new Mundo();
    
    }
   
    public void act() 
    {
        MouseInfo m=Greenfoot.getMouseInfo();
        if(m!=null){
        setLocation(m.getX(),m.getY());
        if(!this.isTouching(Boton.class)){
           // Greenfoot.setWorld(w);
        // Add your action code here.
        }
    }    

   }
}
