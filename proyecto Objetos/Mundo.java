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
    
    public static final double SCALE = 4.0;

    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;

    private Stick stick;
    private UserData[] users;
    
    public Mundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         //super(800, 600, 1);
         super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, SCALE, false);
        
        final int width = getWidth();
        final int height = getHeight();
        
        addObject(new Instructions(), width/2, height/2);
        addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
        
        users = new UserData[0];
        stick = new Stick(0);
        addObject(stick, (int)(320*SCALE), (int)(240*SCALE));
         
         humano h= new humano();
         creaComida();
         addObject(h,400,500);
         setBackground("madera.jpg");
          
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
   /* public GreenfootImage imagen(){
     GreenfootImage i=greenfoot.getImage();
     i.scale(800,600);
     return i;
    }
*/
 public void act()
    {
        super.act();
        users = getAllUsers();
    }

    public UserData getUser(int ID)
    {
        if (ID >= users.length) {
            return null;
        }
        return users[ID];
    }
         
       
}
