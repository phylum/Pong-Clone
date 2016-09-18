package phylum.pong.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import phylum.pong.model.CourtWall;
import phylum.pong.util.Constants;

public class CourtWallView extends JPanel implements Constants {
  private CourtWall courtWall;
  
  public CourtWallView(CourtWall courtWall) {
    super();
    this.courtWall = courtWall;
  }
  
  public void paint(Graphics g) { 
    super.paint(g);
	
    g.setColor(Color.WHITE);
    g.fillRect(courtWall.getXPosition(), courtWall.getYPosition() - (Constants.COURT_WALL_WIDTH / 2),
	             Constants.COURT_WALL_LENGTH, Constants.COURT_WALL_WIDTH);
    g.fillRect(courtWall.getXPosition() + (Constants.COURT_WALL_WIDTH / 2), courtWall.getYPosition(),
	             Constants.COURT_WALL_LENGTH, Constants.COURT_WALL_WIDTH);
    g.fillRect(courtWall.getXPosition() - (Constants.COURT_WALL_WIDTH / 2), courtWall.getYPosition() - (Constants.COURT_WALL_WIDTH / 2),
	             Constants.COURT_WALL_LENGTH, Constants.COURT_WALL_WIDTH);
    g.fillRect(courtWall.getXPosition(), courtWall.getYPosition() - (Constants.COURT_WALL_WIDTH / 2),
	             Constants.COURT_WALL_LENGTH, Constants.COURT_WALL_WIDTH);
  }
}