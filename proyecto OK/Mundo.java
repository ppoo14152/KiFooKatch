import greenfoot.*;

/**
 * Write a description of class menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mundo extends KinectWorld
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
    
    public static final double SCALE = 4.0;

    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;

    private Stick stick;
    private UserData[] users;
    Plato p1;
    Plato p2;
    int puntaje=0;
    int valorComidaSana=10;
    int valorComidaMala=-10;
    private int numObjetos;
    UserInfo jugador;
    public Mundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(800, 600, 1);
       super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, SCALE, false);
        
        final int width = getWidth();
        final int height = getHeight();
        
       // jugador= new UserInfo();
        
        t=new SimpleTimer();
        //addObject(new Instructions(), width/2, height/2);
        addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
        
        users = new UserData[0];
        p1=new Plato();
        p2=new Plato();
   
        addObject(p1,400,500);
        addObject(p2,400,500);
        stick = new Stick(0,p1,p2);
        addObject(stick, (int)(320*SCALE), (int)(240*SCALE));
        

        aviso= new Aviso();
       // humano h= new humano();
        //creaComida();
        //addObject(h,400,500);
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
        numObjetos=numberOfObjects();
        puntaje=puntaje+eliminaComidaS();
        puntaje=puntaje+eliminaComidaM();
        System.out.println("numero objetos"+numObjetos);
        if(!sonido.isPlaying()){
         sonido.play();
        }
         super.act();
        users = getAllUsers();
        
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
    public int eliminaComidaS(){
        
        if(p1.isTouchComidaS()){
            p1.eliminaComida();
            return valorComidaSana;
        }
        if(p2.isTouchComidaS()){
            p2.eliminaComida();
            return valorComidaSana;
        }
        return 0;
         
    }
    public int eliminaComidaM(){
        
        if(p1.isTouchComidaM()){
            p1.eliminaComida();
            return valorComidaMala;
        }
         if(p2.isTouchComidaM()){
            p2.eliminaComida();
            return valorComidaMala;
        }
        return 0;
         
    }
    public UserData getUser(int ID)
    {
        if (ID >= users.length) {
            return null;
        }
        return users[ID];
    }
    
}
