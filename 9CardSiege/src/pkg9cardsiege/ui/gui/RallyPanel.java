package pkg9cardsiege.ui.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.contollers.states.AwaitRallyTroops;

public class RallyPanel  extends JPanel implements Observer {
    private GameState gameState;
    
    private JButton yesBtn;
    private JButton noBtn;
    
    public RallyPanel(GameState gameState) {
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
        yesBtn = new JButton("Yes");
        noBtn = new JButton("No");
        
        yesBtn.addActionListener((e) -> gameState.rallyTroops(true));
        noBtn.addActionListener((e) -> gameState.rallyTroops(false));
    }
    
    public void setupLayout() {
        add(yesBtn);
        add(noBtn);
        
        setBorder(new LineBorder(Color.DARK_GRAY));
    }
    
    @Override
    public void update(Observable o, Object arg) {
        setVisible(gameState.getState() instanceof AwaitRallyTroops);
    }
}
