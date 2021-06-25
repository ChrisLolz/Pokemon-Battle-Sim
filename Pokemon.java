/** 
 * Pokemon.Java
 * class used for pokemon behaviour and to make individual pokemon objects
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Pokemon {
  private final String NAME;
  private int health, MAX_HEALTH, ATTACK, DEFENSE, SPEC_ATTACK, SPEC_DEFENSE, SPEED;
  private Type TYPE1;
  private Type TYPE2;
  private move[] MOVESET;
  private move[] moves = new move[4];
  private boolean fainted = false;
  private int[] statStages={0,0,0,0,0};//index 0=attack, index 1=defense, index 2=special attack, index 3=special defense, and index 4 = speed
  private BufferedImage BACK_SPRITE,FRONT_SPRITE;

  private boolean poisoned = false;
  private boolean burned = false;
  private boolean frozen = false;
  private boolean paralyzed = false;
  
  
  /**
   * Pokemon constructor
   * @param species the species of the pokemon
   */
  Pokemon(Species species) {
    this.NAME = species.NAME;
    this.health = species.HEALTH;
    this.ATTACK = species.ATTACK;
    this.DEFENSE = species.DEFENSE;
    this.SPEC_ATTACK = species.SPEC_ATTACK;
    this.SPEC_DEFENSE = species.SPEC_DEFENSE;
    this.SPEED = species.SPEED;
    this.TYPE1 = species.TYPE1;
    this.TYPE2 = species.TYPE2;
    this.MOVESET = species.getMoveSet(species);
    this.MAX_HEALTH = health;
    try {
      this.FRONT_SPRITE = ImageIO.read(new File("assets/"+this.NAME.toLowerCase()+"Front.png"));
      this.BACK_SPRITE = ImageIO.read(new File("assets/"+this.NAME.toLowerCase()+"Back.png"));
    } catch(Exception e) {
        System.out.println("Error loading image");
    }
  }
  
  /**
   * getName
   * getter method for name
   * @returns name of pokemon
   */
  public String getName() {
    return this.NAME;
  }
  
  /**
   * changeStatStage
   * @param stat the stat you want to change
   * @param change the change you want to make to the stat
   * @returns true if changing the move was successful and false if it's maxed out
   */
  public boolean changeStatStage(int stat, int change) {
    if ( (statStages[stat]+change <= 6) && (statStages[stat]+change >= -6) ) {
      this.statStages[stat] = this.statStages[stat] + change;
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * hasStatusCondition
   * method that finds out if the pokemon has a status condition
   * @returns true if it has status and false otherwise
   */
  public boolean hasStatusCondition() {
    if ( (this.burned == true) || (this.poisoned == true) || (this.paralyzed == true) || (this.frozen==true) ) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * resetPokemon
   * method that restarts the pokemons stats
   */
  public void resetPokemon() {
    curePokemon();
    this.health = MAX_HEALTH;
    this.statStages = new int[]{0,0,0,0,0};
    this.fainted = false;
    for (move i: this.moves) {
      i.resetPP();
    }
  }
  
  /**
   * curePokemon
   * method that cures the pokemon's status effects
   */
  public void curePokemon() {
    this.burned = false;
    this.frozen = false;
    this.paralyzed = false;
    this.poisoned = false;
  }
  
 
  /**
   * burnPokemon
   * gives the pokemon burn status effect
   */
  public void burnPokemon() {
    this.burned = true;
  }
  
  /**
   * paralyzePokemon
   * gives the pokemon burn paralyzed status effect
   */
  public void paralyzePokemon() {
    this.paralyzed = true;
  }
  
  /**
   * freezePokemon
   * gives the pokemon freeze status effect
   */
  public void freezePokemon() {
    this.frozen = true;
  }
  
  /**
   * poisonPokemon
   * gives the pokemon poison status effect
   */
  public void poisonPokemon() {
    this.poisoned = true;
  }
  
  /**
   * isPoisoned
   * @return returns boolean value of status effect
   */
  public boolean isPoisoned() {
    return this.poisoned;
  }
  
  /**
   * isFrozen
   * getter method for frozen
   * @return returns boolean value of status effect
   */
  public boolean isFrozen() {
    return this.frozen;
  }
  
  /**
   * isParalyzed
   * getter method for paralyzed
   * @return returns boolean value of status effect
   */
  public boolean isParalyzed() {
    return this.paralyzed;
  }
  
  /**
   * isBurned
   * getter method for burned
   * @return returns boolean value of status effect
   */
  public boolean isBurned() {
    return this.burned;
  }
  
  /**
   * getStatStages
   * getter method for the stat stages array
   * @return returns an array of the stat stages of pokemon
   */
  public int[] getStatStages() {
    return this.statStages;
  }
  
  /**
   * getType1
   * gets the first type of a pokemon
   * @return type of type1
   */
  public Type getType1() {
    return this.TYPE1;
  }
  
  /**
   * getType2
   * gets the second type of a pokemon
   * @return type of type2
   */
  public Type getType2() {
    return this.TYPE2;
  }
  
  /**
   * getHealth
   * getter method for the health of pokemon
   * @return returns the health of pokemon
   */
  public int getHealth() {
    return this.health;
  }
  
  /**
   * getMaxHealth
   * getter method for the max health of pokemon
   * @return returns the max health of a pokemon
   */
  public int getMaxHealth() {
    return this.MAX_HEALTH;
  }
  
    /**
   * getAttack
   * getter method for the attack of pokemon
   * @return returns pokemon attack
   */
  public int getAttack() {
    return this.ATTACK;
  }
  
  /**
   * getDefense
   * getter method for the defense of pokemon
   * @return returns pokemon defense
   */
  public int getDefense() {
    return this.DEFENSE;
  }
  
  /**
   * getSpecAttack
   * getter method for the special attack of pokemon
   * @return returns pokemon special attack
   */
  public int getSpecAttack() {
    return this.SPEC_ATTACK;
  }
  
  /**
   * getSpecDefense
   * getter method for the special defense of pokemon
   * @return returns pokemon special defense
   */
  public int getSpecDefense() {
    return this.SPEC_DEFENSE;
  }
  
  /**
   * getSpeed
   * getter method for the speed of pokemon
   * @return returns pokemon speed
   */
  public int getSpeed() {
    return this.SPEED;
  }
  
  /**
   * changehealth
   * changes the health of pokemon
   * @param int value for the change of pokemon's health
   */
  public void changeHealth(int value) {
    this.health += value;
  }
  
  /**
   * getStatModifier
   * gets the actual effect of the pokemon's stat modifiers
   * @param String for the stat you want to get
   * @return returns 1 if nothing happens and returns the stat modifier effect value
   */
  public double getStatModifier(String stat) {
    switch(stat) {
      case "attack":
        if (this.statStages[0] > 0) {
          return (this.statStages[0]+2)/2;
        } else {
          return 2/(Math.abs(this.statStages[0])+2);
        }
      case "defense":
        if (this.statStages[1] > 0) {
          return (this.statStages[1]+2)/2;
        } else {
          return 2/(Math.abs(this.statStages[1])+2);
        }
      case "special attack":
        if (this.statStages[2] > 0) {
          return (this.statStages[2]+2)/2;
        } else {
          return 2/(Math.abs(this.statStages[2])+2);
        }
      case "special defense":
        if (this.statStages[3] > 0) {
          return (this.statStages[3]+2)/2;
        } else {
          return 2/(Math.abs(this.statStages[3])+2);
        }
      case "speed":
        if (this.statStages[4] > 0) {
          return (this.statStages[4]+2)/2;
        } else {
          return 2/(Math.abs(this.statStages[4])+2);
        }
    }
    return 1;
  }
  
  /**
   * ranomizeMoves
   * method that randomizes the moves of the pokemon
   */
  public void randomizeMoves() {
    ArrayList<move> randomizedMoveSet = new ArrayList<move>(Arrays.asList(this.MOVESET));
    for (int i=0; i<4; i++) {
      int randomMove = (int)(Math.random()*randomizedMoveSet.size());
      this.moves[i] = randomizedMoveSet.get(randomMove);
      randomizedMoveSet.remove(randomMove);
    }
  }
  
  /**
   * setMove
   * method that changes move based on string
   * @param select the move slot you want to change
   * @param move the string value of the move
   */
  public void setMove(int select, String move) {
    for (move i: this.MOVESET) {
      if (i.getClass().getName().toLowerCase().equals(move.toLowerCase())) {
        this.moves[select] = i;
      }
    }
  }
  
  /**
   * setMoveFromIndex
   * method that changes move based on the index of the moveset of the pokemon
   * @param select the move slot you want to change
   * @param the index of the moveset that you selected
   */
  public void setMoveFromIndex(int select, int index) {
    this.moves[select] = this.MOVESET[index];
  }
  
  /**
   * getMoves
   * getter method to get the move of a pokemon
   * @param select the move that was selected to get
   * @return returns move and returns null if nothing happened
   */
  public move getMoves(int select) {
    switch (select) {
      case 1:
        return moves[0];
      case 2:
        return moves[1];
      case 3:
        return moves[2];
      case 4:
        return moves[3];
    }
    return null;
  }
  
  /**
   * getMoveSet
   * getter method for moveset
   * @return moveset of pokemon
   */
  public move[] getMoveSet() {
    return this.MOVESET;
  }
  
  /**
   * getFrontSprite
   * getter method for the front sprite of pokemon
   * @return  pokemon front sprite
   */
  public BufferedImage getFrontSprite() {
    return this.FRONT_SPRITE;
  }
  
  /**
   * getBackSprite
   * getter method for the back sprite of pokemon
   * @return the backsprite of pokemon
   */
  public BufferedImage getBackSprite() {
    return this.BACK_SPRITE;
  }
  
  /**
   * isFainted
   * checks if the pokemon is fainted
   * @return boolean value of fainted
   */
  public boolean isFainted() {
    if (this.health <= 0) {
      this.fainted = true;
    }
    return this.fainted;
  }
}