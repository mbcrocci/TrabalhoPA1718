package pkg9cardsiege.ui.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg9cardsiege.contollers.GameState;


public class GamePanel extends JPanel implements Observer {
    
    static private HashMap<String, BufferedImage> imgs = null;
    
    public static BufferedImage getStatusCardImg() {
        return imgs.get("StatusCard");
    }
    
    public static BufferedImage getEnemiesCardImg() {
        return imgs.get("EnemiesCard");
    }
    public static BufferedImage getEventCardBackImg() {
        return imgs.get("EventCardBack");
    }
    public static BufferedImage getEventCardFrontImg(String eventName) {
        return imgs.get(eventName);
    }
    
    static {
        try {
            imgs.put("StatusCard", ImageIO.read(Resources.getResourceFile("images/status_card.gif")));
            imgs.put("EnemiesCard", ImageIO.read(Resources.getResourceFile("images/enemies_card.gif")));
            imgs.put("EventCardBack", ImageIO.read(Resources.getResourceFile("images/event_back.gif")));
            imgs.put("Card1", ImageIO.read(Resources.getResourceFile("images/card1.gif")));
            imgs.put("Card2", ImageIO.read(Resources.getResourceFile("images/card2.gif")));
            imgs.put("Card3", ImageIO.read(Resources.getResourceFile("images/card3.gif")));
            imgs.put("Card4", ImageIO.read(Resources.getResourceFile("images/card4.gif")));
            imgs.put("Card5", ImageIO.read(Resources.getResourceFile("images/card5.gif")));
            imgs.put("Card6", ImageIO.read(Resources.getResourceFile("images/card6.gif")));
            imgs.put("Card7", ImageIO.read(Resources.getResourceFile("images/card7.gif")));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
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
        
    }   
}
