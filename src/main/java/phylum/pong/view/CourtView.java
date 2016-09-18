package phylum.pong.view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JPanel;

import phylum.pong.model.Court;
import phylum.pong.model.CourtWall;
import phylum.pong.model.CpuPlayer;
import phylum.pong.model.Player;
import phylum.pong.model.PongBall;
import phylum.pong.model.Sprite;

public class CourtView extends JPanel {
  private Court court;
  private PaddleView paddleView;
  private PongBallView pongBallView;
  private CourtWallView[] courtWallViews;
  private PlayerView[] playerViews;
  private Thread animator;
  
  public CourtView(Court court) {
    super();
    this.court = court;
    
    Sprite[] sprites = sprites = court.getSprites();
    this.pongBallView = new PongBallView((PongBall)sprites[0]);
    this.courtWallViews = new CourtWallView[] { new CourtWallView((CourtWall)sprites[1]), new CourtWallView((CourtWall)sprites[2]) };
    
    Player[] players = court.getPlayers();
    this.playerViews = new PlayerView[] { new PlayerView((Player)players[0]), new PlayerView((Player)players[1]) };
    
    setBackground(Color.BLACK);
    setFocusable(true);
  }
  
  public void handleKeyPressedEvent(KeyEvent e) {
    playerViews[0].handleKeyPressedEvent(e);
    if(court.getPlayers()[1].getType() == 2) {
      playerViews[1].handleKeyPressedEvent(e);
    }
  }
  
  public void handleKeyReleasedEvent(KeyEvent e) {
    playerViews[0].handleKeyReleasedEvent(e);
    if(court.getPlayers()[1].getType() == 2) {
      playerViews[1].handleKeyReleasedEvent(e);
    }
  }
  
  public void resetGame() {
    this.court.resetGame();
  }
  
  public void updateCourt() {
    this.court.getPlayers()[0].move();
    if(this.court.getPlayers()[1].getType() == 3) {
      ((CpuPlayer)this.court.getPlayers()[1]).move();
    }
    else {
      this.court.getPlayers()[1].move();
    }
    this.court.getPongBall().move();
    this.court.checkForGoal();
    this.court.checkForCollision();
  }
  
  public Player getWinner() {
    return this.court.getWinner();
  }
  
  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.WHITE);
    Graphics2D g2d = (Graphics2D)g;
    
    for(PlayerView p : this.playerViews) {
      p.paint(g2d);
      p.setVisible(true);
    }
    this.pongBallView.paint(g2d);
    this.pongBallView.setVisible(true);
    this.courtWallViews[0].paint(g2d);
    this.courtWallViews[0].setVisible(true);
    this.courtWallViews[1].paint(g2d);
    this.courtWallViews[1].setVisible(true);
      
    Toolkit.getDefaultToolkit().sync();
    g.dispose();
  }
}