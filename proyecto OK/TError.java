import greenfoot.*;

/**
 * This class is used to create the text to display an error if the Kinect sensor is not connected
 * 
 * @author Hugo Limón, Valeria Cortez 
 * @version 0.1
 */
public class TError extends Texto
{
    public TError(){
        setImage("error no conectado.png");
        GreenfootImage i=getImage();
        i.scale(650,400);
    }
}
