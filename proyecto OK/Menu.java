import greenfoot.*;

/**
 * This class is used to display a Menu for the game, help, records and credits.
 * @author Hugo Limón, Valeria Cortez
 * @version 0.1
 */

public class Menu extends World
{

    /**
    * The buttons
    */
    private Start bStart;
    private Ayuda bAyuda;
    private Creds bCreds;
    private Record bRecord;
    
    //private Puntero p;
    private GreenfootSound sonido;
    private GreenfootSound sonidoB;
    private Titulo t;
    private World wj;
    private World wc;
    private World wa;
    private World wr;
    private MouseInfo m;
    /**
    * Constructor
     */
    public Menu()
    {    
       super(800,600,1);
       t=new Titulo();
       bStart=new Start();
       bAyuda= new Ayuda();
       bCreds= new Creds();
       bRecord= new Record();
       wj=new Mundo();
       wc= new Creditos(this);
       wa= new AyudaM(this);
       wr= new RecordM(this);
       dibujaEntorno();
       sonido= new GreenfootSound("intro.mid");
       sonidoB= new GreenfootSound("click.mp3");
    }
    
    /**
     *Here, it checks the info of the mouse and in which botton the user is clicked 
     */
    public void act(){
     m=Greenfoot.getMouseInfo(); 
    
     sonido.play();
     if(!sonido.isPlaying()){
        sonido.play();
        }
     if(Greenfoot.mouseClicked(bStart)){
        bStart.juega();
        sonido.stop();
        sonidoB.play();
        Greenfoot.setWorld(wj); //wj = mundo juego
     }else{
      if(Greenfoot.mouseClicked(bAyuda)){
        
        sonido.stop();
        sonidoB.play();
        Greenfoot.setWorld(wa); //wa = mundo ayuda
       }
       else
       {
           if(Greenfoot.mouseClicked(bCreds)){
        
        sonido.stop();
        sonidoB.play();
        Greenfoot.setWorld(wc); //wc = mundo creditos
        }
      else{
          if(Greenfoot.mouseClicked(bRecord)){
        
        sonido.stop();
        sonidoB.play();
        Greenfoot.setWorld(wr); //wr = mundo record
       }
       }
      }
     }
    }
    
    /**
     * Here, add the buttons are added 
     */
    public void dibujaEntorno(){
       addObject(bStart,200,300);
       addObject(bAyuda,600,300);
       addObject(bCreds,200,450);
       addObject(bRecord,600,450);
       addObject(t,400,200);
    }
    
    /**
     * This method pauses the music if the game is paused or stopped.
     */
    public void stopped(){
    sonido.pause();
    }
    
}
