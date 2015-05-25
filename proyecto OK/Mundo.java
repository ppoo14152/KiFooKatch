import greenfoot.*;

/**
 * The world class of the game. 
 * @author Hugo Limón, Valeria Cortez
 * @version 0.1
 */
public class Mundo extends KinectWorld

{
    /**
     * 
     * Window width
     */
    private  static final int ANCHO=800; //se crea consatnte el ancho y el alto

    /**
     * Window height
     */
    private static final int ALTO=600;
    private static final int CENTROPX=ANCHO/2;
    private static final int CENTROPY=ALTO/2;

    /**
     * Constants for the kinect thumbnail
     */
    public static final double SCALE = 4.0;
    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;

    /**
     * The timer for the game
     */
    private SimpleTimer t;

    /**
     * The signal at the start of the game
     */
    private Aviso aviso;
    private int band;

    /**
     * Music
     */
    private GreenfootSound sonido;   

    /**
     * User information
     */
    private Stick stick;
    private UserData[] users;

    /**
     * The plates to catch the food
     */
    private Plato p1;
    private Plato p2;

    /**
     * Score variables
     */
    private int puntaje;
    private int valorComidaSana;
    private int valorComidaMala;
    private int p;

    /**
     * Number of objects in the world.
     */
    private int numObjetos;
    private Suelo suelo;

    /**
     * Fall velocity variables
     */
    private int vel4;
    private int vel3;
    private int vel2;
    private int vel1;

    /**
     * Text for error if the Kinect is not connected
     */
    private TError errorNE;

    /**
     * Level variables
     */
    private Nivel1 n1;
    private Nivel2 n2;
    private Nivel3 n3;
    private Nivel4 n4;
    private int band1=1;
    private int band2=1;
    private int band3=1;
    private int band4=1;
    private int nivel;
    private int xn;
    private int yn; 
    private Counter count;
    /**
     * To indicate whether if he sound has been created
     */
    private int soundP=0;
    SimpleTimer timer;
    SimpleTimer tim;

    /**
     * The World constructor initializes the instance variables to control the levels, the scores and the timer.
     */
    public Mundo() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(800, 600, 1);
        super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, SCALE, false);

        errorNE= new TError();
        puntaje=0;
        valorComidaSana=10;
        valorComidaMala=-10;
        vel4=1;
        vel3=3;
        vel2=5;
        vel1=20;
        nivel=1;
        p=0;

        xn=400;
        yn=75;

        n1=new Nivel1();
        n2=new Nivel2();
        n3=new Nivel3();
        n4=new Nivel4();

        int band1=1,band2=1,band3=1,band4=1;

        final int width = getWidth();
        final int height = getHeight();

        t=new SimpleTimer();
        //addObject(new Instructions(), width/2, height/2);
        addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);

        //users = new UserData[0];
        timer= new SimpleTimer();
        //timer.mark();
        tim= new SimpleTimer();
        tim.mark();

        p1=new Plato();
        p2=new Plato();
        suelo=new Suelo();
        addObject(suelo,CENTROPX,600);
        addObject(p1,400,500);
        addObject(p2,400,500);
        stick = new Stick(0,p1,p2);
        addObject(stick, (int)(320*SCALE), (int)(240*SCALE));

        aviso= new Aviso();

        // humano h= new humano();
        //creaComida();
        //addObject(h,400,500);
        setBackground("fondo.png");

        band=0;
        soundP=1;
        sonido=new GreenfootSound("mundo.mid");
        count=new Counter("Act Cycles: ");
        addObject(count, 100, 100);
        
    }

    /**
     * This method is called whenever the "Run" button is pressed,
     * it confirms if the Kinect sensor is connected,
     * it creates the food objects falling from the sky,
     * checks the collisions between the objects and
     * increases the level of the game according to the number of the fallen objects.
     */
    public void act(){

        super.act();
        count.setValue(puntaje);
        if(!isConnected()){
            errorNoConectado();            
            return;
        }

        users = getTrackedUsers();
        if(users.length==0){
            return;
        }

        numObjetos=numberOfObjects();
        if(nivel==1&&timer.millisElapsed()>=2000&&p==0)
        {
            creaComida(vel1);
            timer.mark();
            if(puntaje>=30)nivel=2; 
            if(band1==1){
                addObject(n1, xn,yn);
                band1=0;
            }
        }
        if(nivel==2&&timer.millisElapsed()>=1500&&p==0)
        {
            creaComida(vel2);
            timer.mark();
            removeObject(n1);
            if(puntaje>=100)nivel=3; 
            if(band2==1){
                addObject(n2, xn,yn);
                band2=0;
            }
        }
        if(nivel==3&&timer.millisElapsed()>=1000&&p==0)
        {
            creaComida(vel3);
            timer.mark();
            removeObject(n2);
            if(puntaje>=110)nivel=4; 
            if(band3==1){
                addObject(n3, xn,yn);
                band3=0;
            }
        }
        if(nivel==4&&timer.millisElapsed()>=500&&p==0)
        {
            creaComida(vel4);
            timer.mark();
            removeObject(n3);
            if(band4==1){
                addObject(n4, xn,yn);
                band4=0;
            }
        }
        /*if(nivel==4&&p==0)
        {
        removeObject(n3);
        addObject(n4,xn,yn);
        }*/


        puntaje=puntaje+eliminaComidaS();
        puntaje=puntaje+

        eliminaComidaM();
        //System.out.println("numero objetos"+numObjetos);
        System.out.println("punteje "+puntaje);
        if(!sonido.isPlaying()){
            sonido.play();
        }

        if(band==0){
            t.mark();
            addObject(aviso,CENTROPX,CENTROPY);
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
            creaComida(vel1);
            band=6;    
        }

        //CUANDO PIERDA O TERMINE EL JUEGO

        if(puntaje<-150){
            p=1;
            if (UserInfo.isStorageAvailable()) {
                UserInfo myInfo = UserInfo.getMyInfo();
                if (puntaje > myInfo.getScore()) {
                    myInfo.setScore(puntaje);
                    myInfo.store();  // write back to server
                }
            }
            addObject(new ScoreBoard(800, 600), getWidth() / 2, getHeight() / 2);
            stopped();
        }
        cayoComida();

    }

    /**
     * This method creates the food falling from the sky.
     */
    public void creaComida(int vel){
        int i=0;
        int rand;
        int aux=0; // esta variable, es un contador y  sirve para identificar que se hayan creado los diez objetos comida
        int y=150;
        Comida varObjeto=new Comida();
        while(aux<=1){   
            rand=Greenfoot.getRandomNumber(17);
            switch(rand)
            {
                case 1:
                varObjeto=new Hamburguesa(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 2:
                varObjeto=new Naranja(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y); 
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 3:
                varObjeto= new Cheetos(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 4:
                varObjeto= new Platano(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break; 

                case 5:
                varObjeto=new Lechuga(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 6:
                varObjeto=new Manzana(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 7:
                varObjeto=new Papa(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 8:
                varObjeto=new Uva(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 9:
                varObjeto=new Zanahoria(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 10:
                varObjeto=new Chips(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 11:
                varObjeto=new Chocolate(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 12:
                varObjeto=new Soda(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 13:
                varObjeto=new Doritos(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 14:
                varObjeto=new Dulces(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 15:
                varObjeto=new HotDog(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

                case 16:
                varObjeto=new Pizza(vel);
                addObject(varObjeto,(Greenfoot.getRandomNumber(7)*100)+100,y);
                if(varObjeto.tocaComida()){
                    removeObject(varObjeto);

                }
                aux++;
                break;

            }

        }
    }

    /**
     * This method is used to eliminate the healthy food being touched by the plates.
     * @return The value to increase the score.
     */
    public int eliminaComidaS() {

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

    /**
     * This method is used to eliminate the junk food being touched by the plates.
     * @return The value to decrease the score.
     */
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

    /**
     * This method is  used to get the users detected by the Kinect.
     * @return Null if not detecting anyone, a user if detecting someone.
     */
    public UserData getUser(int ID)
    {

        if (ID >=users.length) {
            return null;
        }
        return users[ID];
    }

    /**
     * This method pauses the song if the game is stopped or paused.
     */
    public void stopped(){
        if(soundP==1){
            sonido.pause();
        }
    }

    /**
     * This method isplays a message if the Kinect is not connected.
     */
    public void errorNoConectado(){
        addObject(errorNE, 400,300);
    }

    /**
     * This method checks wheter if any kind of food has fallen.
     */
    public void cayoComida(){
        if(suelo.tocaComida()){
            //if(suelo.tocaComidaSana()){
            //  puntaje=puntaje-10;
            //}
            suelo.eliminaComida();
        }
    }

}
