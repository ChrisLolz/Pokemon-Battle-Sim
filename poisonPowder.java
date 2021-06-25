/** 
 * poisonPowder.Java
 * Pokemon move for Growl
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

public class poisonPowder extends statusMove {
  poisonPowder() {
    super("Poison Powder", "The user scatters a cloud of poisonous dust that poisons the target.", 0.75, 35, 0, Type.POISON, new status[]{status.POISONED}, false);
  }
}
