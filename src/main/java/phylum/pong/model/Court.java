package phylum.pong.model;

import phylum.pong.util.Constants;

public class Court implements Constants {
  private double width;
  private double height;
  private Sprite[] sprites;
  private Player[] players = new Player[2];
  
  public Court(double width, double height, int gameChoice) {
    this.width = width;
    this.height = height;
    
    this.sprites = new Sprite[]{  new PongBall(Constants.PONG_BALL_X_START, PONG_BALL_Y_START),
                                  new CourtWall(0, Constants.COURT_TOP_WALL),
                                  new CourtWall(0, Constants.COURT_BOTTOM_WALL) };
    
    this.players[0] = new Player("Player 1", new Paddle(Constants.PLAYER1_X_START, Constants.PLAYER1_Y_START), 1);
    if(gameChoice == 0) {
      players[1] = new CpuPlayer("CPU", new Paddle(Constants.PLAYER2_X_START, Constants.PLAYER2_Y_START), (PongBall)sprites[0], 3);
    }
    else if(gameChoice == 1) {
      players[1] = new Player("Player 2", new Paddle(Constants.PLAYER2_X_START, Constants.PLAYER2_Y_START), 2);
    }
  }
  
  public PongBall getPongBall() {
    return (PongBall)this.sprites[0];
  }
  
  public int getCourtWidth() {
    return (int)this.width;
  }
  
  public int getCourtHeight() {
    return (int)this.height;
  }
  
  public void resetGame() {
    this.players[0].resetScore();
    this.players[1].resetScore();
  }
  
  public Player[] getPlayers() {
    return this.players;
  }
    
  public Sprite[] getSprites() {
    return sprites;
  }
  
  public void checkForCollision() {
    this.players[0].checkForCollision((PongBall)this.sprites[0]);
    this.players[1].checkForCollision((PongBall)this.sprites[0]);
  }
  
  public void checkForGoal() {
	  if(this.getPongBall().getXPosition() < 0) {
	    this.players[1].incrementScore();
      this.newServe();
      this.getPongBall().setXVelocity(1);
    }
	  else if(this.getPongBall().getXPosition() > this.getCourtWidth()) {
	    this.players[0].incrementScore();
      this.newServe();
      this.getPongBall().setXVelocity(-1);
	  }
  }
  
  public Player getWinner() {
    if(Integer.parseInt(this.players[0].getScore()) == Constants.WINNING_SCORE) {
      return this.players[0];
    }
    else if(Integer.parseInt(this.players[1].getScore()) == Constants.WINNING_SCORE) {
      return this.players[1];
    }
    return null;
  }

  public void newServe() {
    this.getPongBall().setYVelocity(0);
    this.getPongBall().setXVelocity(0);
    this.players[0].getPaddle().reset();
    this.players[1].getPaddle().reset();
    this.getPongBall().reset();
  }
}