import greenfoot.*;

/**
 * Write a description of class Creditos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecordM extends World
{

    /**
     * Constructor for objects of class Creditos.
     * 
     */
    private Salir bSalir;
    private GreenfootSound sonido;
    private GreenfootSound sonidoB;
    private World wm;
    private MouseInfo m;
   
    
    public RecordM(World w)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        bSalir = new Salir();

        wm= w;


        sonido= new GreenfootSound("intro.mid");
        sonidoB= new GreenfootSound("click.mp3");
        dibujaEntorno();
        
     
        
    }
    
    public void act(){
     m=Greenfoot.getMouseInfo(); 
 
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
    public void dibujaEntorno(){
       addObject(bSalir,700,550);
       addObject(new ScoreBoard(600, 400), getWidth() / 2, getHeight() / 2);
      
    }
    
}
