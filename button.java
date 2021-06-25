/** 
 * Button.Java
 * Class used to add buttons to the game
 * @author Christopher Lo
 * @version 1.0
 * June 2021
 */

import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;

public class button extends textLabel{
  private int width,height;
  private Color color;
  private Color outline = null;
  
  //default constructor 
  public button(int x, int y, int width, int height, Font font, String text) {
    super(x,y,font,text);
    this.width = width;
    this.height = height;
    this.color = new Color(0, 0, 0);
  }
  
  //constructor that allows you to create button with color
  public button(int x, int y, int width, int height, Font font, String text, Color color) {
    super(x,y,font,text);
    this.width = width;
    this.height = height;
    this.color = color;
  }
  
  //constructor that allows you to creat button with color and an outline
  public button(int x, int y, int width, int height, Font font, String text, Color color, Color outline) {
    super(x,y,font,text);
    this.width = width;
    this.height = height;
    this.color = color;
    this.outline = outline;
  }
  
  public int getWidth() {
    return this.width;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public void changeButtonColor(Color color) {
    this.color = color;
  }
  
  public void draw(Graphics g) {
    if (this.outline != null) {
      g.setColor(outline);
      g.fillRect(getX()-(this.width+10)/2, getY()-(this.height+10)/2, this.width+10, this.height+10);
    }
    g.setFont(getFont());
    g.setColor(color);
    g.fillRect(getX()-this.width/2, getY()-this.height/2, this.width, this.height);
    g.setColor(new Color(255,255,255));
    g.drawString(getText(), getX()-g.getFontMetrics().stringWidth(getText())/2, getY()+(g.getFontMetrics().getAscent()-g.getFontMetrics().getDescent())/2);
  }
  
  public boolean inButton(int x, int y) {
    Rectangle rectangle = new Rectangle(getX()-this.width/2,getY()-this.height/2, this.width, this.height);
    return rectangle.contains(x,y);
  }
}