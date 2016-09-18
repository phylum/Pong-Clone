package phylum.pong.model;

public class CpuPlayer extends Player {
  private PongBall ball;
  
  public CpuPlayer(String name, Paddle paddle, PongBall ball, int playerType) {
    super(name, paddle, playerType);
    this.ball = ball;
  }
  
  public void move() {
      if(ball.getYPosition() < this.getPaddle().getYPosition() - this.getPaddle().getPaddleLength() / 2) {
        this.getPaddle().setYVelocity(-2);
        this.getPaddle().setDown(true);
      }
      else if(ball.getYPosition() > this.getPaddle().getYPosition() +   this.getPaddle().getPaddleLength() / 2) {
        this.getPaddle().setYVelocity(2);
        this.getPaddle().setUp(true);
      }
      else {
        this.getPaddle().setYVelocity(0);
      }
      this.getPaddle().move();
  }
}