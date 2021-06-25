/** 
 * menuMouseListener.Java
 * Contains methods for mouse interaction in the main menu
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.io.File;
import javax.sound.sampled.*;

public class menuMouseListener implements MouseListener {
    private Player player = Main.player;
    private mainMenuPanel menuPanel;
    private boolean canSwitchMove = true;
    private File music;
    private AudioInputStream audioStream;
    private DataLine.Info info;
    private Clip clip;
    menuMouseListener(mainMenuPanel menuPanel) {
      this.menuPanel = menuPanel;
      try {
        this.music = new File("assets/music.wav");
        this.audioStream = AudioSystem.getAudioInputStream(music);
        this.info = new DataLine.Info(Clip.class, this.audioStream.getFormat());
        this.clip = (Clip) AudioSystem.getLine(this.info);
      } catch (Exception e) {
        e.printStackTrace();
      }
      
    }
    
    public void mouseClicked(MouseEvent e) {
    }
    
    public void mousePressed(MouseEvent e) {
    }
    
    public void closeClip() {
      this.clip.close();
    }
    
    
    public void mouseReleased(MouseEvent e) {
      switch (this.menuPanel.getPage()) {
        case MAIN:
          if (this.menuPanel.getBattleButton().inButton(e.getX(), e.getY()) == true) {
            this.menuPanel.turnOffPanel();
            try {//very loud music
              this.audioStream = AudioSystem.getAudioInputStream(music);
              this.clip.open(this.audioStream);
              this.clip.start();
            } catch (Exception p) {
              p.printStackTrace();
            }
          } else if (this.menuPanel.getChangeTeamButton().inButton(e.getX(), e.getY()) == true) {
            this.menuPanel.setCurrentPage(status.CHANGE_TEAM);
          } else if (this.menuPanel.getChangeMovesButton().inButton(e.getX(), e.getY()) == true) {
            this.menuPanel.setCurrentPage(status.CHANGE_MOVES);
          } else if (this.menuPanel.getStatsButton().inButton(e.getX(), e.getY()) == true) {
            this.menuPanel.setCurrentPage(status.STATS);
          } else if (this.menuPanel.getSaveButton().inButton(e.getX(), e.getY()) == true) {
            try {
              this.player.saveTeam();
            } catch(Exception x) {
              System.out.println("Error: couldn't save file");
            }
          }
          break;
        case STATS:
          if (this.menuPanel.getGoBackButton().inButton(e.getX(), e.getY()) == true) {
            this.menuPanel.setCurrentPage(status.MAIN);
          }
          break;
        case CHANGE_MOVES:
          for (int i=0; i<6; i++) {
            if (this.menuPanel.getPokemonButtons()[i].inButton(e.getX(), e.getY()) == true) {
              this.menuPanel.selectPokemon(i);
              this.menuPanel.setCurrentPage(status.MOVE_SELECTION);
            } 
          }
          if (this.menuPanel.getGoBackButton().inButton(e.getX(), e.getY()) == true) {
            this.menuPanel.setCurrentPage(status.MAIN);
          }
          break;
        case MOVE_SELECTION:
          for (int i=0; i<this.menuPanel.getMoveButtons().length; i++) {
            if (this.menuPanel.getMoveButtons()[i].inButton(e.getX(), e.getY()) == true) {
              this.menuPanel.selectMove(i);
              this.menuPanel.loadMoveListButtons();
              this.menuPanel.setCurrentPage(status.MOVE_LIST);
            } 
          }
          if (this.menuPanel.getGoBackButton().inButton(e.getX(), e.getY()) == true) {
            this.menuPanel.setCurrentPage(status.CHANGE_MOVES);
          }
          break;
        case MOVE_LIST:
          for (int i =0; i<this.menuPanel.getMoveListButtons().size(); i++) {
            if (this.menuPanel.getMoveListButtons().get(i).inButton(e.getX(), e.getY()) == true)  {
              for (int j=0; j<4; j++) {
                if (this.player.getTeam(this.menuPanel.getCurrentPokemon()).getMoves(j+1) == this.player.getTeam(this.menuPanel.getCurrentPokemon()).getMoveSet()[i]) {
                  this.canSwitchMove = false;
                }
              }
              if (this.canSwitchMove == true) {
                this.player.getTeam(this.menuPanel.getCurrentPokemon()).setMoveFromIndex(this.menuPanel.getCurrentMove(), i);
              }
              this.canSwitchMove = true;
            }
          }
          if (this.menuPanel.getGoBackButton().inButton(e.getX(), e.getY()) == true) {
            this.menuPanel.setCurrentPage(status.MOVE_SELECTION);
          }
          break;
        case CHANGE_TEAM:
          for (int i=0; i<6; i++) {
            if (this.menuPanel.getPokemonButtons()[i].inButton(e.getX(), e.getY()) == true) {
              this.menuPanel.selectPokemon(i);
              this.menuPanel.setCurrentPage(status.POKEMON_SELECTION);
            } 
          }
          if (this.menuPanel.getGoBackButton().inButton(e.getX(), e.getY()) == true) {
            this.menuPanel.setCurrentPage(status.MAIN);
          }
          break;
        case POKEMON_SELECTION:
          for (int i=0; i<this.menuPanel.getPokemonListButtons().size(); i++) {
            if (this.menuPanel.getPokemonListButtons().get(i).inButton(e.getX(), e.getY()) == true) {
              this.player.changePokemon(this.menuPanel.getCurrentPokemon(), this.menuPanel.getPokemonList().get(i));
            }
          }
          if (this.menuPanel.getGoBackButton().inButton(e.getX(), e.getY()) == true) {
            this.menuPanel.setCurrentPage(status.CHANGE_TEAM);
          }
      }
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
    }
}