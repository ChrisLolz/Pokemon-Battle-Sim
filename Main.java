/** 
 * Main.Java
 * Main method of game and loads the jframes
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

import java.util.Scanner;

public class Main {
  static Player player;
  
  public static void main(String[] args) throws Exception{
    startMenuFrame startMenu = new startMenuFrame();
    
    //start menu
    while(startMenu.getPanel().getListener().hasStarted() == false) {
      startMenu.update();
      try {Thread.sleep(10);}
      catch (Exception exc) {
        System.out.println("Thread Error");
      }
    }
    startMenu.dispose();
    
  
    player = new Player();
    
    mainMenuFrame mainMenu = new mainMenuFrame();
    
    //main menu
    while(true) {
      mainMenu.update();
      try {Thread.sleep(10);}
      catch (Exception exc) {
        System.out.println("Thread Error");
      }
    }
  }
}