import greenfoot.*;

/**
 * This class is used to show the records of users.
 * @author Hugo Limón, Valeria Cortez
 * @version 0.1
 */
public class RecordM extends World
{

    /**
     * Constructor for objects of class RecordM.
     * bSalir: used to go back to principal menu
     * we create te variables sonido and sonidoB to play the music of the game,
     * also crate the world of the menu, to return the page to menu.
     * and the mouseInfo to check where it is clicked.
     */
    private Salir bSalir;
    private GreenfootSound sonido;
    private GreenfootSound sonidoB;
    private World wm;
    private MouseInfo m;
   
    
    public RecordM(World w)
    {    
        super(800, 600, 1); 
         /**
          * in this part we used the variable bSalir to go back to menu
          * 
            */
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
    /**
     * in this part  only add the objects to menu, like bottons and the ScoreBoard
     */
    public void dibujaEntorno(){
       addObject(bSalir,700,550);
       addObject(new ScoreBoard(600, 400), getWidth() / 2, getHeight() / 2);
      
    }
    
}
