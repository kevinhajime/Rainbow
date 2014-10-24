// Chapter 6 Question 19 by Kevin Shenk

// ________________________________________________

/*
importing functions that we need for running program 
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.Math;//import the math function in order to use squareroot 

public class Rainbow extends JPanel
{
 private Color skyColor=Color.cyan;//Sky color set as Cyan

  public Rainbow()//public class Rainbow
  {
    setBackground(skyColor);//setting bg color to skyColor 
  }

 
  public void paintComponent(Graphics g) // Draws the rainbow.
  {
    super.paintComponent(g);
    int width = getWidth();    
    int height = getHeight();
    int xCenter = (int)(width/2);//using value used from textbook/
    int yCenter = (int)(height*3/4.0); //using value used from textbook

  
 
    // Declare and initialize the radius of the large semicircle:
    // ________________________________________________
    int largeRadius = (int)(width/4.0); // sets the radius
    g.setColor(Color.RED);//sets the color 
    g.fillArc(xCenter-largeRadius, yCenter-largeRadius, largeRadius*2, largeRadius*2, 0, 180);//(x,y,size,size,from,degrees)

    
    int smallRadius = (int)(height/4); // sets the radius of small radius. Placed before so it's declared before its used
    
    int mediumRadius = (int)Math.sqrt(largeRadius*smallRadius);// sets the radius 	
    g.setColor(Color.GREEN);//sets the color 
    g.fillArc(xCenter-mediumRadius, yCenter-mediumRadius, mediumRadius*2, mediumRadius*2, 0, 180);//(x,y,size,size,from,degrees)
    
    
    g.setColor(Color.MAGENTA);//sets the color  
    g.fillArc(xCenter-smallRadius, yCenter-smallRadius, smallRadius*2, smallRadius*2, 0, 180);//(x,y,size,size,from,degrees)
    
    
    int tinyRadius = ((mediumRadius)-(smallRadius/2));//radius of innermost circle
    g.setColor(skyColor);//using skyColor variable. skyColor is set as Cyan at the top of code
    g.fillArc(xCenter-tinyRadius, yCenter-tinyRadius, tinyRadius*2, tinyRadius*2, 0, 180);//(x,y,size,size,from,degrees)
    
    
  }

  public static void main(String[] args)//main function that displays the window with the rainbow. 
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
