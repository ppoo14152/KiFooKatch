import greenfoot.*;

/**
 * Write a description of class Creditos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creditos extends World
{

    /**
     * Constructor for objects of class Creditos.
     * 
     */
    Salir bSalir;
    GreenfootSound sonido;
    GreenfootSound sonidoB;
    World wm;
    MouseInfo m;
   
    
    public Creditos()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        bSalir = new Salir();
        wm= new Menu();
        sonido= new GreenfootSound("intro.mid");
        sonidoB= new GreenfootSound("click.mp3");
    }
    
    public void act(){
     m=Greenfoot.getMouseInfo(); 
     //addObject(t,400,200);
     
     
     sonido.play();
     if(!sonido.isPlaying()){
        sonido.play();
        }
     if(Greenfoot.mouseClicked(bSalir)){
        //bStart.juega();
        sonido.stop();
        sonidoB.play();
        Greenfoot.setWorld(wm); 
     }
   
     
    }
    public void dibujaBotones(){
       addObject(bSalir,600,500);
      
    }
    
}
