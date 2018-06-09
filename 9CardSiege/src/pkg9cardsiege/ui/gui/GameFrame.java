package pkg9cardsiege.ui.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.Border;
import javax.swing.JFrame;
import pkg9cardsiege.contollers.GameState;


public class GameFrame extends JFrame implements Observer {
    
    private GameState gameState;
    private final GamePanel gamePanel;
    
    
    public GameFrame(GameState gameState) {
        this(
            gameState,
            Constants.START_X_FRAME, Constants.START_Y_FRAME,
            Constants.DIM_X_FRAME, Constants.DIM_Y_FRAME
        );
    }
    
    public GameFrame(GameState gameState, int x, int y) {
        this(
            gameState,
            x, y,
            Constants.DIM_X_FRAME, Constants.DIM_Y_FRAME
        );
    }
    
    public GameFrame(GameState gameState, int x, int y, int width, int height) {
        super("9 Card Siege"); 
        
        this.gameState = gameState;
        this.gameState.addObserver(this);
        
        Container cp = getContentPane();
        
        gamePanel = new GamePanel(gameState);
        cp.add(gamePanel, BorderLayout.CENTER);
        
        setLocation(x, y);
        setSize(width, height);
        setMinimumSize(new Dimension(width, height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        validate();
    }
    
    @Override
    public void update(Observable t, Object o) {
        repaint();
    }
}
