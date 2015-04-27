import greenfoot.*;

/**
 * Write a description of class menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class menu extends World
{

    /**
     * Constructor for objects of class menu.
     * 
     */
    public menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         super(800, 600, 1); 
         
         humano h= new humano();
         creaComida();
         addObject(h,400,500);
         setBackground("back.jpg");
          
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
}
