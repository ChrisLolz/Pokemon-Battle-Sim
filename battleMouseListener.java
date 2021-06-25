/** 
 * battleMouseListener.Java
 * Contains methods for mouse interaction in the battle menu
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class battleMouseListener implements MouseListener {
  private battlePanel battle;
  private Player player = Main.player;
  
  /**
   * Pokemon constructor
   * @param the battle panel
   */
  battleMouseListener(battlePanel battle) {
    this.battle = battle;
  }
  
  public void mouseClicked(MouseEvent e) {
  }
  
  public void mousePressed(MouseEvent e) {
  }
  
  /**
   * mouseReleased
   * method for when the mouse is released in battle panel
   * @param mouseevent
   */
  public void mouseReleased(MouseEvent e) {
    //System.out.println(e.getX()+","+e.getY());
    if (this.battle.inMenu() == true) {
      if (this.battle.getFightButton().inButton(e.getX(), e.getY()) == true) {
        this.battle.switchStatus();
      } else if (this.battle.getExitButton().inButton(e.getX(), e.getY()) == true) {
        this.battle.finishBattle();
      } else if (this.battle.getPokemonButton().inButton(e.getX(), e.getY()) == true) {
        this.battle.goToPokemonScreen();
      }
    }else if (this.battle.inPokemonScreen()){
      for (int i =0; i<this.battle.getSelectionButtons().length; i++) {
        if (this.battle.getSelectionButtons()[i].inButton(e.getX(), e.getY()) == true) {
          if ( (player.getTeam(i) != this.battle.getCurrentPokemon()) && (player.getTeam(i).isFainted() == false) ) {
            this.battle.switchPokemon(i);
          }
        } else if (this.battle.getBackButton().inButton(e.getX(), e.getY()) == true) {
          this.battle.goBackToMenu();
        }
      }
    }else if (this.battle.currentlyPicking() == true) {
      if (this.battle.getMove1Button().inButton(e.getX(), e.getY()) == true) {
        if (this.battle.getMove(1).getPP() > 0) {
          this.battle.chooseMove(1);
          this.battle.decideFirstPokemon();
          this.battle.switchStatus();
        }
      } else if (this.battle.getMove2Button().inButton(e.getX(), e.getY()) == true) {
        if (this.battle.getMove(2).getPP() > 0) {
          this.battle.chooseMove(2);
          this.battle.decideFirstPokemon();
          this.battle.switchStatus();
        }
      } else if (this.battle.getMove3Button().inButton(e.getX(), e.getY()) == true) {
        if (this.battle.getMove(3).getPP() > 0) {
          this.battle.chooseMove(3);
          this.battle.decideFirstPokemon();
          this.battle.switchStatus();
        }
      } else if (this.battle.getMove4Button().inButton(e.getX(), e.getY()) == true) {
        if (this.battle.getMove(4).getPP() > 0) {
          this.battle.chooseMove(4);
          this.battle.decideFirstPokemon();
          this.battle.switchStatus();
        }
      } else if (this.battle.getCancelButton().inButton(e.getX(), e.getY()) == true) {
        this.battle.goBackToMenu();
      }
    } else {
      this.battle.switchStatus();
    }
  }
  
  public void mouseEntered(MouseEvent e) {
  }
  
  public void mouseExited(MouseEvent e) {
  }
}