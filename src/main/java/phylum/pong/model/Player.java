package phylum.pong.model;

import java.util.Random;

public class Player {
  private Paddle paddle;
  private int score = 0;
  private String playerName;
  private int playerType;
  private Random r;
  
  public Player(String name, Paddle paddle, int playerType) {
    this.paddle = paddle;
    this.playerType = playerType;
    this.playerName = name;
    this.r = new Random();
  }
  
  public int getType() {
    return this.playerType;
  }
  
  public void incrementScore() {
    this.score++;
  }
  
  public void resetScore() {
    this.score = 0;
  }
  
  public String getScore() {
    return Integer.toString(this.score);
  }
  
  public String getPlayerName() {
    return this.playerName;
  }
  
  public void move() {
    this.paddle.move();
  }
  
  public Paddle getPaddle() {
    return this.paddle;
  }
  
  public void checkForCollision(PongBall ball) {
    double var;
	
    if(ball.getXPosition() <= this.paddle.getXPosition() + (this.paddle.getPaddleWidth() / 2)
      && ball.getXPosition() > this.paddle.getXPosition() - (this.paddle.getPaddleWidth() / 2)
      && ball.getYPosition() <= this.paddle.getYPosition() + (this.paddle.getPaddleLength() / 2)
      && ball.getYPosition() >= this.paddle.getYPosition() - (this.paddle.getPaddleLength() / 2)
      || ball.getXPosition() >= this.paddle.getXPosition() - (this.paddle.getPaddleWidth() / 2)
      && ball.getXPosition() < this.paddle.getXPosition() + (this.paddle.getPaddleWidth() / 2)
      && ball.getYPosition() <= this.paddle.getYPosition() + (this.paddle.getPaddleLength() / 2)
      && ball.getYPosition() >= this.paddle.getYPosition() - (this.paddle.getPaddleLength() / 2)) {
      var = this.r.nextDouble() * 2;
      switch((int)var) {
        case 0: ball.setXVelocity(-1 * ball.getXVelocity());
          break;
        case 1: if(Math.abs(ball.getXVelocity()) <= 1) {
                  ball.setXVelocity(-1 * ball.getXVelocity() * 2);
                }
                else {
                  ball.setXVelocity(-1 * ball.getXVelocity());
                }
          break;
        default:
      }
      
      var = this.r.nextDouble() * 5;
      switch((int)var) {
        case 0: ball.setYVelocity(0);
          break;
        case 1: ball.setYVelocity(1);
          break;
        case 2: ball.setYVelocity(2);
          break;
        case 4: ball.setYVelocity(-1);
          break;
        case 5: ball.setYVelocity(-2);
          break;
        default:
      }
    }
  }
}