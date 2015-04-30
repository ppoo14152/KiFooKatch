import greenfoot.*;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    Start bStart;
    //private Puntero p;
    GreenfootSound sonido;
    GreenfootSound sonidoB;
    Titulo t;
    World wj;
    MouseInfo m;
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800,600,1);
        bStart=new Start();
        wj=new Mundo();
        t=new Titulo();
        
        dibujaBotones();
        sonido= new GreenfootSound("intro.mid");
        sonidoB= new GreenfootSound("click.mp3");
    }
    public void act(){
     m=Greenfoot.getMouseInfo(); 
     addObject(t,400,200);
     
     
     sonido.play();
     if(!sonido.isPlaying()){
        sonido.play();
        }
     if(Greenfoot.mouseClicked(bStart)){
        bStart.juega();
        sonido.stop();
        sonidoB.play();
        Greenfoot.setWorld(wj); //wj = mundo juego
     }
     
    }
    public void dibujaBotones(){
       addObject(bStart,200,300);
       //addObject(p,400,400);
    }
    
}
