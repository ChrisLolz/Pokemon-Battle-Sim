/** 
 * battlePanel.Java
 * Panel used to display and simulate pokemon battles
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;

public class battlePanel extends JPanel {
  
  private BufferedImage battleTemplate;
  private Player player = Main.player;
  private boolean currentPanel = false;
  private boolean battleOver = false;
  private battleMouseListener mouseListener = new battleMouseListener(this);
  private Pokemon currentPokemon = player.getTeam(0);
  private int opponentLives = 5;
  private Pokemon opponentPokemon = new Pokemon(Species.randomSpecies());
  
  private boolean playerFirst = false;
  
  
  private move playerMove = this.currentPokemon.getMoves(1);
  private move opponentMove = null;
  
  private textLabel playerHealthDisplay = new textLabel(535,333, new Font("Arial", 1, 26), "sample text");
  private textLabel currentPokemonDisplay = new textLabel(385,283, new Font("Arial",0, 24), this.currentPokemon.getName());
  private textLabel opponentPokemonDisplay = new textLabel(3,83, new Font("Arial",0, 24), "sample text");
  private textLabel waitingDisplay = new textLabel(25,410, new Font("Arial", 0, 24), "What will " + this.currentPokemon.getName() + " do?");
  private textLabel playerUsed = new textLabel(25,410, new Font("Arial", 0, 24), this.currentPokemon.getName() + " used");
  private textLabel opponentUsed = new textLabel(25,410, new Font("Arial", 0, 24), "The foe's " + this.opponentPokemon.getName() + " used");
  private textLabel superEffective = new textLabel(25,410, new Font("Arial", 0, 24), "It's super effective!");
  private textLabel notEffective = new textLabel(25,410, new Font("Arial", 0, 24), "It's not very effective...");
  private textLabel noEffect = new textLabel(25,410, new Font("Arial", 0, 24), "The move had no effect.");
  private textLabel currentFainted = new textLabel(25,410, new Font("Arial", 0, 24), this.currentPokemon.getName() + " fainted!");
  private textLabel opponentFainted = new textLabel(25,410, new Font("Arial", 0, 24), "The foe's " + this.opponentPokemon.getName() + " fainted!");
  private textLabel missed = new textLabel(25,410, new Font("Arial", 0, 24), "sample text");
  private textLabel usedMoveLabel = new textLabel(25,440, new Font("Arial", 0, 24), "sample text");
  private textLabel burn = new textLabel(25,410, new Font("Arial", 0, 24), "sample text");
  private textLabel statusLabel = new textLabel(25,410, new Font("Arial", 0, 24), "sample text");
  private textLabel playerHurt, opponentHurt, paralysis, frozen, poison, moveFailed, alreadyHasConditionLabel;
  
  private button exitButton = new button(170,820,280,100, new Font("Arial", 1, 25), "EXIT", new Color(0,102,204));
  private button pokemonButton = new button(482,820,280,100, new Font("Arial", 1, 25), "POKEMON", new Color(0,153,0));
  private button fightButton = new button(328,630,500,200, new Font("Arial", 0, 22), "Fight", new Color(220,20,60));
  private button cancelButton = new button(328,820,560,100, new Font("Arial", 1, 25), "CANCEL", new Color(0,102,204));
  private button move1Button = new button(160,550,280,110, new Font("Arial", 1, 25), "", new Color(227,224,193), new Color(0,0,0));
  private button move2Button = new button(490,550,280,110, new Font("Arial", 1, 25), "", new Color(227,224,193), new Color(0,0,0));
  private button move3Button = new button(160,700,280,110, new Font("Arial", 1, 25), "", new Color(227,224,193), new Color(0,0,0));
  private button move4Button = new button(490,700,280,110, new Font("Arial", 1, 25), "", new Color(227,224,193), new Color(0,0,0));
  private textLabel move1Label = new textLabel(160,520, new Font("Arial", 1, 25), "sample text", true);
  private textLabel move2Label = new textLabel(490,520, new Font("Arial", 1, 25), "sample text", true);
  private textLabel move3Label = new textLabel(160,670, new Font("Arial", 1, 25), "sample text", true);
  private textLabel move4Label = new textLabel(490,670, new Font("Arial", 1, 25), "sample text", true);
  private textLabel move1TypeLabel = new textLabel(30,570, new Font("Arial", 0, 22), "sample text");
  private textLabel move2TypeLabel = new textLabel(360,570, new Font("Arial", 0, 22), "sample text");
  private textLabel move3TypeLabel = new textLabel(30,720, new Font("Arial", 0, 22), "sample text");
  private textLabel move4TypeLabel = new textLabel(360,720, new Font("Arial", 0, 22), "sample text");
  private textLabel move1PPLabel = new textLabel(170,570, new Font("Arial", 0, 22), "sample text");
  private textLabel move2PPLabel = new textLabel(500,570, new Font("Arial", 0, 22), "sample text");
  private textLabel move3PPLabel = new textLabel(170,720, new Font("Arial", 0, 22), "sample text");
  private textLabel move4PPLabel = new textLabel(500,720, new Font("Arial", 0, 22), "sample text");
  
  private button goBackButton = new button(600,830,80,80, new Font("Arial", 0, 20), "Go Back");
  private button playerParalyzedIcon = new button(453,301,40,20, new Font("Arial", 0, 18), "PAR", new Color(204,204,0));
  private button playerBurnIcon = new button(453,301,40,20, new Font("Arial", 0, 18), "BRN", new Color(255,51,51));
  private button playerFrozenIcon = new button(453,301,40,20, new Font("Arial", 0, 18), "FRZ", new Color(0,204,204));
  private button playerPoisonIcon = new button(453,301,40,20, new Font("Arial", 0, 18), "PSN", new Color(204,0,204));
  
  private button opponentParalyzedIcon = new button(65,100,40,20, new Font("Arial", 0, 18), "PAR", new Color(204,204,0));
  private button opponentBurnIcon = new button(65,100,40,20, new Font("Arial", 0, 18), "BRN", new Color(255,51,51));
  private button opponentFrozenIcon = new button(65,100,40,20, new Font("Arial", 0, 18), "FRZ", new Color(0,204,204));
  private button opponentPoisonIcon = new button(65,100,40,20, new Font("Arial", 0, 18), "PSN", new Color(204,0,204));
  
  private ArrayList<textLabel> interfaceList = new ArrayList<textLabel>();
  private ArrayList<status> battleQueue = new ArrayList<status>();
  private button[] selectPokemonButtons = new button[6];
  
  /**
   * Battlepanel constructor
   */
  battlePanel() {
    this.setFocusable(true);
    this.requestFocusInWindow();
    this.addMouseListener(mouseListener);
    this.update();
    try {
      this.battleTemplate = ImageIO.read(new File("assets/battleTemplate2.png"));
    } catch(Exception e) {
        System.out.println("Error loading image");
      }
    this.opponentPokemon.randomizeMoves();
    this.selectPokemonButtons[0] = new button(164,525,250,80, new Font("Arial", 0, 25), this.player.getTeam(0).getName(), new Color(0,153,0));
    this.selectPokemonButtons[1] = new button(492,525,250,80, new Font("Arial", 0, 25), this.player.getTeam(1).getName(), new Color(0,153,0));
    this.selectPokemonButtons[2] = new button(164,625,250,80, new Font("Arial", 0, 25), this.player.getTeam(2).getName(), new Color(0,153,0));
    this.selectPokemonButtons[3] = new button(492,625,250,80, new Font("Arial", 0, 25), this.player.getTeam(3).getName(), new Color(0,153,0));
    this.selectPokemonButtons[4] = new button(164,725,250,80, new Font("Arial", 0, 25), this.player.getTeam(4).getName(), new Color(0,153,0));
    this.selectPokemonButtons[5] = new button(492,725,250,80, new Font("Arial", 0, 25), this.player.getTeam(5).getName(), new Color(0,153,0));
  }
  
  /**
   * restartBattle
   * restarts pokemon battle
   */
  public void restartBattle() {
    this.player.resetTeam();
    this.battleQueue.clear();
    this.battleOver = false;
    this.player.resetTeam();
    this.currentPokemon = player.getTeam(0);
    this.opponentLives = 5;
    this.opponentPokemon = new Pokemon(Species.randomSpecies());
    this.opponentPokemon.randomizeMoves();
    for (int i=0; i<6; i++) {
      selectPokemonButtons[i].changeButtonColor(new Color(0,153,0));
      this.selectPokemonButtons[i].changeText(this.player.getTeam(i).getName());
    }
    this.currentPokemonDisplay = new textLabel(385,283, new Font("Arial",0, 24), this.currentPokemon.getName());
    this.playerUsed.changeText(this.currentPokemon.getName() + " used");
    this.currentFainted.changeText(this.currentPokemon.getName() + " fainted!");
    this.opponentFainted.changeText("The foe's " + this.opponentPokemon.getName() + " fainted!");
    this.waitingDisplay.changeText("What will " + this.currentPokemon.getName() + " do?");
    this.update();
  }
  
  /**
   * getExitButton
   * @return exitButton
   */
  public button getExitButton() {
    return this.exitButton;
  }
  
  /**
   * getFightButton
   * @return FightButton
   */
  public button getFightButton() {
    return this.fightButton;
  }
  
  /**
   * getMove1Button
   * @return Move1Button
   */
  public button getMove1Button() {
    return this.move1Button;
  }
  
  /**
   * getMove2Button
   * @return Move2Button
   */
  public button getMove2Button() {
    return this.move2Button;
  }
  
  /**
   * getMove3Button
   * @return Move3Button
   */
  public button getMove3Button() {
    return this.move3Button;
  }
  
    
  /**
   * getMove4Button
   * @return Move4Button
   */
  public button getMove4Button() {
    return this.move4Button;
  }
  
  /**
   * getCancelButton
   * @return CancelButton
   */
  public button getCancelButton() {
    return this.cancelButton;
  }
  
  /**
   * getBackButton
   * @return goBackButton
   */
  public button getBackButton() {
    return this.goBackButton;
  }
  
  /**
   * getPokemonButton
   * @return pokemonButton
   */
  public button getPokemonButton() {
    return this.pokemonButton;
  }
  
  //getter method
  public button[] getSelectionButtons() {
    return this.selectPokemonButtons;
  }
  
  //getter method
  public Pokemon getCurrentPokemon() {
    return this.currentPokemon;
  }
  
  //getter method
  public Pokemon getOpponentPokemon() {
    return this.opponentPokemon;
  }
  
  //getter method
  public boolean isBattleOver() {
    return this.battleOver;
  }
  
  //finishes battle
  public void finishBattle() {
    this.battleOver = true;
  }
  
  //changes battlequeue status
  public void switchStatus() {
    if ( (this.battleQueue.get(0) == status.YOU_WON) || (this.battleQueue.get(0) == status.YOU_LOST) ) {
      finishBattle();
    }
    this.battleQueue.remove(0);
    this.update();
  }
  
  //switches pokemon
  public void switchPokemon(int choice) {
    this.battleQueue.clear();
    if (this.currentPokemon.isFainted() == false) {
      int randomMove = (int)(Math.random()*4+1);
      this.opponentMove = this.opponentPokemon.getMoves(randomMove);
      this.battleQueue.add(status.CHANGE_PLAYER_POKEMON);
      decideFirstPokemon();
      this.battleQueue.remove(status.PLAYERMOVE);
      if (this.currentPokemon.hasStatusCondition() == true) {
        this.battleQueue.remove(status.PLAYER_HURT);
      }
    }
    this.currentPokemon = this.player.getTeam(choice);
    this.playerUsed.changeText(this.currentPokemon.getName() + " used");
    this.currentPokemonDisplay.changeText(this.currentPokemon.getName());
    this.waitingDisplay.changeText("What will " + this.currentPokemon.getName() + " do?");
    update();
  }
  
  //switches opponents pokemon
  public void switchOpponentPokemon() {
    this.opponentPokemon = new Pokemon(Species.randomSpecies());
    this.opponentPokemon.randomizeMoves();
    this.opponentUsed.changeText(this.opponentPokemon.getName() + " used");
    this.opponentPokemonDisplay.changeText(this.opponentPokemon.getName());
  }
  
  //check if picking move
  public boolean currentlyPicking() {
    if (this.battleQueue.get(0) == status.PICKAMOVE) {
      return true;
    } else {
      return false;
    }
  }
  
  //check if in menu
  public boolean inMenu() {
    if (this.battleQueue.get(0) == status.MAIN) {
      return true;
    } else {
      return false;
    }
  }
  
  //check if in pokemon screen
  public boolean inPokemonScreen() {
    if (this.battleQueue.get(0) == status.POKEMON_SCREEN) {
      return true;
    } else {
      return false;
    }
  }
  
  //game goes back to menu
  public void goBackToMenu() {
    this.battleQueue.clear();
    this.battleQueue.add(status.MAIN);
    this.battleQueue.add(status.PICKAMOVE);
    this.update();
  }
  
  //game goes to pokemon screen
  public void goToPokemonScreen() {
    this.battleQueue.clear();
    this.battleQueue.add(status.POKEMON_SCREEN);
    this.update();
  }
  
  //method that decides the first pokemon to move
  public void decideFirstPokemon() {
    int playerSpeed,opponentSpeed;
    double playerSpeedModifier = this.currentPokemon.getStatModifier("speed");
    double opponentSpeedModifier = this.opponentPokemon.getStatModifier("speed");
    if (this.currentPokemon.isParalyzed() == true) {
      playerSpeed = (int)(this.currentPokemon.getSpeed()*playerSpeedModifier*0.50);
    } else {
      playerSpeed = (int)(this.currentPokemon.getSpeed()*playerSpeedModifier);
    }
    if (this.opponentPokemon.isParalyzed() == true) {
      opponentSpeed = (int)(this.opponentPokemon.getSpeed()*opponentSpeedModifier*0.50);
    } else {
      opponentSpeed = (int)(this.opponentPokemon.getSpeed()*opponentSpeedModifier);
    }
    int randomMove = (int)(Math.random()*4+1);
    this.opponentMove = this.opponentPokemon.getMoves(randomMove);
    if (this.playerMove.getPriority()>this.opponentMove.getPriority()) {
      this.playerFirst = true;
      this.battleQueue.add(status.PLAYERMOVE);
      this.battleQueue.add(status.OPPONENTMOVE);
    } else if (this.playerMove.getPriority()<this.opponentMove.getPriority()) {
      this.playerFirst = false;
      this.battleQueue.add(status.OPPONENTMOVE);
      this.battleQueue.add(status.PLAYERMOVE);
    } else if (playerSpeed > opponentSpeed) {
      this.playerFirst = true;
      this.battleQueue.add(status.PLAYERMOVE);
      this.battleQueue.add(status.OPPONENTMOVE);
    } else if (playerSpeed < opponentSpeed) {
      this.playerFirst = false;
      this.battleQueue.add(status.OPPONENTMOVE);
      this.battleQueue.add(status.PLAYERMOVE);
    } else {
      if (Math.random() > 0.5) {
        this.playerFirst = true;
        this.battleQueue.add(status.PLAYERMOVE);
        this.battleQueue.add(status.OPPONENTMOVE);
      } else {
        this.playerFirst = false;
        this.battleQueue.add(status.OPPONENTMOVE);
        this.battleQueue.add(status.PLAYERMOVE);
      }
    }
    if ( (this.currentPokemon.isBurned() == true) || (this.currentPokemon.isPoisoned() == true) ) {
      this.battleQueue.add(battleQueue.indexOf(status.PLAYERMOVE)+1, status.PLAYER_HURT);
    } else if (this.currentPokemon.isFrozen() == true) {
      this.battleQueue.add(battleQueue.indexOf(status.PLAYERMOVE), status.PLAYER_HURT);
      this.battleQueue.remove(status.PLAYERMOVE);
    }
    if ( (this.opponentPokemon.isBurned() == true) || (this.opponentPokemon.isPoisoned() == true) ) {
      this.battleQueue.add(battleQueue.indexOf(status.OPPONENTMOVE)+1, status.OPPONENT_HURT);
    } else if (this.opponentPokemon.isFrozen() == true) {
      this.battleQueue.add(battleQueue.indexOf(status.OPPONENTMOVE), status.OPPONENT_HURT);
      this.battleQueue.remove(status.OPPONENTMOVE);
    }
  }
  
  //selects the pokemon move
  public void chooseMove(int choice) {
    this.playerMove = currentPokemon.getMoves(choice);
  }
 
  //gets the move of currentpokemon
  public move getMove(int choice) {
    return this.currentPokemon.getMoves(choice);
  }
  
  //loops through all move effects
  public void loopEffects(move move, status[] moveEffects, Pokemon user, Pokemon target) {
    for (status i: moveEffects) {
      if ( (i == status.FLINCH) && (this.battleQueue.contains(status.PLAYERMOVE) == true) && (this.battleQueue.contains(status.OPPONENTMOVE) == true) ) {
        this.battleQueue.add(1, i);
      } else if (i != status.FLINCH) {
        if (i == status.BURN) {
          if (user == this.currentPokemon) {
            this.burn.changeText("The foe's " + target.getName() + " was burned!");
            this.opponentHurt = new textLabel(25,410, new Font("Arial", 0, 24), "The foe's " + target.getName() + " was hurt it's burn!");
            if (this.battleQueue.contains(status.OPPONENTMOVE) == true) {
              this.battleQueue.add(this.battleQueue.size(), status.OPPONENT_HURT);
            }
          } else {
            this.burn.changeText(target.getName() + " was burned!");
            this.playerHurt = new textLabel(25,410, new Font("Arial", 0, 24), target.getName() + " was hurt it's burn!");
            if (this.battleQueue.contains(status.PLAYERMOVE) == true) {
              this.battleQueue.add(this.battleQueue.size(), status.PLAYER_HURT);
            }
          }
        } else if (i == status.PARALYZED) {
          if (user == this.currentPokemon) {
            this.paralysis = new textLabel(25,410, new Font("Arial", 0, 24), "The foe's " + target.getName() + " is paralyzed!", "It may be unable to move!");
            this.opponentHurt = new textLabel(25,410, new Font("Arial", 0, 24), "The foe's " + target.getName() + " is paralyzed!",  "It can't move!");
          } else {
            this.paralysis = new textLabel(25,410, new Font("Arial", 0, 24), target.getName() + " is paralyzed!", "It may be unable to move!");
            this.playerHurt = new textLabel(25,410, new Font("Arial", 0, 24), target.getName() + " is paralyzed!",  "It can't move!");
          }
        } else if (i == status.FROZEN) {
          if (user == this.currentPokemon) {
            this.frozen = new textLabel(25,410, new Font("Arial", 0, 24), "The foe's " + target.getName() , "was frozen solid!");
            this.opponentHurt = new textLabel(25,410, new Font("Arial", 0, 24), "The foe's " + target.getName(), "is frozen solid!");
            if (this.battleQueue.contains(status.OPPONENTMOVE) == true) {
              this.battleQueue.add(this.battleQueue.indexOf(status.OPPONENTMOVE), status.OPPONENT_HURT);
              this.battleQueue.remove(status.OPPONENTMOVE);
            }
          } else {
            this.frozen = new textLabel(25,410, new Font("Arial", 0, 24), target.getName(), "was frozen solid!");
            this.playerHurt = new textLabel(25,410, new Font("Arial", 0, 24), target.getName(),  "is frozen solid!");
            if (this.battleQueue.contains(status.PLAYERMOVE) == true) {
              this.battleQueue.add(this.battleQueue.indexOf(status.PLAYERMOVE), status.PLAYER_HURT);
              this.battleQueue.remove(status.PLAYERMOVE);
            }
          }
        } else if (i == status.POISONED) {
          if (user == this.currentPokemon) {
            this.poison = new textLabel(25,410, new Font("Arial", 0, 24), "The foe's " + target.getName() , "was poisoned!");
            this.opponentHurt = new textLabel(25,410, new Font("Arial", 0, 24), "The foe's " + target.getName() + " is hurt", "by poison!");
            if (this.battleQueue.contains(status.OPPONENTMOVE) == true) {
              this.battleQueue.add(this.battleQueue.size(), status.OPPONENT_HURT);
            }
          } else {
            this.poison = new textLabel(25,410, new Font("Arial", 0, 24), target.getName() + " was poisoned!");
            this.playerHurt = new textLabel(25,410, new Font("Arial", 0, 24), target.getName() + " is hurt",  "by poison!");
            if (this.battleQueue.contains(status.PLAYERMOVE) == true) {
              this.battleQueue.add(this.battleQueue.size(), status.PLAYER_HURT);
            }
          }
        } else if (i == status.FAILED) {
          this.moveFailed = new textLabel(25,410, new Font("Arial", 0, 24), move.getName() + " failed!");
        } else if (i == status.ALREADY_HAS_STATUS_CONDITION) {
          if (user == this.currentPokemon) {
            this.alreadyHasConditionLabel = new textLabel(25,410, new Font("Arial", 0, 24), "The foe's " + target.getName(), "already has a status condition!");
          } else {
            this.alreadyHasConditionLabel = new textLabel(25,410, new Font("Arial", 0, 24), target.getName(), "already has a status condition!");
          }
        }
        this.battleQueue.add(1, i);
      }
    }
  }
  
  //activates the move
  public void activateMove(move move, Pokemon user, Pokemon target) {
    if (move instanceof damageMove) {
      ((damageMove)move).attack(user, target);
      if (move instanceof hasSecondaryEffect) {
        status[] moveEffects = ((hasSecondaryEffect)move).useEffect(user, target);
        if (moveEffects != null) {
          loopEffects(move, moveEffects, user, target);
        }
      }
      if (((damageMove)move).checkEffectiveness(target) == Effectiveness.SUPER) {
        this.battleQueue.add(1,status.SUPEREFFECTIVE);
      } else if (((damageMove)move).checkEffectiveness(target) == Effectiveness.NOT) {
        this.battleQueue.add(1,status.NOTEFFECTIVE);
      } else if (((damageMove)move).checkEffectiveness(target) == Effectiveness.NONE) {
        this.battleQueue.add(1,status.NOEFFECT);
      }
    } else {
      status[] moveEffects = ((statusMove)move).useEffect(target);
      loopEffects(move, moveEffects, user, target);
    }
  }
  
  //changes the status label
  public void changeStatusLabel(String stat, String fellAdjective, String roseAdjective) {
    if (this.battleQueue.contains(status.OPPONENTMOVE) || ( (playerFirst == false) && (!this.battleQueue.contains(status.PLAYERMOVE)) ) ) {
      if (((statusMove)this.playerMove).moveIsBuff() == false) {
        this.statusLabel.changeText("The foe's " +  this.opponentPokemon.getName() + " " + stat + " " + fellAdjective);
      } else {
        this.statusLabel.changeText(this.currentPokemon.getName() + "'s " + stat + " " + roseAdjective);
      }
    } else if (this.battleQueue.contains(status.PLAYERMOVE) || ( (playerFirst == true) && (!this.battleQueue.contains(status.OPPONENTMOVE)) ) ) {
      if (((statusMove)this.opponentMove).moveIsBuff() == false) {
        this.statusLabel.changeText(this.currentPokemon.getName() + "'s " + stat + " " + fellAdjective);
      } else {
        this.statusLabel.changeText("The foe's " + this.opponentPokemon.getName() + " " + stat + " " + roseAdjective);
      }
    }
    interfaceList.add(this.statusLabel);
  }
  
  //updates the game display and calls repaint
  public void update() {
    interfaceList.clear();
    
    if (this.battleQueue.size() == 0) {
      this.battleQueue.add(status.MAIN);
      this.battleQueue.add(status.PICKAMOVE);
    }
    
    switch(this.battleQueue.get(0)) {
      case MAIN:
        interfaceList.add(this.fightButton);
        interfaceList.add(this.exitButton);
        interfaceList.add(this.pokemonButton);
        interfaceList.add(this.waitingDisplay);
        break;
      case FAINTED:
        if (this.currentPokemon.isFainted() == true) {
          interfaceList.add(new textLabel(25,410, new Font("Arial", 0, 24), this.currentPokemon.getName() + " fainted!"));
        } else {
          interfaceList.add(new textLabel(25,410, new Font("Arial", 0, 24), this.opponentPokemon.getName() + " fainted!"));
          switchOpponentPokemon();
        }
        break;
      case POKEMON_SCREEN:
        for (int i=0; i<selectPokemonButtons.length; i++) {
          if (this.player.getTeam(i).isFainted() == true) {
            selectPokemonButtons[i].changeButtonColor(new Color(255,0,0));
          }
        }
        for (button i: this.selectPokemonButtons) {
          interfaceList.add(i);
        }
        if (this.currentPokemon.isFainted() == false) {
          interfaceList.add(this.goBackButton);
        }
        interfaceList.add(new textLabel(25,410, new Font("Arial", 0, 24), "Choose a pokemon."));
        break;
      case CHANGE_PLAYER_POKEMON:
        interfaceList.add(new textLabel(25,410, new Font("Arial", 0, 24), "Let's go " + this.currentPokemon.getName() + "!"));
        break;
      case CHANGE_OPPONENT_POKEMON:
        interfaceList.add(new textLabel(25,410, new Font("Arial", 0, 24), "The foe sent out " + this.opponentPokemon.getName() + "!"));
        break;
      case PICKAMOVE:
        this.move1Label.changeText(this.currentPokemon.getMoves(1).getName());
        this.move2Label.changeText(this.currentPokemon.getMoves(2).getName());
        this.move3Label.changeText(this.currentPokemon.getMoves(3).getName());
        this.move4Label.changeText(this.currentPokemon.getMoves(4).getName());
        this.move1TypeLabel.changeText(this.currentPokemon.getMoves(1).getType()+"");
        this.move2TypeLabel.changeText(this.currentPokemon.getMoves(3).getType()+"");
        this.move3TypeLabel.changeText(this.currentPokemon.getMoves(2).getType()+"");
        this.move4TypeLabel.changeText(this.currentPokemon.getMoves(4).getType()+"");
        this.move1PPLabel.changeText("PP "+ this.currentPokemon.getMoves(1).getPP()+"/"+this.currentPokemon.getMoves(1).getMaxPP());
        this.move2PPLabel.changeText("PP " + this.currentPokemon.getMoves(2).getPP()+"/"+this.currentPokemon.getMoves(2).getMaxPP());
        this.move3PPLabel.changeText("PP " + this.currentPokemon.getMoves(3).getPP()+"/"+this.currentPokemon.getMoves(3).getMaxPP());
        this.move4PPLabel.changeText("PP " + this.currentPokemon.getMoves(4).getPP()+"/"+this.currentPokemon.getMoves(4).getMaxPP());
        interfaceList.add(this.cancelButton);
        interfaceList.add(this.move1Button);
        interfaceList.add(this.move2Button);
        interfaceList.add(this.move3Button);
        interfaceList.add(this.move4Button);
        interfaceList.add(this.move1Label);
        interfaceList.add(this.move2Label);
        interfaceList.add(this.move3Label);
        interfaceList.add(this.move4Label);
        interfaceList.add(this.move1TypeLabel);
        interfaceList.add(this.move2TypeLabel);
        interfaceList.add(this.move3TypeLabel);
        interfaceList.add(this.move4TypeLabel);
        interfaceList.add(this.move1PPLabel);
        interfaceList.add(this.move2PPLabel);
        interfaceList.add(this.move3PPLabel);
        interfaceList.add(this.move4PPLabel);
        interfaceList.add(this.waitingDisplay);
        break;
      case PLAYERMOVE:
        if ( ((this.currentPokemon.isParalyzed() == true) && (Math.random() <= 0.25))){
          interfaceList.add(this.playerHurt);
        } else {
          if (Math.random() > this.playerMove.getAccuracy()) {
            this.missed.changeText(this.currentPokemon.getName() + " missed!");
            interfaceList.add(this.missed);
            this.playerMove.usePP();
          } else {
            this.playerMove.usePP();
            this.usedMoveLabel.changeText(this.playerMove.getName()+"!");
            interfaceList.add(this.playerUsed);
            interfaceList.add(this.usedMoveLabel);
            activateMove(this.playerMove, this.currentPokemon, this.opponentPokemon);
          }
        }
        break;
      case OPPONENTMOVE:
        if ( ((this.opponentPokemon.isParalyzed() == true) && (Math.random() <= 0.25))) {
          interfaceList.add(this.opponentHurt);
        } else {
          if (Math.random() > this.opponentMove.getAccuracy()) {
            this.missed.changeText("The foe's " + this.opponentPokemon.getName() + " missed!");
            interfaceList.add(this.missed);
          } else {
            this.usedMoveLabel.changeText(this.opponentMove.getName()+"!");
            interfaceList.add(this.opponentUsed);
            interfaceList.add(this.usedMoveLabel);
            activateMove(this.opponentMove, this.opponentPokemon, this.currentPokemon);
          }
        }
        break;
      case SUPEREFFECTIVE:
        interfaceList.add(this.superEffective);
        break;
      case NOTEFFECTIVE:
        interfaceList.add(this.notEffective);
        break;
      case NOEFFECT:
        interfaceList.add(this.noEffect);
        break;
      case MISSED:
        interfaceList.add(this.missed);
        break;
      case FLINCH:
        if (this.battleQueue.contains(status.PLAYERMOVE)) {
          this.battleQueue.remove(status.PLAYERMOVE);
          this.statusLabel.changeText(this.currentPokemon.getName() + " flinched and couldn't move!");
        } else if (this.battleQueue.contains(status.OPPONENTMOVE)) {
          this.battleQueue.remove(status.OPPONENTMOVE);
          this.statusLabel.changeText("The foe's " + this.opponentPokemon.getName() + " flinched and couldn't move!");
        }
        interfaceList.add(statusLabel);
        break;
      case ATTACK_ROSE:
        changeStatusLabel("attack", "fell!", "rose!");
        break;
      case ATTACK_SHARPLY:
        changeStatusLabel("attack", "harshly! ", "sharply");
        break;
      case DEFENSE_ROSE:
        changeStatusLabel("defense", "fell!", "rose!");
        break;
      case DEFENSE_SHARPLY:
        changeStatusLabel("defense", "harshly!", "sharply!");
        break;
      case SPEED_ROSE:
        changeStatusLabel("speed", "fell!", "rose!");
        break;
      case SPEED_SHARPLY:
        changeStatusLabel("speed", "harshly!", "sharply!");
        break;
      case SPECIAL_ATTACK_ROSE:
        changeStatusLabel("special attack", "fell!", "rose!");
        break;
      case SPECIAL_ATTACK_SHARPLY:
        changeStatusLabel("special attack", "harshly!", "sharply!");
        break;
      case SPECIAL_DEFENSE_ROSE:
        changeStatusLabel("special defense", "fell!", "rose!");
        break;
      case SPECIAL_DEFENSE_SHARPLY:
        changeStatusLabel("special defense", "harshly!", "sharply!");
        break;
      case ATTACK_CANT_CHANGE:
        changeStatusLabel("attack", "won't go any lower!", "won't go any higher!");
        break;
      case DEFENSE_CANT_CHANGE:
        changeStatusLabel("defense", "won't go any lower!", "won't go any higher!");
        break;
      case SPEED_CANT_CHANGE:
        changeStatusLabel("speed", "won't go any lower!", "won't go nay higher!");
        break;
      case SPECIAL_ATTACK_CANT_CHANGE:
        changeStatusLabel("special attack", "won't go any lower!", "won't go any higher!");
        break;
      case SPECIAL_DEFENSE_CANT_CHANGE:
        changeStatusLabel("special defense", "won't go any lower!", "won't go any higher!");
        break;
      case BURN:
        interfaceList.add(this.burn);
        break;
      case PARALYZED:
        interfaceList.add(this.paralysis);
        break;
      case FROZEN:
        interfaceList.add(this.frozen);
        break;
      case POISONED:
        interfaceList.add(this.poison);
        break;
      case PLAYER_HURT:
        if (this.currentPokemon.isBurned() == true) {
          this.currentPokemon.changeHealth((int)-(this.currentPokemon.getMaxHealth()*(1.0/16)));
        } else if ( (this.currentPokemon.isFrozen() == true) && (Math.random()<=0.20) ) {
          this.currentPokemon.curePokemon();
          this.interfaceList.add(new textLabel(25,410, new Font("Arial", 0, 24), this.currentPokemon.getName(),"thawed out!"));
          this.battleQueue.add(1, status.PLAYERMOVE);
        } else if (this.currentPokemon.isPoisoned() == true) {
          this.currentPokemon.changeHealth((int)-(this.currentPokemon.getMaxHealth()*(1.0/8)));
        }
        interfaceList.add(this.playerHurt);
        break;
      case OPPONENT_HURT:
        if (this.opponentPokemon.isBurned() == true) {
          this.opponentPokemon.changeHealth((int)-(this.opponentPokemon.getMaxHealth()*(1.0/16)));
        } else if ( (this.opponentPokemon.isFrozen() == true) && (Math.random()<=0.20) ) {
          this.opponentPokemon.curePokemon();
          this.interfaceList.add(new textLabel(25,410, new Font("Arial", 0, 24), "The foe's " + this.opponentPokemon.getName(), "thawed out!"));
          this.battleQueue.add(1, status.OPPONENTMOVE);
        } else if (this.opponentPokemon.isPoisoned() == true) {
          this.opponentPokemon.changeHealth((int)-(this.opponentPokemon.getMaxHealth()*(1.0/8)));
        }
        interfaceList.add(this.opponentHurt);
        break;
      case ALREADY_HAS_STATUS_CONDITION:
        interfaceList.add(this.alreadyHasConditionLabel);
        break;
      case FAILED:
        interfaceList.add(this.moveFailed);
        break;
      case YOU_LOST:
        interfaceList.add(new textLabel(25,410, new Font("Arial", 0, 24), "You lost! Better luck next time!"));
        break;
      case YOU_WON:
        interfaceList.add(new textLabel(25,410, new Font("Arial", 0, 24), "You won! Congratulations!"));
        break;
    }
    if ( (this.opponentLives == 0) && (this.opponentPokemon.isFainted() == true) && (this.battleQueue.get(0) != status.YOU_WON)) {
      this.player.winGame();
      this.battleQueue.clear();
      this.battleQueue.add(status.YOU_WON);
      update();
    } else if ( (this.player.allFainted() == true) && (this.battleQueue.get(0) != status.YOU_LOST)) {
      this.player.loseGame();
      this.battleQueue.clear();
      this.battleQueue.add(status.YOU_LOST);
      update();
    } else if ( (this.currentPokemon.isFainted() == true) && (this.battleQueue.get(0) != status.FAINTED) && (this.battleQueue.get(0) != status.POKEMON_SCREEN) && (this.battleQueue.get(0) != status.YOU_LOST)) {
      this.battleQueue.clear();
      this.battleQueue.add(status.FAINTED);
      this.battleQueue.add(status.POKEMON_SCREEN);
    } else if ( (this.opponentPokemon.isFainted() == true) && (this.opponentLives > 0) && (this.battleQueue.get(0) != status.FAINTED)) {
      this.opponentLives -= 1;
      this.battleQueue.clear();
      this.battleQueue.add(status.FAINTED);
      this.battleQueue.add(status.CHANGE_OPPONENT_POKEMON);
      update();
    }
    repaint();
  }
  
  //paintComponnent Runs everytime the screen gets refreshed
  public void paintComponent(Graphics g) {
    int shift1=0;
    int shift2=0;
    for (int i=159; i>0; i--) {
      int pixel = this.currentPokemon.getBackSprite().getRGB(80,i);
      if (pixel>>24 == 0x00) {
        shift1 = 159-i;
      } else {
        break;
      }
    }
    outer: for (int y=159; y>0; y--) {
      for (int x=0; x<159; x++) {
        int pixel = this.opponentPokemon.getFrontSprite().getRGB(x,y);
        if (pixel>>24 == 0x00) {
          shift2 = 159-y;
        } else {
          break outer;
        }
      }
    }
    super.paintComponent(g); //required
    setDoubleBuffered(true);
    g.drawImage(battleTemplate, 0,0,null);
    g.drawImage(this.currentPokemon.getBackSprite(), 105, 210+shift1, null);
    g.drawImage(this.opponentPokemon.getFrontSprite(), 415, 70+shift2, null);
    this.playerHealthDisplay.changeText(currentPokemon.getHealth() + "/" + currentPokemon.getMaxHealth());
    this.playerHealthDisplay.draw(g);
    this.currentPokemonDisplay.draw(g);
    this.opponentPokemonDisplay.changeText(this.opponentPokemon.getName());
    this.opponentPokemonDisplay.draw(g);
    if (this.currentPokemon.isBurned() == true) {
      this.playerBurnIcon.draw(g);
    } else if (this.currentPokemon.isParalyzed() == true) {
      this.playerParalyzedIcon.draw(g);
    } else if (this.currentPokemon.isFrozen() == true) {
      this.playerFrozenIcon.draw(g);
    } else if (this.currentPokemon.isPoisoned() == true) {
      this.playerPoisonIcon.draw(g);
    }
    if (this.opponentPokemon.isBurned() == true) {
      this.opponentBurnIcon.draw(g);
    } else if (this.opponentPokemon.isParalyzed()== true) {
      this.opponentParalyzedIcon.draw(g);
    } else if (this.opponentPokemon.isFrozen() == true) {
      this.opponentFrozenIcon.draw(g);
    } else if (this.opponentPokemon.isPoisoned() == true) {
      this.opponentPoisonIcon.draw(g);
    }
    
    g.setColor(new Color(0,128,0));
    g.fillRect(516,296,(int)(126*((double)this.currentPokemon.getHealth()/this.currentPokemon.getMaxHealth())),11);
    g.fillRect(129,96,(int)(126*((double)this.opponentPokemon.getHealth()/this.opponentPokemon.getMaxHealth())),11);
    for (int i=0; i<interfaceList.size(); i++) {
        interfaceList.get(i).draw(g);
    }
  }
}   