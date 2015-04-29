import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SoftPoint - .
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoftPoint 
{
    private static double DRAG = 0.1;              // how quickly we slow down; higher == more drag
    private static double SPRING_STRENGTH = 0.3;   // how strong the spring is to the target position;
    // more == stronger
    private Vector movement;
    private double x;
    private double y;
    private double xOffset=0;
    private double yOffset = 0;
    private int targetX;
    private int targetY;
    private double drag;
    private double spring;

    public SoftPoint()
    {
        this(SPRING_STRENGTH, DRAG);
    }

    public SoftPoint(double spring, double drag)
    {
        this.spring = spring;
        this.drag = drag;
        movement = new Vector();
    }

    /**
     * Define an offset for the reported position from the actual position in the y axis.
     */
    public void setYOffset(double offset)
    {
        yOffset = offset;
    }
     /**
     * Define an offset for the reported position from the actual position in the x axis.
     */
    public void setXOffset(double offset)
    {
        xOffset = offset;
    }
    
    /**
     * Move towards the target.
     */
    public void move()
    {

        Vector v = new Vector( targetX-x, targetY-y );
        v.scale(spring);
        movement.add(v);
        accelerate(1-drag);  // slow down due to drag

        x = x + movement.getX();
        y = y + movement.getY();
    }

    /**
     * Set current target position into targetX,targetY.
     */
    public void setTarget(int x, int y)
    {
        targetX = x;
        targetY = y;
    }

    /**
     * Accelerate the speed of this mover by the given factor. (Factors < 1 will
     * decelerate.)
     */
    public void accelerate(double factor)
    {
        movement.scale(factor);
        if (movement.getLength() < 0.15) {
            movement.setNeutral();
        }
    }

    /**
     * Return the current X coordinate.
     */
    public int getX()
    {
        return (int)x;
    }

    /**
     * Return the current Y coordinate.
     */
    public int getY()
    {
        return (int)(y + yOffset);
    }

    public void wobble()
    {
        int direction = Greenfoot.getRandomNumber(360);
        double length = Greenfoot.getRandomNumber(2);
        movement.add(new Vector(direction, length));
    }

    public String toString()
    {
        return "SoftPoint (" + x +"," + y + ")";
    }
}
