/** 
 * Growl.Java
 * Pokemon move for Growl
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

public class Growl extends statusMove {
  Growl() {
    super("Growl", "The user growls in an endearing way, making opposing Pokémon less wary. This lowers their Attack stats.", 0.95, 15, 0, Type.NORMAL, new status[]{status.ATTACK_ROSE}, false);
  }
}
