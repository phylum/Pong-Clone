package phylum.pong.view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import phylum.pong.controller.LocalPlayerController;
import phylum.pong.model.Player;
import phylum.pong.model.CpuPlayer;
import phylum.pong.util.Constants;

public class PlayerView extends JPanel implements Constants {
  private Player player;
  private PaddleView paddleView;
  private LocalPlayerController lpc;
  
  public PlayerView(Player player) {
    this.player = player;
    
    this.paddleView = new PaddleView(this.player.getPaddle());
    if(this.player.getType() == 1 || this.player.getType() == 2) {
      addKeyListener(this.lpc = new LocalPlayerController(this.player));
    }
  }
  
  public void move() {
    if(this.player.getType() == 3) {
      ((CpuPlayer)this.player).getPaddle().move();
    }
    else {
      this.player.getPaddle().move();
    }
  }
  
  public void handleKeyPressedEvent(KeyEvent e) {
    this.lpc.keyPressed(e);
  }
  
  public void handleKeyReleasedEvent(KeyEvent e) {
    this.lpc.keyReleased(e);
  }
  
  public void paint(Graphics g) {
    super.paint(g);
    
    String scoreString = this.player.getScore();
    Font font = new Font("Helvetica", Font.BOLD, Constants.PLAYERS_SCORE_FONT_VALUE);  
    g.setFont(font);
    Color color = new Color(255, 255, 255, 192);
    g.setColor(color);
    
    if(this.player.getType() == 1) {
      g.drawString(scoreString, Constants.PLAYER_ONE_SCORE_X_VALUE, Constants.PLAYERS_SCORE_Y_VALUE);
    }
    else {
      g.drawString(scoreString, Constants.PLAYER_TWO_SCORE_X_VALUE, Constants.PLAYERS_SCORE_Y_VALUE);
    }
    
    g.setColor(Color.WHITE);
    this.paddleView.paint(g);
  }
}