package phylum.pong;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;

import phylum.pong.PongView;
import phylum.pong.util.Constants;

public class Pong extends JFrame implements Constants {
  public Pong() {
    add(new PongView());
    
    setTitle("Pong Clone");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(Constants.COURT_WIDTH, Constants.COURT_HEIGHT);
    setLocationRelativeTo(null);
    setVisible(true);
    setResizable(false);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                Pong pong = new Pong();
                pong.setVisible(true);                
            }
        });
  }
}