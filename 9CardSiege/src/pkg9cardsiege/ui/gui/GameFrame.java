package pkg9cardsiege.ui.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.contollers.states.AwaitStart;
import pkg9cardsiege.contollers.states.GameOver;


public class GameFrame extends JFrame implements Observer {
    
    private GameState gameState;
    
    private JMenuBar menuBar;
    private JMenu menu;
    
    private GamePanel gamePanel;
    private StartPanel startPanel;
    private GameOverPanel gameOverPanel;
    
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
        gameOverPanel = new GameOverPanel(gameState);
        
        setupMenu();
        addComponents();
        
        setLocation(x, y);
        setSize(width, height);
        setPreferredSize(new Dimension(width, height));
        //setMinimumSize(new Dimension(width, height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        validate();
    }
    private void saveGameToFile(String filename) throws IOException {
        ObjectOutputStream oout = null;
        
        try {
            oout = new ObjectOutputStream(new FileOutputStream(filename));
            
            oout.writeObject(gameState);
            
        } finally {
            if (oout != null)
                oout.close();   
        }
    }
     
    private GameState getGameFromFile (String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream oin = null;
        GameState gs = null;

        try  {
            oin = new ObjectInputStream(new FileInputStream(filename));

            gs = (GameState) oin.readObject();

        } finally {
            if (oin != null)
                oin.close();
        }
        
        return gs;
    }
       
    
    private void setupMenu() {
        menuBar = new JMenuBar();
        menu = new JMenu("Options");
        
        JMenuItem saveItem = new JMenuItem("Save Game");
        JMenuItem loadItem = new JMenuItem("Load Game");
        
        saveItem.addActionListener(new SaveListener());
        loadItem.addActionListener(new LoadListener());
        
        menu.add(saveItem);
        menu.add(loadItem);
        
        menuBar.add(menu);
        
        setJMenuBar(menuBar);
    }
    
    private void addComponents() {
        cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(startPanel, BorderLayout.CENTER);
        //cp.add(gamePanel, BorderLayout.CENTER);
    }
    
    @Override
    public void update(Observable t, Object o) {
        if (!(gameState.getState() instanceof AwaitStart) ) {
            cp.remove(startPanel);
            cp.add(gamePanel, BorderLayout.CENTER);
        }
        
        if (gameState.getState() instanceof GameOver) {
            cp.removeAll();
            cp.add(gameOverPanel, BorderLayout.CENTER);
        }
        
        gamePanel.update(gameState, null);
        
        revalidate();
        repaint();
    }
    
    private class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
           try {
                saveGameToFile("savedgame");
                
            } catch (IOException e) {
                gameState.getGame().addMessage("Couldn't save game.");
            }
        }
    }
    
    private class LoadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            GameState newGS = null;
            try {
                newGS = getGameFromFile("savedgame");
                
            } catch (IOException | ClassNotFoundException e) {
                gameState.getGame().addMessage("Couldn't load game.");

            } finally {
                if (newGS != null) {
                    gameState = newGS;
                    repaint();
                }
            }
        }
    }
}
