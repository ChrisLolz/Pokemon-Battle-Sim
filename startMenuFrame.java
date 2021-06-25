/** 
 * startMenuFrame.Java
 * Start menu frame for the game
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

//Imports
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;

public class startMenuFrame extends JFrame { 
  private startMenuPanel menuPanel = new startMenuPanel();
  private JFrame thisFrame;
  
  //Constructor - this runs first
  startMenuFrame() { 
    super("Start Screen");
    this.thisFrame = this;  
    
    //configure the window
    this.setSize(1280,720);    
    this.setLocationRelativeTo(null); //start the frame in the center of the screen
    this.setResizable (false);
    this.setVisible(true);
    this.requestFocusInWindow();
    
    //Add the menu panel
    this.add(menuPanel);

  }
  public startMenuPanel getPanel() {
    return this.menuPanel;
  }
  public void update() {
    this.repaint();
  }
  
}