package phylum.pong.view;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.awt.Color;

import phylum.pong.util.Constants;

public class TitlescreenView extends JPanel implements Constants, KeyListener {
  private String title = "Pong Clone";
  private String[] choices = { "One Player", "Two Player" };
  private int choice = -1;
  private int selected = 0;
  
  public TitlescreenView() {
    super();
  }
  
  public void resetChoice() {
    this.choice = -1;
  }
  
  public int getChoice() {
    return this.choice;
  }
  
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    
    switch(key) {
      case KeyEvent.VK_ENTER:  this.choice = this.selected;
        break;
      case KeyEvent.VK_W:
      case KeyEvent.VK_UP:  
        if(this.selected == 0) {
          this.selected = 1;
        }
        else {
          this.selected--;
        }
        break;
      case KeyEvent.VK_S:
      case KeyEvent.VK_DOWN:
        if(this.selected == 1) {
          this.selected = 0;
        }
        else {
          this.selected++;
        }
        break;
      default:
        break;
    }
  }
  
  public void keyReleased(KeyEvent e) {}
  
  public void keyTyped(KeyEvent e) {}

  public void paint(Graphics g) {
    super.paint(g);
    
    g.setColor(Color.WHITE);
    Font titleFont = new Font("Helvetica", Font.BOLD, 26);
    g.setFont(titleFont);
    g.drawString(this.title, Constants.COURT_WIDTH / 2, Constants.COURT_HEIGHT / 2);
    
    int height = Constants.COURT_HEIGHT / 2 + 24;
    Font choiceFont = new Font("Helvetica", Font.BOLD, 18);
    g.setFont(choiceFont);
    for(String c : this.choices) {
      if(choices[selected] == c) {
        g.setColor(Color.YELLOW);
      }
      else {
        g.setColor(Color.WHITE);
      }
      g.drawString(c, Constants.COURT_WIDTH / 2, height);
      height += 15;
    }
  }
}