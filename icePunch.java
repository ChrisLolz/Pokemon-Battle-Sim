/** 
 * icePunch.Java
 * Pokemon move for ice punch
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

public class icePunch extends damageMove implements hasSecondaryEffect{
  icePunch() {
    super("Ice Punch", "The target is punched with an icy fist. This may also leave the target frozen.", 75, 1, 15, 0, Type.ICE, moveCategory.PHYSICAL);
  }
  
  public status[] useEffect(Pokemon user, Pokemon target) {
    if (Math.random() <= 0.10) {
      if ( (target.hasStatusCondition() == false) && (target.getType1() != Type.ICE) && (target.getType2() != Type.ICE) ) {
        status[] effects = {status.FROZEN};
        target.freezePokemon();
        return effects;
      } else {
        return null;
      }
    }
    return null;
  }
}
