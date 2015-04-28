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
    private SimpleTimer t;
    public Start(){
        w=new Mundo(); 
        t=new SimpleTimer();
        setImage("jugarN.png");
        super.imagen(300,100); 
    }

    public void act() 
    {
        if(isTouching(Boton.class))
        {
            t.mark();
            setImage("jugarV.png");
            super.imagen(300,100);
            
        }
        else{setImage("jugarN.png");
            super.imagen(300,100); 
           
        }
    }
} 
