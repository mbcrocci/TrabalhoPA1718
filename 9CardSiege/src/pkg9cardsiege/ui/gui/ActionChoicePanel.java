package pkg9cardsiege.ui.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.contollers.states.AwaitActionChoice;


public class ActionChoicePanel extends JPanel implements Observer {
    
    private GameState gameState;
    
    private JButton archersAtkBtn;
    private JButton boilingWaterAtkBtn;
    private JButton ccaAtkBtn;
    private JButton coupureBtn;
    private JButton rallyBtn;
    private JButton tunnelMovBtn;
    private JButton supplyRaidBtn;
    private JButton sabotageBtn;
    private JButton additionalActionBtn;
    private JButton endTurnBtn;
    private JButton saveGame; // TODO: change to a menu item
    
    
    public ActionChoicePanel(GameState gameState) {
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
        
        setupComponents();
        setupLayout();
    }
    
    public void setupComponents() {
        archersAtkBtn       = new JButton("Archers Attack");
        boilingWaterAtkBtn   = new JButton("Boiling Water Attack");
        ccaAtkBtn           = new JButton("Close Combat Attack");
        coupureBtn          = new JButton("Coupure");
        rallyBtn            = new JButton("Rally Troops");
        tunnelMovBtn        = new JButton("Tunnel Movement");
        supplyRaidBtn       = new JButton("Supply Raid"); 
        sabotageBtn         = new JButton("Sabotage");
        additionalActionBtn = new JButton("Additional Action");
        endTurnBtn          = new JButton("End Turn");
        saveGame            = new JButton("Save Game");
        
        archersAtkBtn      .addActionListener(new ArchersAtkListener());
        boilingWaterAtkBtn  .addActionListener(new BoilngWaterAtkListener());
        ccaAtkBtn          .addActionListener(new CcaAtkListener());
        coupureBtn         .addActionListener(new CoupureListener());
        rallyBtn           .addActionListener(new RallyListener());
        tunnelMovBtn       .addActionListener(new TunnelMovBListener());
        supplyRaidBtn      .addActionListener(new SupplyRaidListener());
        sabotageBtn        .addActionListener(new SabotageListener());
        additionalActionBtn.addActionListener(new AdditionalActionListener());
        endTurnBtn         .addActionListener(new EndTurnListener());
        saveGame           .addActionListener(new SaveGameListener());
    }
    
    public void setupLayout() {
        
        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalGlue());
        box.add(archersAtkBtn);
        box.add(Box.createVerticalGlue());
        box.add(boilingWaterAtkBtn);
        box.add(Box.createVerticalGlue());
        box.add(ccaAtkBtn);
        box.add(Box.createVerticalGlue());
        box.add(coupureBtn);
        box.add(Box.createVerticalGlue());
        box.add(rallyBtn);
        box.add(Box.createVerticalGlue());
        box.add(tunnelMovBtn);
        box.add(Box.createVerticalGlue());
        box.add(supplyRaidBtn);
        box.add(Box.createVerticalGlue());
        box.add(sabotageBtn);
        box.add(Box.createVerticalGlue());
        box.add(additionalActionBtn);
        box.add(Box.createVerticalGlue());
        box.add(endTurnBtn);
        box.add(Box.createVerticalGlue());
        
        setLayout(new BorderLayout());
        add(box, BorderLayout.CENTER);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        setVisible(gameState.getState() instanceof AwaitActionChoice);
    }
    
    private class ArchersAtkListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        }
        
    }
    
    private class BoilngWaterAtkListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        }
        
    }
    
    private class CcaAtkListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        }
        
    }
    
    private class CoupureListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }
    private class RallyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }
    private class TunnelMovBListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            gameState.tunnelMovement();
        }   
    }
    private class SupplyRaidListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }
    private class SabotageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }
    private class AdditionalActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }
    private class EndTurnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            gameState.endTurn();
        }
    }
    private class SaveGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
           
        }
    }
}
