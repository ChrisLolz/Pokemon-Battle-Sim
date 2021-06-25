/** 
 * Type.Java
 * Enum used to determine the elemental type of a Pokemon
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

public enum Type {
  NORMAL,
  FIRE,
  FIGHT,
  WATER,
  FLYING,
  GRASS,
  POISON,
  ELECTRIC,
  GROUND,
  PSYCHIC,
  ROCK,
  ICE,
  BUG,
  DRAGON,
  GHOST,
  DARK,
  STEEL,
  FAIRY;
  
  public Type[] WEAKNESSES, RESISTANCES, NOEFFECT;
  
  static {
    NORMAL.WEAKNESSES = new Type[]{FIGHT};
    NORMAL.RESISTANCES = new Type[]{};
    NORMAL.NOEFFECT = new Type[]{GHOST};
    
    FIGHT.WEAKNESSES = new Type[]{FLYING, PSYCHIC, FAIRY};
    FIGHT.RESISTANCES = new Type[]{ROCK, BUG};
    FIGHT.NOEFFECT = new Type[]{};
    
    FLYING.WEAKNESSES = new Type[]{ROCK, ELECTRIC, ICE};
    FLYING.RESISTANCES = new Type[]{FIGHT, BUG, GRASS};
    FLYING.NOEFFECT = new Type[]{};
    
    POISON.WEAKNESSES = new Type[]{GROUND, PSYCHIC};
    POISON.RESISTANCES = new Type[]{FIGHT, POISON, BUG, GRASS, FAIRY};
    POISON.NOEFFECT = new Type[]{};
    
    GROUND.WEAKNESSES = new Type[]{WATER, GRASS, ICE};
    GROUND.RESISTANCES = new Type[]{POISON, ROCK};
    GROUND.NOEFFECT = new Type[]{ELECTRIC};
    
    ROCK.WEAKNESSES = new Type[]{FIGHT, GROUND, STEEL, WATER, GRASS};
    ROCK.RESISTANCES = new Type[]{NORMAL, FLYING, POISON, FIRE};
    ROCK.NOEFFECT = new Type[]{};
    
    BUG.WEAKNESSES = new Type[]{FLYING, ROCK, FIRE};
    BUG.RESISTANCES = new Type[]{FIGHT, GROUND, GRASS};
    BUG.NOEFFECT = new Type[]{};
    
    GHOST.WEAKNESSES = new Type[]{GHOST, DARK};
    GHOST.RESISTANCES = new Type[]{POISON, BUG};
    GHOST.NOEFFECT = new Type[]{NORMAL, FIGHT};
    
    STEEL.WEAKNESSES = new Type[]{FIGHT, GROUND, FIRE};
    STEEL.RESISTANCES = new Type[]{NORMAL, FLYING, ROCK, BUG, STEEL, GRASS, PSYCHIC, ICE, DRAGON, FAIRY};
    STEEL.NOEFFECT = new Type[]{POISON};
    
    FIRE.WEAKNESSES = new Type[]{GROUND, ROCK, WATER};
    FIRE.RESISTANCES = new Type[]{BUG, STEEL, FIRE, GRASS, ICE, FAIRY};
    FIRE.NOEFFECT = new Type[]{};
    
    WATER.WEAKNESSES = new Type[]{GRASS, ELECTRIC};
    WATER.RESISTANCES = new Type[]{STEEL, FIRE, FIRE, WATER, ICE};
    WATER.NOEFFECT = new Type[]{};
    
    GRASS.WEAKNESSES = new Type[]{FLYING, POISON, BUG, FIRE, ICE};
    GRASS.RESISTANCES = new Type[]{GROUND, WATER, GRASS, ELECTRIC};
    GRASS.NOEFFECT = new Type[]{};
    
    ELECTRIC.WEAKNESSES = new Type[]{GROUND};
    ELECTRIC.RESISTANCES = new Type[]{FLYING,STEEL,ELECTRIC};
    ELECTRIC.NOEFFECT = new Type[]{};
    
    PSYCHIC.WEAKNESSES = new Type[]{BUG, GHOST, DARK};
    PSYCHIC.RESISTANCES = new Type[]{FIGHT, PSYCHIC};
    PSYCHIC.NOEFFECT = new Type[]{};
    
    ICE.WEAKNESSES = new Type[]{FIGHT, ROCK, STEEL, FIRE};
    ICE.RESISTANCES = new Type[]{ICE};
    ICE.NOEFFECT = new Type[]{};
    
    DRAGON.WEAKNESSES = new Type[]{ICE, DRAGON, FAIRY};
    DRAGON.RESISTANCES = new Type[]{FIRE, WATER, GRASS, ELECTRIC};
    DRAGON.NOEFFECT = new Type[]{};
    
    DARK.WEAKNESSES = new Type[]{FIGHT, BUG, FAIRY};
    DARK.RESISTANCES = new Type[]{GHOST, DARK};
    DARK.NOEFFECT = new Type[]{PSYCHIC};
    
    FAIRY.WEAKNESSES = new Type[]{POISON, STEEL};
    FAIRY.RESISTANCES = new Type[]{FIGHT, BUG, DARK};
    FAIRY.NOEFFECT = new Type[]{DRAGON};
  }
}