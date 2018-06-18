package pkg9cardsiege.ui.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.contollers.states.AwaitTunnelMovChoice;


public class TunnelMovePanel extends JPanel implements Observer {
    private GameState gameState;
    
    private JButton enterBtn;
    private JButton exitBtn;
    private JButton advanceBtn;
    private JButton moveBackBtn;
    private JButton fastMovementBtn;
    
    
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
        
        
        setupComponents();
        setupLayout();
    }
    
    public void setupComponents() {
        enterBtn        = new JButton("Enter Tunnel (1 AP)");
        exitBtn         = new JButton("Exit Tunnel (free)");
        advanceBtn      = new JButton("Advance (free or 1 AP)");
        moveBackBtn     = new JButton("Move Back (free or 1 AP)");
        fastMovementBtn = new JButton("FastMovement (1 AP)");
        
        enterBtn       .setPreferredSize(new Dimension(Constants.DIM_MENU_BTN_X, Constants.DIM_MENU_BTN_Y));
        exitBtn        .setPreferredSize(new Dimension(Constants.DIM_MENU_BTN_X, Constants.DIM_MENU_BTN_Y));
        advanceBtn     .setPreferredSize(new Dimension(Constants.DIM_MENU_BTN_X, Constants.DIM_MENU_BTN_Y));
        moveBackBtn    .setPreferredSize(new Dimension(Constants.DIM_MENU_BTN_X, Constants.DIM_MENU_BTN_Y));
        fastMovementBtn.setPreferredSize(new Dimension(Constants.DIM_MENU_BTN_X, Constants.DIM_MENU_BTN_Y));
        
        enterBtn       .addActionListener(new EnterListener());
        exitBtn        .addActionListener(new ExitListener());
        advanceBtn     .addActionListener(new AdvanceListener());
        moveBackBtn    .addActionListener(new MoveBackListener());
        fastMovementBtn.addActionListener(new FastMovementListener());
    }
    
    public void setupLayout() {
        add(enterBtn);
        add(exitBtn);
        add(advanceBtn);
        add(moveBackBtn);
        add(fastMovementBtn);
        
        setBorder(new LineBorder(Color.DARK_GRAY));
    }
    
    public class EnterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameState.enterTunnel();
        }
    }
    
    public class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameState.exitTunnel();
        }
    }
    
    public class AdvanceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameState.advanceTunnel();
        }
    }
    
    public class MoveBackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameState.moveBackTunnel();
        }
    }
    
    public class FastMovementListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameState.fastMovement();
        }
    }

    @Override
    public void update(Observable o, Object o1) {
        setVisible(gameState.getState() instanceof AwaitTunnelMovChoice);
    }
}
