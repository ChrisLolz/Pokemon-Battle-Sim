/** 
 * mainMenuPanel.Java
 * menu panel for the game which is used as the main hub for the game
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import java.util.ArrayList;

public class mainMenuPanel extends JPanel {
  private Player player = Main.player;
  private boolean currentPanel = true;
  private status menuPage = status.MAIN;
  private menuMouseListener mouseListener = new menuMouseListener(this);
  private button battleButton = new button(328,150,300,100, new Font("Arial", 0, 70), "Battle");
  private button changeTeamButton = new button(328,300,300,100, new Font("Arial", 0, 40), "Change Team");
  private button changeMovesButton = new button(328,450,300,100, new Font("Arial", 0, 40), "Change Moves");
  private button playerStatsButton = new button(328,600,300,100, new Font("Arial", 0, 40), "Stats");
  private button saveButton = new button(328,760,300,100, new Font("Arial", 0, 40), "Save");
  private button goBackButton = new button(328,820,200,50, new Font("Arial", 0, 20), "Go back");
  private button wins = new button(328,150,300,100, new Font("Arial", 0, 50), "Wins: "+this.player.getWins());
  private button losses = new button(328,300,300,100, new Font("Arial", 0, 50), "Losses: "+this.player.getLosses());
  private button[] pokemonButtons = new button[6];
  private button[] moveButtons = new button[4];
  private int currentPokemon = 0;
  private int currentMove = 0;
  private ArrayList<Species> pokemonList = new ArrayList<Species>();
  private ArrayList<button> pokemonListButtons = new ArrayList<button>();
  private ArrayList<button> moveListButtons = new ArrayList<button>();
  
  //Constructor
  mainMenuPanel() {
    //JPanel Stuff
    this.setFocusable(true);
    this.requestFocusInWindow();
    this.addMouseListener(mouseListener);
    for (Species species: Species.values()) {
      pokemonList.add(species);
    }
    for (int i=0; i<this.pokemonList.size(); i++) {
      pokemonListButtons.add(new button(500,50+(i*25),100,20, new Font("Arial", 0, 10), pokemonList.get(i).NAME));
    }
  }
  
  public void setCurrentPage(status page) {
    this.menuPage = page;
  }
  
  public int getCurrentPokemon() {
    return this.currentPokemon;
  }
  
  public int getCurrentMove() {
    return this.currentMove;
  }
  
  public status getPage() {
    return this.menuPage;
  }
  
  public ArrayList<Species> getPokemonList() {
    return this.pokemonList;
  }
  
  public ArrayList<button> getPokemonListButtons() {
    return this.pokemonListButtons;
  }
  
  
  public button[] getMoveButtons() {
    return this.moveButtons;
  }
  
  public ArrayList<button> getMoveListButtons() {
    return this.moveListButtons;
  }
  
  public button[] getPokemonButtons() {
    return this.pokemonButtons;
  }
  
  public void loadMoveListButtons() {
    this.moveListButtons.clear();
    for (int i=0; i<this.player.getTeam(this.currentPokemon).getMoveSet().length; i++) {
      this.moveListButtons.add(new button(500,50+(i*25),100,20, new Font("Arial", 0, 10), this.player.getTeam(this.currentPokemon).getMoveSet()[i].getName()));
    }
  }
  
  public void selectPokemon(int select) {
    this.currentPokemon = select;
  }
  
  public void selectMove(int select) {
    this.moveListButtons.clear();
    this.currentMove = select;
  }
  
  public button getBattleButton() {
    return this.battleButton;
  }
  
  public button getChangeTeamButton() {
    return this.changeTeamButton;
  }
  
  public button getChangeMovesButton() {
    return this.changeMovesButton;
  }
  
  public button getGoBackButton() {
    return this.goBackButton;
  }
  
  public button getSaveButton() {
    return this.saveButton;
  }
  
  public button getStatsButton() {
    return this.playerStatsButton;
  }
  
  public void turnOffPanel() {
    this.currentPanel = false;
  }
  
  public void turnOnPanel() {
    this.currentPanel = true;
  }
  
  public boolean isCurrentPanel() {
    return this.currentPanel;
  }
  
  public void refresh() {
    this.repaint();
  }
  
  //paintComponnent Runs everytime the screen gets refreshed
  public void paintComponent(Graphics g) { 
    this.mouseListener.closeClip();
    super.paintComponent(g); //required
    setDoubleBuffered(true);
    if (this.menuPage == status.MAIN) {
      this.battleButton.draw(g);
      this.changeTeamButton.draw(g);
      this.changeMovesButton.draw(g);
      this.playerStatsButton.draw(g);
      this.saveButton.draw(g);
    } else if (this.menuPage == status.STATS) {
      this.goBackButton.draw(g);
      this.wins.draw(g);
      this.losses.draw(g);
    }else if ( (this.menuPage == status.CHANGE_TEAM) || (this.menuPage == status.POKEMON_SELECTION) ) {
      for (int i = 0; i<6; i++) {
        this.pokemonButtons[i] = new button(175,100+(125*i),300,100, new Font("Arial", 0, 30), player.getTeam(i).getName());
        this.pokemonButtons[i].draw(g);
      }
      this.goBackButton.draw(g);
      if (this.menuPage == status.POKEMON_SELECTION) {
        for (button i: pokemonListButtons) {
          i.draw(g);
        }
      }
    } else if (this.menuPage == status.CHANGE_MOVES) {
      for (int i = 0; i<6; i++) {
        this.pokemonButtons[i] = new button(328,100+(125*i),300,100, new Font("Arial", 0, 30), this.player.getTeam(i).getName());
        this.pokemonButtons[i].draw(g);
      }
      this.goBackButton.draw(g);
    } else if ( (this.menuPage == status.MOVE_SELECTION) || (this.menuPage == status.MOVE_LIST) ) {
      this.goBackButton.draw(g);
      for (int i = 0; i<4; i++) {
        this.moveButtons[i] = new button(150,100+(i*200),200,100, new Font("Arial", 0, 25), this.player.getTeam(this.currentPokemon).getMoves(i+1).getName());
        this.moveButtons[i].draw(g);
      }
      if (this.menuPage == status.MOVE_LIST) {
        for (int i=0; i<this.player.getTeam(this.currentPokemon).getMoveSet().length; i++) {
          this.moveListButtons.get(i).draw(g);
        }
      }
    } 
  }   
}