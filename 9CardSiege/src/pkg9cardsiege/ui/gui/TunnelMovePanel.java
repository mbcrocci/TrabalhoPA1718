package pkg9cardsiege.ui.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.contollers.states.AwaitTunnelMovChoice;


public class TunnelMovePanel extends JPanel implements Observer {
    private GameState gameState;
    
    
    public TunnelMovePanel(GameState gameState) {
        this.gameState = gameState;
        this.gameState.addObserver(this);
        Dimension d = new Dimension(
            Constants.GAP_X_CARD + Constants.DIM_X_CARD + Constants.GAP_X_CARD,
            Constants.GAP_Y_CARD + Constants.DIM_Y_CARD + Constants.GAP_X_CARD
        );
                
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);
        
        setBackground(Color.yellow);
    }

    @Override
    public void update(Observable o, Object o1) {
        setVisible(gameState.getState() instanceof AwaitTunnelMovChoice);
    }
}
