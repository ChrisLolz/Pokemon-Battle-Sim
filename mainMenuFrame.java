/** 
 * mainMenuFrame.Java
 * Game frame for the game
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;
import java.awt.CardLayout;

public class mainMenuFrame extends JFrame { 
  private mainMenuPanel mainPanel = new mainMenuPanel();
  private battlePanel battle = new battlePanel();
  private JFrame thisFrame;
  private CardLayout cards = new CardLayout();
  
  //Constructor - this runs first
  mainMenuFrame() { 
    super("Pokemon Champions");
    this.thisFrame = this;  
    
    //configure the window
    this.setSize(672,920);    
    this.setLocationRelativeTo(null); //start the frame in the center of the screen
    this.setResizable (false);
    this.setVisible(true);
    this.requestFocusInWindow();
    
    //Add the menu panel
    this.setLayout(cards);
    this.add(mainPanel,"Main");
    this.add(battle, "Battle");
  }
  
  //update panels
  public void update() {
    if ( (this.mainPanel.isCurrentPanel() == true) || (this.battle.isBattleOver() == true) ) {
      this.mainPanel.turnOnPanel();
      this.mainPanel.refresh();
      this.cards.show(this.getContentPane(), "Main");
      this.battle.restartBattle();
    } else if ( (this.battle.isBattleOver() == false) && (this.mainPanel.isCurrentPanel() == false) ) {
      this.cards.show(this.getContentPane(), "Battle");
    }
  }
  
}