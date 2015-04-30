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
    Ayuda bAyuda;
    Creds bCreds;
    Record bRecord;
    
    //private Puntero p;
    GreenfootSound sonido;
    GreenfootSound sonidoB;
    Titulo t;
    World wj;
    World wc;
    World wa;
    World wr;
    MouseInfo m;
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800,600,1);
        t=new Titulo();
        bStart=new Start();
        bAyuda= new Ayuda();
        bCreds= new Creds();
        bRecord= new Record();
        
        wj=new Mundo();
        wc= new Creditos();
        
        
        
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
      if(Greenfoot.mouseClicked(bCreds)){
        
        sonido.stop();
        sonidoB.play();
        Greenfoot.setWorld(wc); //wc = mundo creditos
     }
     
    }
    public void dibujaBotones(){
       addObject(bStart,200,300);
       addObject(bAyuda,600,300);
       addObject(bCreds,200,450);
       addObject(bRecord,600,450);
    }
    
}
