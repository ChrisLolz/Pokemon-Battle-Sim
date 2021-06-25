/** 
 * hasSecondaryEffect.Java
 * Interface for damage moves that have a secondary effect such as flinch
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

public interface hasSecondaryEffect {
  public status[] useEffect(Pokemon user, Pokemon target);
}