/** 
 * damageMove.Java
 * abstract class for moves that does damage
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

public abstract class damageMove extends move{
  enum moveCategory{SPECIAL,PHYSICAL};
  private final int POWER;
  private final moveCategory CATEGORY;
  
  damageMove(String NAME, String DESCRIPTION, int POWER, double ACCURACY, int PP, int PRIORITY, Type TYPE, moveCategory MOVECATEGORY) {
    super(NAME, DESCRIPTION, ACCURACY, PP, PRIORITY, TYPE);
    this.POWER = POWER;
    this.CATEGORY = MOVECATEGORY;
  }
  
  public int getPower() {
    return this.POWER;
  }
  
  public moveCategory getCategory() {
    return this.CATEGORY;
  }
  
  public Effectiveness checkEffectiveness(Pokemon target) {
    for(Type types: target.getType1().WEAKNESSES) {
      if (types == getType()) {
        return Effectiveness.SUPER;
      }
    }
    for (Type types: target.getType1().RESISTANCES) {
      if (types == getType()) {
        return Effectiveness.NOT;
      }
    }
    for (Type types: target.getType1().NOEFFECT) {
      if (types == getType()) {
        return Effectiveness.NONE;
      }
    }
    if (target.getType2() != null) {
      for(Type types: target.getType2().WEAKNESSES) {
        if (types == getType()) {
          return Effectiveness.SUPER;
        }
      }
      for (Type types: target.getType2().RESISTANCES) {
        if (types == getType()) {
          return Effectiveness.NOT;
        }
      }
      for (Type types: target.getType2().NOEFFECT) {
        if (types == getType()) {
          return Effectiveness.NONE;
        }
      }
    }
    return null;
  }
  
  //calculates the attack damage for pokemon
  public void attack(Pokemon user, Pokemon target) {
    double stab = 1.0;
    double typeEffect = 1.0;
    double damage = 0;
    double burn = 1.0;
    double attackModifier = user.getStatModifier("attack");
    double defenseModifier = target.getStatModifier("defense");
    double specAttackModifier = user.getStatModifier("special attack");
    double specDefenseModifier = target.getStatModifier("special defense");
    double randomFactor = Math.random() * (1.0-0.85) + 0.85;
    if (user.isBurned() == true) {
      burn = 0.5;
    }
    if ( (user.getType1() == getType()) || (user.getType2() == getType()) ) {
      stab = 1.5;
    }
    for(Type types: target.getType1().WEAKNESSES) {
      if (types == getType()) {
        typeEffect*=2;
      }
    }
    for (Type types: target.getType1().RESISTANCES) {
      if (types == getType()) {
        typeEffect*=0.5;
      }
    }
    for (Type types: target.getType1().NOEFFECT) {
      if (types == getType()) {
        typeEffect = 0;
      }
    }
    if (target.getType2() != null) {
      for(Type types: target.getType2().WEAKNESSES) {
        if (types == getType()) {
          typeEffect*=2;
        }
      }
      for (Type types: target.getType2().RESISTANCES) {
        if (types == getType()) {
          typeEffect*=0.5;
        }
      }
      for (Type types: target.getType2().NOEFFECT) {
        if (types == getType()) {
          typeEffect = 0;
        }
      }
    }
    switch(CATEGORY) {
      case PHYSICAL:
        damage = ((((42.0)*this.POWER * (user.getAttack()*attackModifier)/(target.getDefense()*defenseModifier))/50.0)+2.0)*randomFactor*stab*typeEffect*burn;
        break;
      case SPECIAL:
        damage = ((((42.0)*this.POWER * (user.getSpecAttack()*specAttackModifier)/(target.getSpecDefense()*specDefenseModifier))/50.0)+2.0)*randomFactor*stab*typeEffect;
        break;
    }
    if (damage>target.getHealth()) {
      damage = target.getHealth();
    }
    target.changeHealth((int)-(damage));
  }
}