/** 
 * move.Java
 * Abstract class used to make moves in the game
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

public abstract class move{
  private final String NAME,DESCRIPTION;
  private final int PRIORITY;
  private int powerPoints,MAX_PP;
  private final Type TYPE;
  private final double ACCURACY;
  
  
  public move(String NAME, String DESCRIPTION, double ACCURACY, int PP, int PRIORITY, Type TYPE) {
    this.NAME = NAME;
    this.DESCRIPTION = DESCRIPTION;
    this.MAX_PP = PP;
    this.TYPE = TYPE;
    this.ACCURACY = ACCURACY;
    this.PRIORITY = PRIORITY;
    this.powerPoints = this.MAX_PP;
  }
  
  public String getName() {
    return this.NAME;
  }
  
  public String getDescription() {
    return this.DESCRIPTION;
  }
  
  public int getPriority() {
    return this.PRIORITY;
  }
  
  public int getPP() {
    return this.powerPoints;
  }
  
  public int getMaxPP() {
    return this.MAX_PP;
  }
  
  public void resetPP() {
    this.powerPoints = this.MAX_PP;
  }
  
  public Type getType() {
    return this.TYPE;
  }
  
  public void usePP() {
    if (this.powerPoints>0) {
      this.powerPoints-=1;
    }
  }
  
  public double getAccuracy() {
    return this.ACCURACY;
  }
}