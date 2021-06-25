/** 
 * startMenuPanel.Java
 * Start menu panel for the game
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;

public class startMenuPanel extends JPanel {
  
  private button playButton = new button(640,150,300,100, new Font("Arial", 0, 70), "Start");
  private button settingButton = new button(640,350,300,100, new Font("Arial", 0, 70), "Settings");
  private button helpButton = new button(640,550,300,100, new Font("Arial",0,70), "Help");
  private startMouseListener mouseListener = new startMouseListener(this);

  //Constructor
  startMenuPanel() {
    //JPanel Stuff
    this.setFocusable(true);
    this.requestFocusInWindow();
    this.addMouseListener(mouseListener);
  }
  
  public button getPlayButton() {
    return this.playButton;
  }
  public button getSettingButton() {
    return this.settingButton;
  }
  public button getHelpButton() {
    return this.helpButton;
  }
  public startMouseListener getListener() {
    return this.mouseListener;
  }
  
  //paintComponnent Runs everytime the screen gets refreshed
  public void paintComponent(Graphics g) {   
    super.paintComponent(g); //required
    setDoubleBuffered(true);
    this.playButton.draw(g);
    this.settingButton.draw(g);
    this.helpButton.draw(g);
  }   
}