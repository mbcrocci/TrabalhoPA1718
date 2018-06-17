package pkg9cardsiege.ui.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.contollers.states.AwaitStart;


public class GameFrame extends JFrame implements Observer {
    
    private GameState gameState;
    private GamePanel gamePanel;
    private StartPanel startPanel;
    
    private Container cp;
    
    
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
        
        startPanel = new StartPanel(gameState);
        gamePanel = new GamePanel(gameState);
        
        addComponents();
        
        setLocation(x, y);
        setSize(width, height);
        setMinimumSize(new Dimension(width, height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        validate();
    }
    
    private void addComponents() {
        cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(startPanel, BorderLayout.CENTER);
        //cp.add(gamePanel, BorderLayout.CENTER);
    }
    
    @Override
    public void update(Observable t, Object o) {        
        System.out.println("UPDATING. STATE => " + gameState.getState());
        if (!(gameState.getState() instanceof AwaitStart) ) {
            cp.remove(startPanel);
            cp.add(gamePanel, BorderLayout.CENTER);
        }
        
        gamePanel.update(gameState, null);
        
        revalidate();
        repaint();
    }
}
