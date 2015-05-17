import greenfoot.*;

/**
 * This class is used for button that leads to the "Game" section
 * 
 * @author Hugo Limón, Valeria Cortez 
 * @version 17/05/2015
 */
public class Start extends Boton
{
    public Start(){
        setImage("jugar.png");
        super.imagen(200,80); 
    }
    
    /**
     * This method is called whenever the button is pressed, to change the appareance of the button
     */
    public void juega()
    {
        setImage("jugar.png");
        super.imagen(200,80);
        
    }
    
} 
