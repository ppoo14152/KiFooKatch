import greenfoot.*;

/**
 * This class is used to show the credits of the game.
 * @author Hugo Limón, Valeria Cortez
 * @version 0.1
 */
public class Creditos extends World
{

    
    private Salir bSalir;
    private GreenfootSound sonido;
    private GreenfootSound sonidoB;
    private World wm;
    private MouseInfo m;
    private TCred text;
   
    /**
     * Constructor for objects of class Creditos.
     * 
     */
    public Creditos(World w)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        bSalir = new Salir();
        text= new TCred();

        wm= w;
        
        dibujaEntorno();
        sonido= new GreenfootSound("intro.mid");
        sonidoB= new GreenfootSound("click.mp3");
        
    }
    
    /**
     * This method is used whenever the "Run" button is clicked.
     * It only checks wheter if the "Exit" button is being clicked.
     */
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
    
    /**
     * This method is used to draw the buttons and the text.
     */
    public void dibujaEntorno(){
       addObject(bSalir,700,550);
       addObject(text,450,275);
      
    }
    
}
