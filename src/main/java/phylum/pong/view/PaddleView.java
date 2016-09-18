package phylum.pong.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import phylum.pong.model.Paddle;
import phylum.pong.util.Constants;

public class PaddleView extends JPanel implements Constants {
  private Paddle paddle;
  
  public PaddleView(Paddle paddle) {
    super();
    this.paddle = paddle;
  }
  
  public void paint(Graphics g) {
    super.paint(g);
    
    g.setColor(Color.WHITE);
    g.fillRoundRect(paddle.getXPosition() - (Constants.PADDLE_WIDTH / 2),
                    paddle.getYPosition() - (Constants.PADDLE_LENGTH / 2), 
                    Constants.PADDLE_WIDTH, Constants.PADDLE_LENGTH, 
                    Constants.PADDLE_ARC_WIDTH, Constants.PADDLE_ARC_LENGTH);
  }
}