/** 
 * textLabel.Java
 * Class used to add text labels to the game
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class textLabel {
  private int x,y;
  private String text;
  private String text2;
  private Font font;
  private boolean centerPoint = false;
  
  public textLabel(int x, int y, Font font, String text) {
    this.x = x;
    this.y = y;
    this.font = font;
    this.text = text;
    this.text2 = null;
  }
  
  public textLabel(int x, int y, Font font, String text, boolean centerPoint) {
    this.x = x;
    this.y = y;
    this.font = font;
    this.text = text;
    this.text2 = null;
    this.centerPoint = centerPoint;
  }
  
  public textLabel(int x, int y, Font font, String text, String text2) {
    this.x = x;
    this.y = y;
    this.font = font;
    this.text = text;
    this.text2 = text2;
  }
  
  public int getX() {
    return this.x;
  }
  
  public int getY() {
    return this.y;
  }
  
  public String getText() {
    return this.text;
  }
  
  public Font getFont() {
    return this.font;
  }
  
  public void changeText(String text) {
    this.text = text;
  }
  
  public void draw(Graphics g) {
    g.setColor(new Color(0,0,0));
    g.setFont(this.font);
    if (this.centerPoint == false) {
      g.drawString(this.text, this.x, this.y);
    } else {
      g.drawString(getText(), getX()-g.getFontMetrics().stringWidth(getText())/2, getY()+(g.getFontMetrics().getAscent()-g.getFontMetrics().getDescent())/2);
    }
    if (this.text2 != null) {
      g.drawString(this.text2, this.x, (int)(this.y+g.getFontMetrics().getAscent()*1.5));
    }
  }
}