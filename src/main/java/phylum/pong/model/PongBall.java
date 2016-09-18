package phylum.pong.model;

import phylum.pong.util.Constants;

public class PongBall extends Sprite implements Constants {
  
  public PongBall(int x, int y) {
    super(x, y);
    this.setXVelocity(1);
  }
  
  public void move() {
    this.setXPosition(this.getXPosition() + this.getXVelocity());
    this.setYPosition(this.getYPosition() + this.getYVelocity());
    
    if(this.getYPosition() <= Constants.COURT_TOP_WALL || this.getYPosition() >= Constants.COURT_BOTTOM_WALL) {
      int yValue = this.getYVelocity();
      yValue *= -1;
      this.setYVelocity(yValue);
    }
  }
}