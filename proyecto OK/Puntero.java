import greenfoot.*;

/**
 * Write a description of class puntero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puntero extends Actor
{
    
    private int x; 
    private int y;
    private World w;
    private MouseInfo m;
    
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
