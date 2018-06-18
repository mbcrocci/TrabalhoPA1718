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
import pkg9cardsiege.contollers.states.AwaitTrackSelection;


public class TrackSelectPanel extends JPanel implements Observer{
    
    private GameState gameState;
    
    private JButton wallBtn;
    private JButton gatesBtn;
    private JButton trebuBtn;
    
    public TrackSelectPanel(GameState gameState) {
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
        wallBtn = new JButton("Wall");
        gatesBtn = new JButton("Gates");
        trebuBtn = new JButton("Trebuchets");
        
        wallBtn.setPreferredSize(new Dimension(Constants.DIM_MENU_BTN_X, Constants.DIM_MENU_BTN_Y));
        gatesBtn.setPreferredSize(new Dimension(Constants.DIM_MENU_BTN_X, Constants.DIM_MENU_BTN_Y));
        trebuBtn.setPreferredSize(new Dimension(Constants.DIM_MENU_BTN_X, Constants.DIM_MENU_BTN_Y));
        
        wallBtn.addActionListener(new SelectWallListener());
        gatesBtn.addActionListener(new SelectGatesListener());
        trebuBtn.addActionListener(new SelectTrebuListener());


    }
    
    public void setupLayout() {
        add(wallBtn);
        add(gatesBtn);
        add(trebuBtn);
        
        setBorder(new LineBorder(Color.DARK_GRAY));
}
    
    
    @Override
    public void update(Observable o, Object arg) {
        setVisible(gameState.getState() instanceof AwaitTrackSelection);
    }

    private static class SelectWallListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }

    private static class SelectGatesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }

    private static class SelectTrebuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }
}
