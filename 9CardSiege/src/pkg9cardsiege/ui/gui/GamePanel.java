package pkg9cardsiege.ui.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg9cardsiege.contollers.GameState;


public class GamePanel extends JPanel implements Observer {
    
    private GameState gameState;
    private CardPanel statusPanel;
    private CardPanel enemiesPanel;
    private CardPanel eventPanel;
    private SelectionPanel actionChoicePanel;
    private SelectionPanel trackSelectionPanel;
    private SelectionPanel tunnelMovPanel;

        
    public GamePanel(GameState gameState) {
        this.gameState = gameState;
        
        update(gameState, null);
    }
    
    private void setComponents() {
        statusPanel = new CardPanel(gameState, CardPanel.STATUS_CARD);
        enemiesPanel = new CardPanel(gameState, CardPanel.ENEMIES_CARD);
        eventPanel = new CardPanel(gameState, CardPanel.EVENT_CARD);
    }

    private void setupLayout() {
        
        Box leftBox = Box.createVerticalBox();
        leftBox.add(Box.createVerticalGlue());
        leftBox.add(statusPanel);
        
        leftBox.add(Box.createVerticalGlue());

        leftBox.add(enemiesPanel);
        leftBox.add(Box.createVerticalGlue());


        Box rightBox = Box.createVerticalBox();
        rightBox.add(Box.createVerticalGlue());
        rightBox.add(eventPanel);
        
        rightBox.add(Box.createVerticalGlue());
        
        
        Box selectionBox = Box.createHorizontalBox();
        
        selectionBox.add(Box.createHorizontalGlue());
        selectionBox.add(actionChoicePanel);
        selectionBox.add(Box.createHorizontalGlue());
        selectionBox.add(trackSelectionPanel);
        selectionBox.add(Box.createHorizontalGlue());
        selectionBox.add(tunnelMovPanel);
        selectionBox.add(Box.createHorizontalGlue());
        
        rightBox.add(selectionBox);
        rightBox.add(Box.createVerticalGlue());
        
        Box center = Box.createHorizontalBox();
        center.add(Box.createHorizontalGlue());
        center.add(leftBox);
        center.add(Box.createHorizontalGlue());
        center.add(rightBox);
        center.add(Box.createHorizontalGlue());
        
        setLayout(new BorderLayout());
        add(center, BorderLayout.CENTER);
    }
    
    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
