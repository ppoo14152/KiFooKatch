import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class downloaded from http://www.greenfoot.org/doc/kinect
 */
public class Thumbnail  extends Actor
{
    public Thumbnail()
    {
    }

    public void act() 
    {
        GreenfootImage img = ((KinectWorld)getWorld()).getThumbnailUnscaled();
        setImage(img);
    }
}
