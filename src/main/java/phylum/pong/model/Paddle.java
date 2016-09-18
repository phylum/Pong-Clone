package phylum.pong.model;

import phylum.pong.util.Constants;

public class Paddle extends Sprite implements Constants {
  public Paddle(int x, int y) {
    super(x, y);
    setUp(true);
    setDown(true);
  }
  
  public int getPaddleLength() {
    return Constants.PADDLE_LENGTH;
  }
  
  public int getPaddleWidth() {
    return Constants.PADDLE_WIDTH;
  }
    
  public int getCourtTopWall() {
    return Constants.COURT_TOP_WALL;
  }
  
  public int getCourtBottomWall() {
    return Constants.COURT_BOTTOM_WALL;
  }
  
  public void move() {
    int yValue = this.getYPosition();
    yValue += this.getYVelocity();
    this.setYPosition(yValue);
    
    if(this.getYPosition() + (Constants.PADDLE_LENGTH / 2) >= Constants.COURT_BOTTOM_WALL) {
      this.setYVelocity(0);
      this.setDown(false);
    }
    else if(this.getYPosition() - (Constants.PADDLE_LENGTH / 2) <= Constants.COURT_TOP_WALL) {
      this.setYVelocity(0);
      this.setUp(false);
    }
    else {
      this.setUp(true);
      this.setDown(true);
    }
  }
}