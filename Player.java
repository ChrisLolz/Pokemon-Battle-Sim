/** 
 * Player.Java
 * class used to get information about the player
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class Player {
  private Pokemon[] team = new Pokemon[6];
  private int wins, losses;
  private File saveFile;
  private Scanner input;
  
  Player() throws Exception {
    this.saveFile = new File("saveFile.txt");
    this.input = new Scanner(saveFile);
    for (int i=0; i<6; i++) {
      this.team[i] = new Pokemon(Species.valueOf(input.next()));
      for (int j=0; j<4; j++) {
        this.team[i].setMove(j, input.next());
      }
    }
    this.wins = input.nextInt();
    this.losses = input.nextInt();
  }
  
  public int getWins() {
    return this.wins;
  }
  
  public int getLosses() {
    return this.losses;
  }
  
  public void winGame() {
    this.wins+=1;
  }
  
  public void loseGame() {
    this.losses+=1;
  }
  
  public boolean allFainted() {
    for (Pokemon i: this.team) {
      if (i.isFainted() == false) {
        return false;
      }
    }
    return true;
  }
  
  public void saveTeam() throws Exception{
    PrintWriter output = new PrintWriter(this.saveFile);
    for (int i=0; i<6; i++) {
      output.print(this.team[i].getName().toUpperCase());
      for (int j=0; j<4; j++) {
        output.print(" "+this.team[i].getMoves(j+1).getClass().getName());
      }
      output.println();
    }
    output.println(this.wins);
    output.println(this.losses);
    output.close();
  }
  
  public void resetTeam() {
    for (Pokemon i: this.team) {
      i.resetPokemon();
    }
  }
  
  public Pokemon getTeam(int select) {
    return this.team[select];
  }
  
  public void changePokemon(int select, Species species) {
    this.team[select] = new Pokemon(species);
    this.team[select].randomizeMoves();
  }
  
}