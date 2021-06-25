/** 
 * statusMove.Java
 * abstract class for moves that don't do damage
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

public abstract class statusMove extends move{
  status[] effects;
  boolean selfBuff;
  statusMove(String NAME, String DESCRIPTION, double ACCURACY, int PP, int PRIORITY, Type TYPE, status[] effects, boolean selfBuff) {
    super(NAME, DESCRIPTION, ACCURACY, PP, PRIORITY, TYPE);
    this.effects = effects;
    this.selfBuff = selfBuff;
  }
  
  public boolean moveIsBuff() {
    return this.selfBuff;
  }
  
  public status[] useEffect(Pokemon target) {
      int rose, sharply;
      if (this.selfBuff == false) {
        rose = -1;
        sharply = -2;
      } else {
        rose = 1;
        sharply = 2;
      }
      for (int i = 0; i<effects.length; i++) {
        if (effects[i] == status.ATTACK_ROSE) {
          if (target.changeStatStage(0,rose) == false) {
            effects[i] = status.ATTACK_CANT_CHANGE;
          }
        } else if (effects[i] == status.ATTACK_SHARPLY) {
          if (target.changeStatStage(0,sharply) == false) {
            effects[i] = status.ATTACK_CANT_CHANGE;
          }
        } else if (effects[i] == status.DEFENSE_ROSE) {
          if (target.changeStatStage(1,rose) == false) {
            effects[i] = status.DEFENSE_CANT_CHANGE;
          }
        } else if (effects[i] == status.DEFENSE_SHARPLY) {
          if (target.changeStatStage(1,sharply) == false) {
            effects[i] = status.DEFENSE_CANT_CHANGE;
          }
        } else if (effects[i] == status.SPECIAL_ATTACK_ROSE) { 
          if (target.changeStatStage(2,rose) == false) {
            effects[i] = status.SPECIAL_ATTACK_CANT_CHANGE;
          }
        } else if (effects[i] == status.SPECIAL_ATTACK_SHARPLY) {
          if (target.changeStatStage(2,sharply) == false) {
            effects[i] = status.SPECIAL_ATTACK_CANT_CHANGE;
          }
        } else if (effects[i] == status.SPECIAL_DEFENSE_ROSE) { 
          if (target.changeStatStage(3,rose) == false) {
            effects[i] = status.SPECIAL_DEFENSE_CANT_CHANGE;
          }
        } else if (effects[i] == status.SPECIAL_DEFENSE_SHARPLY) {
          if (target.changeStatStage(3,sharply) == false) {
            effects[i] = status.SPECIAL_DEFENSE_CANT_CHANGE;
          }
        } else if (effects[i] == status.SPEED_ROSE) {
          if (target.changeStatStage(4,rose) == false) {
            effects[i] = status.SPEED_CANT_CHANGE;
          }
        } else if (effects[i] == status.SPEED_SHARPLY) {
          if (target.changeStatStage(4, sharply) == false) {
            effects[i] = status.SPEED_CANT_CHANGE;
          }
        } else if (effects[i] == status.POISONED) {
          if ( (target.getType1() == Type.POISON) || (target.getType2() == Type.POISON)) {
            effects[i] = status.FAILED;
          } else if (target.hasStatusCondition() == true) {
            effects[i] = status.ALREADY_HAS_STATUS_CONDITION;
          } else {
            target.poisonPokemon();
          }
        } else if (effects[i] == status.PARALYZED) {
          if ( (target.getType1() == Type.ELECTRIC) || (target.getType2() == Type.ELECTRIC)  ) {
            effects[i] = status.FAILED;
          } else if (target.hasStatusCondition() == true) {
            effects[i] = status.ALREADY_HAS_STATUS_CONDITION;
          } else {
            target.paralyzePokemon();
          }
        }
      }
      return effects;
  }
}