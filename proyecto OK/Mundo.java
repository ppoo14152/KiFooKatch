import greenfoot.*;

/**
 * Write a description of class menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mundo extends World
{

    /**
     * Constructor for objects of class menu.
     * 
     */

    private final int ancho=800; //se crea consatnte el ancho y el alto
    private final int alto=600;
    private final int centroPx=ancho/2;
    private final int centroPy=alto/2;
    private SimpleTimer t;
    private Aviso aviso;
    private int band;
    private GreenfootSound sonido;
    public Mundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(800, 600, 1);
        super(800,600,1);
        t=new SimpleTimer();

        aviso= new Aviso();
        humano h= new humano();
        //creaComida();
        addObject(h,400,500);
        setBackground("madera.jpg");
        
        band=0;
        sonido=new GreenfootSound("mundo.mid");
    }

    public void creaComida(){
        int i=0;
        int rand;
       
        Comida varObjeto=new Comida();
        for(i=0;i<10;i++){
            rand=Greenfoot.getRandomNumber(5);
            switch(rand){
                case 1:varObjeto=new Hamburguesa();
                addObject(varObjeto,(Greenfoot.getRandomNumber(8)*100),30);
                break;
                case 2:varObjeto=new Naranja();
                addObject(varObjeto,(Greenfoot.getRandomNumber(8)*100),30); 
                break;
                case 3:varObjeto= new Cheetos();
                addObject(varObjeto,(Greenfoot.getRandomNumber(8)*100),30);
                break;
                case 4:varObjeto= new Platano();
                addObject(varObjeto,(Greenfoot.getRandomNumber(8)*100),30);
                break; 

            }

        }

    }

    public void act(){
        
        if(band==0){
            t.mark();
            addObject(aviso,centroPx,centroPy);
            aviso.setImage("1.png");
            aviso.setImage(aviso.imagen(200,200));
            band=2;
            sonido.play();
        }
        if(band==2&&t.millisElapsed()>500){
         aviso.setImage("2.png");
            aviso.setImage(aviso.imagen(200,200));
         band=3;
        }
        if(band==3&&t.millisElapsed()>1000){
        aviso.setImage("3.png");
        aviso.setImage(aviso.imagen(200,200));
        band=4;
        }
        if(band==4&&t.millisElapsed()>1500){
        aviso.setImage("go.png");
            aviso.setImage(aviso.imagen(200,200));
        band=5;
        }
        if(band==5&&t.millisElapsed()>2000)
        {
        removeObject(aviso);
        creaComida();
        band=6;    
        }

    }
}
