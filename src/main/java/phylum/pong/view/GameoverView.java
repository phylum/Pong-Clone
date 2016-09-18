package phylum.pong.view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import phylum.pong.util.Constants;

public class GameoverView extends JPanel implements Constants, KeyListener {
  private String winnerName;
  private boolean enterPressed = false;
  
  public GameoverView(String winnerName) {
    super();
    this.winnerName = winnerName;
    
    while(this.winnerName.length() < 8) {
      this.winnerName = " " + this.winnerName;
    }
    
    if(this.winnerName == "CPU") {
      this.winnerName = "  " + this.winnerName;
    }
    
    this.winnerName = "    " + this.winnerName;
  }
  
  public boolean isEnterPressed() {
    return this.enterPressed;
  }
  
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    
    if(key == KeyEvent.VK_ENTER) {
      this.enterPressed = true;
    }
  }
  
  public void keyReleased(KeyEvent e) {}
  
  public void keyTyped(KeyEvent e) {}
  
  public void paint(Graphics g) {
    super.paint(g);
    
    g.setColor(Color.WHITE);
    Font gameoverFont = new Font("Helvetica", Font.BOLD, 20);
    g.setFont(gameoverFont);
    g.drawString(winnerName + " Wins!", Constants.COURT_WIDTH / 3, Constants.COURT_HEIGHT / 2);
    
    Font instructionFont = new Font("Helvetica", Font.BOLD, 16);
    g.setFont(instructionFont);
    g.drawString("Press Enter to Continue", Constants.COURT_WIDTH / 3 + 10, (Constants.COURT_HEIGHT / 2) + 24);
  }
}