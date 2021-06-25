/** 
 * airSlash.Java
 * Pokemon move for air slash
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

public class airSlash extends damageMove implements hasSecondaryEffect{
  airSlash() {
    super("Air Slash", "The user attacks with a blade of air that slices even the sky. This may also make the target flinch.", 75, 0.95, 15, 0, Type.FLYING, moveCategory.SPECIAL);
  }
  
  public status[] useEffect(Pokemon user, Pokemon target) {
    status[] effects = {status.FLINCH};
    if (Math.random() <= 0.30) {
      return effects;
    } else {
      return null;
    }
  }
}
