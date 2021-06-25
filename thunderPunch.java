/** 
 * thunderPunch.Java
 * Pokemon move for thunder punch
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

public class thunderPunch extends damageMove implements hasSecondaryEffect{
  thunderPunch() {
    super("Thunder Punch", "The target is punched with an electrified fist. This may also leave the target with paralysis.", 75, 1, 15, 0, Type.ELECTRIC, moveCategory.PHYSICAL);
  }
  
  public status[] useEffect(Pokemon user, Pokemon target) {
    if (Math.random() <= 0.10) {
      if ( (target.hasStatusCondition() == false) && (target.getType1() != Type.ELECTRIC) && (target.getType2() != Type.ELECTRIC) ) {
        status[] effects = {status.PARALYZED};
        target.paralyzePokemon();
        return effects;
      } else {
        return null;
      }
    }
    return null;
  }
}
