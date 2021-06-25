/** 
 * startMouseListener.Java
 * Contains methods for mouse interaction in the start menu
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class startMouseListener implements MouseListener {
    private startMenuPanel startMenu;
    private boolean start = false;
    
    startMouseListener(startMenuPanel startMenu) {
      this.startMenu = startMenu;
    }
    
    public void mouseClicked(MouseEvent e) {
    }
    
    public boolean hasStarted() {
      return this.start;
    }
    
    public void mousePressed(MouseEvent e) {
    }
    
    public void mouseReleased(MouseEvent e) {
      if (this.startMenu.getPlayButton().inButton(e.getX(),e.getY()) == true) {
        this.start = true;
      }
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
    }
  } //end of mouselistener