package phylum.pong.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import phylum.pong.model.PongBall;
import phylum.pong.util.Constants;

public class PongBallView extends JPanel implements Constants {
  private PongBall ball;
  
  public PongBallView(PongBall ball) {
    super();
    this.ball = ball;
  }
  
  public void paint(Graphics g) {
    super.paint(g);
	
    g.setColor(Color.WHITE);
    g.fillOval(this.ball.getXPosition() - (Constants.PONG_BALL_DIAMETER/ 2), 
                this.ball.getYPosition() - (Constants.PONG_BALL_DIAMETER / 2),
                Constants.PONG_BALL_DIAMETER, Constants.PONG_BALL_DIAMETER);
  }
}