package pkg9cardsiege.ui.gui;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.contollers.states.GameOver;


public class GameOverPanel extends JPanel implements Observer {

    private GameState gameState;
    private JLabel label;
    
    
    public GameOverPanel(GameState gameState) {
        this.gameState = gameState;
        
        
        
    }
    
    @Override
    public void update(Observable o, Object o1) {
        setVisible(gameState.getState() instanceof GameOver);
    }
    
}
