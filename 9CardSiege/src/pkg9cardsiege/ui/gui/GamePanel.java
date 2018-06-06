package pkg9cardsiege.ui.gui;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg9cardsiege.contollers.GameState;


public class GamePanel extends JPanel implements Observer {
    
    private GameState gameState;
    
    public GamePanel(GameState gameState) {
        this.gameState = gameState;
        
        JLabel label = new JLabel("Game Over");
        
        add(label);
        
        update(gameState, null);
    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
