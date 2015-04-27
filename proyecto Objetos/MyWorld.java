import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PaintingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends KinectWorld
{
    public static final double SCALE = 1.0;

    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;

    private Stick stick;
    private UserData[] users;

    public MyWorld()
    {    
        super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, SCALE, false);
        
        final int width = getWidth();
        final int height = getHeight();
        
        addObject(new Instructions(), width/2, height/2);
        addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
        
        users = new UserData[0];
        stick = new Stick(0);
        addObject(stick, (int)(320*SCALE), (int)(240*SCALE));
    }
    
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
