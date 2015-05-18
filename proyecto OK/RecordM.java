import greenfoot.*;

/**
 * This class is used to show the records of users.
 * @author Hugo Limón, Valeria Cortez
 * @version 0.1
 */
public class RecordM extends World
{

    
    private Salir bSalir;
    private GreenfootSound sonido;
    private GreenfootSound sonidoB;
    private World wm;
    private MouseInfo m;
   
    /**
     * Constructor for objects of class RecordM.
     * bSalir: used to go back to the principal menu
     * we create the variables sonido and sonidoB to play the music of the game,
     * also crate the world menu, to return to the menu.
     * and the mouseInfo to check where it is clicked.
     */
    public RecordM(World w)
    {    
        super(800, 600, 1); 
         
        bSalir = new Salir();

        wm= w;


        sonido= new GreenfootSound("intro.mid");
        sonidoB= new GreenfootSound("click.mp3");
        dibujaEntorno();
        
     
        
    }
    
    /**
     * This method is used whenever the run button is clicked, it only checks whether 
     * if the user is clicking on the "Exit" button.
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
     * This method is used to draw the objects in the world
     */
    public void dibujaEntorno(){
       addObject(bSalir,700,550);
       addObject(new ScoreBoard(600, 400), getWidth() / 2, getHeight() / 2);
      
    }
    
}
