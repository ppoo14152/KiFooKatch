import greenfoot.*;

/**
 * this class is for show the help and show the instructions of the game 
 * @author Hugo Enrique Limon Castillo, Estefania Cortez gutierrez
 * @version 0.1
 */
public class AyudaM extends World
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
    private TAyuda text;
   
    
    public AyudaM(World w)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        bSalir = new Salir();
        text= new TAyuda();

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
       addObject(text,350,250);
      
    }
    
}
