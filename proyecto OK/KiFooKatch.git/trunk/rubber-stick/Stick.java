import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stick  extends Actor
{
    private static final GreenfootImage noImage = new GreenfootImage(1, 1);
    private static final GreenfootImage seeUser = new GreenfootImage("see-user.png");

    //                    HEAD/NECK/TORS/L-SH/L-EB/L-HD/R-SH/R-EB/R-HD/L-HP/L-KN/L-FT/R-HP/R-KN/R-FT
    float[] defaultX   = {400, 400, 400, 365, 325, 360, 435, 500, 450, 375, 355, 380, 425, 445, 425};
    float[] defaultY   = {155, 215, 305, 215, 285, 350, 215, 275, 340, 335, 415, 520, 335, 415, 520};

    //                    HEAD/NECK/TORS/L-SH/L-EB/L-HD/R-SH/R-EB/R-HD/L-HP/L-KN/L-FT/R-HP/R-KN/R-FT
    float[] calibrateX = {400, 400, 400, 365, 290, 255, 435, 510, 550, 375, 355, 370, 425, 445, 435};
    float[] calibrateY = {155, 215, 305, 215, 225, 140, 215, 205, 140, 335, 415, 520, 335, 415, 520};


    private int ID;
    private SoftPoint[] dot;
    private BodyPart[] body;
    private UserData defaultPose;
    private UserData calibratePose;
    private GreenfootImage[] heads;
   

    public Stick(int ID)
    {
        this.ID = ID;
        setImage(noImage);
        defaultPose = setUpPose(defaultX, defaultY);
        calibratePose = setUpPose(calibrateX, calibrateY);
    }

    public void addedToWorld(World world)
    {
        createBody(world);
    }

    /**
     */
    public void act() 
    {
        UserData user = ((MyWorld)getWorld()).getUser(ID);

        if (user == null) {
            // no user visible
            if (getImage() != noImage) {
                setImage(noImage);
            }
            moveALittle();
            trackUser(defaultPose);
        }
        else if (user.startedCalibrating()) {
            // user spotted, but not yet tracked
            setImage("calibrating.png");
        }
        else if (user.isCalibrating()) {
            trackUser(calibratePose);
        }
        else if (user.startedTracking()) {
            // got him/her!
            setImage(noImage);
        }
        else if (user.isTracking()) {
            // tracking user
            trackUser(user);
        }
        else { // seeing user, but not calibrating
            if (getImage() != seeUser) {
                setImage(seeUser);
            }
            moveALittle();
            trackUser(calibratePose);
        }
        animateFace();
    }    

    /**
     * Display a tracked user on screen
     */
    private void trackUser(UserData user)
    {
        for (int i = 0; i < Joint.NUM_JOINTS; i++) {
            Joint joint = user.getJoint(i);
            dot[i].setTarget (joint.getX(), joint.getY());
            dot[i].move();
        }
    }

    private void moveALittle()
    {
        if(Greenfoot.getRandomNumber(1000) < 40) 
        {
            for (int i = 1; i < dot.length; i++) {
                dot[i].wobble();
            }
        }
    }

    private void animateFace()
    {
        if(Greenfoot.getRandomNumber(1000) < 10) 
        {
            body[0].useImage(heads[Greenfoot.getRandomNumber(heads.length)]);
        }
    }

    private void createBody(World world)
    {
        // Create a softPoint to follow each joint position
        dot = new SoftPoint[Joint.NUM_JOINTS];
        dot[0] = new SoftPoint(0.01, 0.03);

        for (int i = 1; i < dot.length; i++) {
            dot[i] = new SoftPoint();
        }
        dot[2].setYOffset(80);  // move centre body point down to use as hip point
        
        heads = new GreenfootImage[10];
        for (int i = 0; i < heads.length; i++) {
            heads[i] = new GreenfootImage("head"+i+".png");
        }
        
        // Create body part between softPoints
        //SoftPoint hip = dot[9].mid(dot[12]);
        body = new BodyPart[10];
        body[0] = new BodyPart("head0.png", dot[0], dot[1], 0, -70);    // head
        body[0].dontStretch();
        body[1] = new BodyPart(dot[1], dot[2]);                  // body centre
        body[2] = new BodyPart(dot[3], dot[4]);                  // left arm
        body[3] = new BodyPart(dot[6], dot[7]);                  // right arm
        body[4] = new BodyPart("left-hand.png", dot[5], dot[4]);
        body[5] = new BodyPart("right-hand.png", dot[8], dot[7]);
        body[6] = new BodyPart(dot[2], dot[10]);                     // left leg
        body[7] = new BodyPart(dot[2], dot[13]);                     // right leg
        body[8] = new BodyPart("left-foot.png", dot[10], dot[11]);
        body[9] = new BodyPart("right-foot.png", dot[13], dot[14]);

        for (int i = 0; i < body.length; i++) {
            world.addObject(body[i], world.getWidth()/2, world.getHeight()/2);
        }
    }

    /**
     * Initialise the coordinates for the default body poses (used when we cannot
     * see a user).
     */
    private UserData setUpPose(float[] x, float[] y)
    {
        UserData pose = new UserData(-1);

        for (int i = 0; i < x.length; i++) {
            float cx = (float) (x[i] * MyWorld.SCALE);
            float cy = (float) (y[i] * MyWorld.SCALE);
            pose.setJoint(i, new Joint(i, 1.0f, null, new Point3D(cx, cy, 0.0f)));
        }

        return pose;
    }

}
