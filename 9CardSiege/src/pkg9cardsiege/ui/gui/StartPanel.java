package pkg9cardsiege.ui.gui;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.contollers.states.AwaitStart;


public class StartPanel extends JPanel implements Observer {
    
    private GameState gameState;
    
    private JLabel gameTitle;
    private JButton startBtn;
    
    
    public StartPanel(GameState gameState) {
        this.gameState = gameState;
        
        // TODO: Set background image
        
        
        // create and position title
        gameTitle = new JLabel("9 Card Siege");
        
        // create and position start button
        startBtn = new JButton("Start");
        startBtn.addActionListener((g) -> gameState.start());
        
        // add components
        add(gameTitle);
        add(startBtn);
    }
    
    @Override
    public void update(Observable t, Object o) {
        setVisible(gameState.getState() instanceof AwaitStart);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
    }
}
