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
    
    
    //public static final double SCALE = 1.25;
    //private static final int THUMBNAIL_WIDTH = 80;
    
    //private static final int THUMBNAIL_HEIGHT = 60;
     //private Stick stick;
    //private UserData[] users;
    

    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800,600,1);

       
       //super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, SCALE, false);

        //final int width = getWidth();
        //final int height = getHeight();
        
        //addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
       
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
    public void dibujaEntorno(){
       addObject(bStart,200,300);
       addObject(bAyuda,600,300);
       addObject(bCreds,200,450);
       addObject(bRecord,600,450);
       addObject(t,400,200);
    }
    
    public void stopped(){
    sonido.pause();
    }
    
}
