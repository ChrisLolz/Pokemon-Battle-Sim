/** 
 * Inferno.Java
 * Pokemon move for Inferno
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

public class Inferno extends damageMove implements hasSecondaryEffect{
  Inferno() {
    super("Inferno", "The user attacks by engulfing the target in an intense fire. This leaves the target with a burn.", 100, 0.50, 5, 0, Type.FIRE, moveCategory.SPECIAL);
  }
  
  public status[] useEffect(Pokemon user, Pokemon target) {
    if (Math.random() <= 1) {
      if ( (target.hasStatusCondition() == false) && (target.getType1() != Type.FIRE) && (target.getType2() != Type.FIRE) ) {
        status[] effects = {status.BURN};
        target.burnPokemon();
        return effects;
      } else {
        return null;
      }
    }
    return null;
  }
}
