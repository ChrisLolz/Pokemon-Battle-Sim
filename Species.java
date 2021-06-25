/** 
 * Species.Java
 * Enum used as a database to create different pokemon species
 * @author Christopher Lo
 * @version 1.0
 * June  2021
 */

public enum Species {
  CHARMANDER("CHARMANDER",188, 109, 91, 125, 105, 135, Type.FIRE, null),
  CHARMELEON("CHARMELEON",226, 133, 121, 165, 135, 165, Type.FIRE, null),
  CHARIZARD("CHARIZARD",266, 173, 161, 223, 175, 205, Type.FIRE, Type.FLYING),
  BULBASAUR("BULBASAUR",200, 103, 103, 135, 135, 95, Type.GRASS, Type.POISON),
  IVYSAUR("IVYSAUR",230, 129, 131, 165, 165, 125, Type.GRASS, Type.POISON),
  VENUSAUR("VENUSAUR",270, 169, 171, 205, 205, 165, Type.GRASS, Type.POISON),
  SQUIRTLE("SQUIRTLE",198,101,135,105,133,91, Type.WATER, null),
  WARTORTLE("WARTORTLE",228, 131, 165, 135, 165, 121, Type.WATER, null),
  BLASTOISE("BLASTOISE",268, 171, 205, 175, 215, 161, Type.WATER, null);
  
  final public String NAME;
  final public int HEALTH, ATTACK, DEFENSE, SPEC_ATTACK, SPEC_DEFENSE, SPEED;
  final public Type TYPE1, TYPE2;
  
  Species(final String NAME, final int HEALTH, final int ATTACK, final int DEFENSE, final int SPEC_ATTACK, final int SPEC_DEFENSE, final int SPEED, final Type TYPE1, final Type TYPE2) {
    this.NAME = NAME;
    this.HEALTH = HEALTH;
    this.ATTACK = ATTACK;
    this.DEFENSE = DEFENSE;
    this.SPEC_ATTACK = SPEC_ATTACK;
    this.SPEC_DEFENSE = SPEC_DEFENSE;
    this.SPEED = SPEED;
    this.TYPE1 = TYPE1;
    this.TYPE2 = TYPE2;
  }
  
  public static Species randomSpecies() {
    return Species.values()[(int)(Math.random()*Species.values().length)];
  }
  
  public move[] getMoveSet(Species pokemon) {
    move[] moveSet = null;
    switch (pokemon) {
      case CHARMANDER:
        moveSet = new move[] {new Tackle(), new Tackle(), new Tackle(), new Tackle()};
        break;
      case CHARMELEON:
        moveSet = new move[] {new Tackle(), new Tackle(), new Tackle(), new Tackle()};
        break;
      case CHARIZARD:
        moveSet = new move[] {new Inferno(), new airSlash(), new thunderPunch(), new dragonClaw(), new Tackle()};
        break;
      case BULBASAUR:
        moveSet = new move[] {new Tackle(), new Tackle(), new Tackle(), new Tackle()};
        break;
      case IVYSAUR:
        moveSet = new move[] {new Tackle(), new Tackle(), new Tackle(), new Tackle()};
        break;
      case VENUSAUR:
        moveSet = new move[] {new poisonPowder(), new Tackle(), new Tackle(), new Tackle()};
        break;
      case SQUIRTLE:
        moveSet = new move[] {new Tackle(), new Tackle(), new Tackle(), new Tackle()};
        break;
      case WARTORTLE:
        moveSet = new move[] {new Tackle(), new Tackle(), new Tackle(), new Tackle()};
        break;
      case BLASTOISE:
        moveSet = new move[] {new icePunch(), new icePunch(), new icePunch(), new icePunch()};
        break;
    }
    return moveSet;
  }
}