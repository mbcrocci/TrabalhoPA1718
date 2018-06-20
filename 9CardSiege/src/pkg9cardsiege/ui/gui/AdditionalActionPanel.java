package pkg9cardsiege.ui.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.contollers.states.AwaitAdditionalActionChoice;


public class AdditionalActionPanel extends JPanel implements Observer {
    private GameState gameState;
    
    private JButton moraleBtn;
    private JButton supplyBtn;
        
    
    public AdditionalActionPanel(GameState gameState) {
        this.gameState = gameState;
        this.gameState.addObserver(this);
        
        Dimension d = new Dimension(
                Constants.GAP_X_CARD + Constants.DIM_X_CARD + Constants.GAP_X_CARD,
                Constants.GAP_Y_CARD + Constants.DIM_Y_CARD + Constants.GAP_X_CARD
        );
        
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);
        
        setupComponents();
        setupLayout();
    }
    
    public void setupComponents() {
        moraleBtn = new JButton("Morale");
        supplyBtn = new JButton("Supply");
        
        moraleBtn.addActionListener((e) -> gameState.additionalAction(0));
        supplyBtn.addActionListener((e) -> gameState.additionalAction(1));
    }
    
    public void setupLayout() {
        add(moraleBtn);
        add(supplyBtn);
        
        setBorder(new LineBorder(Color.DARK_GRAY));
    }
    @Override
    public void update(Observable o, Object arg) {
        setVisible(gameState.getState() instanceof AwaitAdditionalActionChoice);
    }
}
