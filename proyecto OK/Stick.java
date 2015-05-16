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
           /**
     * The head joint (centre of the head).
     */
    public static final int HEAD = 0;
    /**
     * The neck joint (this seems to be fixed as the midpoint of the two shoulders)
     */
    public static final int NECK = 1;
    /**
     * The torso "joint" (this seems to be fixed as the midpoint of the two shoulders and two hips)
     */
    public static final int TORSO = 2;
    
 
  
    /**
     * The offset for LEFT joints.  You can use this and the constants RIGHT,
     * SHOULDER, ELBOW, HAND, HIP, KNEE and FOOT to process both sides with one piece of code.
     * For example, here is how we draw the stick figure:
     * 
     * for (int side : new int[] {Joint.LEFT, Joint.RIGHT})
       {
            connect(img, Joint.NECK, side + Joint.SHOULDER);
            connect(img, side + Joint.SHOULDER, side + Joint.ELBOW);
            connect(img, side + Joint.ELBOW, side + Joint.HAND);
            
            connect(img, side + Joint.HIP, side + Joint.KNEE);
            connect(img, side + Joint.KNEE, side + Joint.FOOT);
       }
     * 
     * If that doesn't make any sense, or you don't need this, you might want to use
     * the constants LEFT_HAND, RIGHT_KNEE etc.
     */
    public static final int LEFT = 0;
    public static final int RIGHT = 3;
    public static final int SHOULDER = 3;
    public static final int ELBOW = 4;
    public static final int HAND = 5;
    public static final int HIP = 9;
    public static final int KNEE = 10;
    public static final int FOOT = 11;

    /**
     * The left shoulder.  Note that this is your actual left shoulder, but because
     * the display in Kinect scenarios is always a mirror image of yourself, this
     * will appear on the right-hand side of the screen.  The same goes for all the other joints.
     */
    public static final int LEFT_SHOULDER = LEFT+SHOULDER;
    public static final int LEFT_ELBOW = LEFT+ELBOW;
    public static final int LEFT_HAND = LEFT+HAND;
    public static final int LEFT_HIP = LEFT+HIP;
    public static final int LEFT_KNEE = LEFT+KNEE;
    public static final int LEFT_FOOT = LEFT+FOOT;

    public static final int RIGHT_SHOULDER = RIGHT+SHOULDER;
    public static final int RIGHT_ELBOW = RIGHT+ELBOW;
    public static final int RIGHT_HAND = RIGHT+HAND;
    public static final int RIGHT_HIP = RIGHT+HIP;
    public static final int RIGHT_KNEE = RIGHT+KNEE;
    public static final int RIGHT_FOOT = RIGHT+FOOT;
       /**
     * Límite de y's y x's
     */
    private static final int H=925;
    private static final int N=1020;
    private static final int T=1220;
    private static final int S=1076;
    private static final int E=1110;
    private static final int HN=1230;
    private static final int SX=80;
    private static final int EY=E-S;
    private static final int HNY=HN-S;
    private static final int ANT=HN-E;
    private static final int EX=SX+EY;
    private static final int HNX=SX+EY+HNY;
    private static final int HX=800;

  //                    HEAD/NECK/TORS/L-SH/L-EB/L-HD/R-SH/R-EB/R-HD/L-HP/L-KN/L-FT/R-HP/R-KN/R-FT
    float[] defaultX   = {200, 200, 200, 178, 178, 178, 222, 222, 222, 375, 355, 380, 425, 445, 425};
    float[] defaultY   = {232, 255, 305, 269, 280, 310, 269, 279, 310, 335, 415, 520, 335, 415, 520};

    //                    HEAD/NECK/TORS/L-SH/L-EB/L-HD/R-SH/R-EB/R-HD/L-HP/L-KN/L-FT/R-HP/R-KN/R-FT
    float[] calibrateX = {200, 200, 200, 178, 178, 178, 222, 222, 222, 375, 355, 380, 425, 445, 425};
    float[] calibrateY = {232, 255, 305, 269, 280, 310, 269, 279, 310, 335, 415, 520, 335, 415, 520};
    
    private int ID;
    private SoftPoint[] dot;
    private BodyPart[] body;
    private UserData defaultPose;
    private UserData calibratePose;
    private GreenfootImage[] heads;
   
    Plato p1;
    Plato p2;
    public Stick(int ID,Plato pl1, Plato pl2)
    {
        this.ID = ID;
        setImage(noImage);
        defaultPose = setUpPose(defaultX, defaultY);
        calibratePose = setUpPose(calibrateX, calibrateY);
        p1= new Plato();
        p2=new Plato();
        p1=pl1;
        p2=pl2;
       // pu.setLocation(100,100);
        
    }

    public void addedToWorld(World world)
    {
        createBody(world);
    }

    /**
     */
    public void act() 
    {
        
        UserData user = ((Mundo)getWorld()).getUser(ID);
        

        if (user == null) {
            // no user visible
            if (getImage() != noImage) {
                setImage(noImage);
            }
            moveALittle();
            trackUser(defaultPose,p1, p2);
        }
        else if (user.startedCalibrating()) {
            // user spotted, but not yet tracked
           // setImage("calibrating.png");
        }
        else if (user.isCalibrating()) {
            trackUser(calibratePose,p1, p2);
        }
        else if (user.startedTracking()) {
            // got him/her!
            setImage(noImage);
        }
        else if (user.isTracking()) {
            // tracking user
            trackUser(user,p1,p2);
        }
        else { // seeing user, but not calibrating
            if (getImage() != seeUser) {
                setImage(seeUser);//aqui cambia escala
            }
            moveALittle();
            trackUser(calibratePose,p1,p2);
        }
     //   animateFace();
    }    

     /**
     * Display a tracked user on screen AQUI !!!!!!!!!!!!!!
     */
    private void trackUser(UserData user,Plato p1, Plato p2)
    {
        int x;
        int y;
        int xh;
        int yh;
        int xp1;
        int yp1;
        int xp2;
        int yp2;
        for (int i = 0; i < Joint.NUM_JOINTS; i++) {
            Joint joint = user.getJoint(i);
            Joint jointh = user.getJoint(HEAD);
            x=joint.getX();
            y=joint.getY();
            xh=jointh.getX();
            yh=jointh.getY();
            
        if(i==HEAD){
               // if(y<=(H)){
                y=H;
                //}
                
                
            }
            else{
            if(i==NECK){
                //if(y<=N){
                    y=N;
                //}
            }
            
            else{ if(i==TORSO){
                //if(y<=T){
                    y=T;
                //}
            }
            else{
                if(i==LEFT_SHOULDER){
                    if((xh-x)>=SX){
                        x=xh-SX;
                      
                    
                    }
                    //if(y<=S){
                        y=S;
                    
                    //}  
                  
                }
                else{
                    if(i==RIGHT_SHOULDER){
                        if((x-xh)>=SX){
                            x=xh+SX;
                        }
                  //      if(y<=S){
                            y=S;
                    //    }
                       // System.out.println("rightshould"+i+"\n");
        //System.out.println(x);
                    }
                    else{
                        if(i==LEFT_ELBOW){
                            if((xh-x)>=EX){
                                x=xh-EX;
                            }
                            if(y<=(S-EY)){
                                y=S-EY;
                            }
                            else {if(y>=S+EY){
                                y=S+EY;
                            }
                                
                            }
                             
                        }
                        else{
                            if(i==RIGHT_ELBOW){
                                if((x-xh)>=EX){
                                    x=xh+EX;
                                }
                                if(y<=(S-EY)){
                                    y=S-EY;
                                }
                                else {if(y>=S+EY){
                                y=S+EY;
                            }
                                
                            }
                            }
                            else{
                                if(i==LEFT_HAND){
                                    if((xh-x)>=HNX){
                                        x=xh-HNX;
                                    }
                                    if(y<=(S-HNY)){
                                        y=S-HNY;
                                    }
                                    else {if(y>=S+HNY){
                                y=S+HNY;
                            }
                                
                            }
                            xp1=x/(int)2.5;
                            yp1=y/(int)2.5;
                            p1.setLocation(xp1,yp1);
                                }
                                else{
                                    if(i==RIGHT_HAND){
                                        if((x-xh)>=HNX){
                                            x=xh+HNX;
                                        }
                                        if(y<=S-HNY){
                                            y=S-HNY;
                                        }
                                        else {
                                            if(y>=S+HNY){
                                y=S+HNY;
                            }
                            }
                              xp2=x/(int)2.5;
                            yp2=y/(int)2.5;
                            p2.setLocation(xp2,yp2);        
                        }
                                }
                            }
                        }
                    }
                }
            }
        }
        }
        //System.out.println("art"+i+"\n");
        //System.out.println(y);
        dot[i].setTarget (x, y);
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
            //body[0].useImage(heads[Greenfoot.getRandomNumber(heads.length)]);
            body[0].useImage(heads[900]);
        }
    }

    private void createBody(World world)
    {
        // Create a softPoint to follow each joint position
        dot = new SoftPoint[Joint.NUM_JOINTS+2];
        dot[0] = new SoftPoint(0.01, 0.1);

        for (int i = 1; i < dot.length; i++) {
            dot[i] = new SoftPoint();
        }
        //dot[2].setYOffset(80);  // move centre body point down to use as hip point
        dot[14].setXOffset(100);
        dot[15].setXOffset(20);
        
        heads = new GreenfootImage[10];
        for (int i = 0; i < heads.length; i++) {
            heads[i] = new GreenfootImage("head"+".png");
        }
        
        // Create body part between softPoints
        //SoftPoint hip = dot[9].mid(dot[12]);
        body = new BodyPart[10];
       // int x1=dot[10].getX()-20;
        //int x2=dot[13].getX()+20;
        //dot[14].setXOffset(x1);
        //dot[15].setXOffset(x2);
       
       
        body[1] = new BodyPart("cuerpo.png",dot[1], dot[2]);                  // body centre
        body[2] = new BodyPart("leftarm.png",dot[3], dot[4]);                  // left arm
        body[3] = new BodyPart("rightarm.png",dot[6], dot[7]);                  // right arm
        body[4] = new BodyPart("lefthand.png", dot[5], dot[4]);
        body[5] = new BodyPart("righthand.png", dot[8], dot[7]);
        //body[6] = new BodyPart("leftleg.png",dot[2], dot[10]);                     // left leg
       // body[7] = new BodyPart("rightleg.png",dot[2], dot[13]);                     // right leg
        //body[8] = new BodyPart("left-foot.png", dot[10], dot[11]);
        //body[9] = new BodyPart("right-foot.png", dot[13], dot[14]);
         body[0] = new BodyPart("head0.png", dot[0], dot[1], 0, 0);    // head
        /*  body[0].dontStretch();
          body[1].dontStretch();
          body[2].dontStretch();
          body[3].dontStretch();
          body[4].dontStretch();
          body[5].dontStretch();
         // body[1].dontStretch();
          // body[6].dontStretch();
            //body[7].dontStretch();*/
          

        for (int i = 0; i < body.length-4; i++) {
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
            float cx = (float) (x[i] * Mundo.SCALE);
            float cy = (float) (y[i] * Mundo.SCALE);
            pose.setJoint(i, new Joint(i, 1.0f, null, new Point3D(cx, cy, 0.0f)));
        }

        return pose;
    }

}

