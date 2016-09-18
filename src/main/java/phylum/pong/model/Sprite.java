package phylum.pong.model;

import phylum.pong.util.Constants;

public class Sprite {
  private int xPosition;
  private int xVelocity = 0;
  private int yPosition;
  private int yVelocity = 0;
  private int xStart;
  private int yStart;
  
  private boolean up = false;
  private boolean down = false;
  private boolean left = false;
  private boolean right = false;
  
  public Sprite(int x, int y) {
    this.xPosition = x;
    this.xStart = x;
    this.yPosition = y;
    this.yStart = y;
  }
  
  public void reset() {
    this.xPosition = this.xStart;
    this.yPosition = this.yStart;
  }
  
  public int getXPosition() {
    return this.xPosition;
  }
  
  public int getYPosition() {
    return this.yPosition;
  }
  
  public int getXVelocity() {
    return this.xVelocity;
  }
  
  public int getYVelocity() {
    return this.yVelocity;
  }
  
  public void setXPosition(int x) {
    this.xPosition = x;
  }
  
  public void setYPosition(int y) {
    this.yPosition = y;
  }
  
  public void setXVelocity(int dx) {
    this.xVelocity = dx;
  }
  
  public void setYVelocity(int dy) {
    this.yVelocity = dy;
  }
  
  public void setUp(boolean onOff) {
    this.up = onOff;
  }
  
  public void setDown(boolean onOff) {
    this.down = onOff;
  }
  
  public void setLeft(boolean onOff) {
    this.left = onOff;
  }
  
  public void setRight(boolean onOff) {
    this.right = onOff;
  }
  
  public boolean canGoUp() {
    return this.up;
  }
  
  public boolean canGoDown() {
    return this.down;
  }
  
  public boolean canGoLeft() {
    return this.left;
  }
  
  public boolean canGoRight() {
    return this.right;
  }
  
  public void move() {
    
  }
}