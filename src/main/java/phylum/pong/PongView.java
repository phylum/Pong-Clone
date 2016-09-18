package phylum.pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.JPanel;

import phylum.pong.model.Court;
import phylum.pong.util.Constants;
import phylum.pong.view.CourtView;
import phylum.pong.view.GameoverView;
import phylum.pong.view.TitlescreenView;

public class PongView extends JPanel implements Constants, Runnable {
  private CourtView courtView;
  private TitlescreenView titlescreenView;
  private GameoverView gameoverView;
  private Thread animator;
  private boolean gameover = false;
  private boolean inPlay = true;
  private boolean title = true;
  
  public PongView() {
    super();
    
    addKeyListener(new MainKeyAdapter());
    this.titlescreenView = new TitlescreenView();
    
    setBackground(Color.BLACK);
    setFocusable(true);
  }
  
  @Override
  public void addNotify() {
    super.addNotify();

    animator = new Thread(this);
    animator.start();
  }
  
  private class MainKeyAdapter extends KeyAdapter {
    @Override
    public void keyReleased(KeyEvent e) {
      if(!title && inPlay) {  
        courtView.handleKeyReleasedEvent(e);
      }
    }

    @Override
    public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
      if(title) {  
        titlescreenView.keyPressed(e);
      }
      else if(inPlay) {
        courtView.handleKeyPressedEvent(e);
      }
      else if(gameover) {
        gameoverView.keyPressed(e);
      }
    }
  }
  
  private void updateModel() {
    if(this.title) {
      int choice = -1;
      if((choice = this.titlescreenView.getChoice()) != -1) {
        this.courtView = new CourtView(new Court(Constants.COURT_WIDTH, Constants.COURT_HEIGHT, choice));
        this.title = false;
      }
    }
    else if(this.inPlay) {
      this.courtView.updateCourt();
      String winner;
      if((this.courtView.getWinner()) != null) {
        this.inPlay = false;
        this.gameover = true;
        this.gameoverView = new GameoverView(this.courtView.getWinner().getPlayerName());
        this.courtView = null;
      }
    }
    else if(this.gameover) {
      if(this.gameoverView.isEnterPressed()) {
        this.title = true;
        this.titlescreenView.resetChoice();
        this.inPlay = true;
        this.gameover = false;
        this.gameoverView = null;
      }
    }
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    Graphics2D g2d = (Graphics2D)g;
    
    if(this.title) {
      this.titlescreenView.paint(g2d);
    }
    else if(this.inPlay) {
      this.courtView.paint(g2d);
    }
    else if(this.gameover) {
      this.gameoverView.paint(g2d);
    }
  }
  
  public void run() {
    long timeDifference, sleep;
    long currentTime = System.currentTimeMillis();
    
    while(true) {
      this.updateModel();
      this.repaint();
      
      timeDifference = System.currentTimeMillis() - currentTime;
      sleep = Constants.DELAY - timeDifference;

      try {
          Thread.sleep((sleep < 0) ? 2 : sleep);
      } catch (InterruptedException e) {
          System.out.println("Interrupted: " + e.getMessage());
      }

      currentTime = System.currentTimeMillis();
    }
  }
}