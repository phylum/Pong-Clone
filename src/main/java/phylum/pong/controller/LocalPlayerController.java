package phylum.pong.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import phylum.pong.model.Player;

public class LocalPlayerController implements KeyListener {
  private Player player;
  
  public LocalPlayerController(Player player) {
    this.player = player;
  }
  
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    
    if(this.player.getType() == 1) {
      if(key == KeyEvent.VK_W && this.player.getPaddle().canGoUp()) {
        this.player.getPaddle().setYVelocity(-2);
        this.player.getPaddle().setDown(true);
      }
      else if(key == KeyEvent.VK_S && this.player.getPaddle().canGoDown()) {
        this.player.getPaddle().setYVelocity(2);
        this.player.getPaddle().setUp(true);
      }
    }
    else if(this.player.getType() == 2) {
      if(key == KeyEvent.VK_UP && this.player.getPaddle().canGoUp()) {
        this.player.getPaddle().setYVelocity(-2);
        this.player.getPaddle().setDown(true);
      }
      else if(key == KeyEvent.VK_DOWN && this.player.getPaddle().canGoDown()) {
        this.player.getPaddle().setYVelocity(2);
        this.player.getPaddle().setUp(true);
      }
    }
  }
  
  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    
    if(this.player.getType() == 1) {
      if(key == KeyEvent.VK_W) {
        this.player.getPaddle().setYVelocity(0);
      }
      else if(key == KeyEvent.VK_S) {
        this.player.getPaddle().setYVelocity(0);
      }
    }
    else if(this.player.getType() == 2) {
      if(key == KeyEvent.VK_UP) {
        this.player.getPaddle().setYVelocity(0);
      }
      else if(key == KeyEvent.VK_DOWN) {
        this.player.getPaddle().setYVelocity(0);
      }
    }
  }
  
  public void keyTyped(KeyEvent e) {}
}