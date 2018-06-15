package pkg9cardsiege.ui.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.contollers.states.AwaitDraw;


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
    public static BufferedImage getEventCardFrontImg(int cardNumber) {
        return imgs.get("Card" + cardNumber);
    }
    
    static {
        try {
            imgs = new HashMap<>();
            imgs.put("StatusCard", ImageIO.read(Resources.getResourceFile("images/status_card.png")));
            imgs.put("EnemiesCard", ImageIO.read(Resources.getResourceFile("images/enemies_card.png")));
            imgs.put("EventCardBack", ImageIO.read(Resources.getResourceFile("images/event_back.png")));
            imgs.put("Card1", ImageIO.read(Resources.getResourceFile("images/card1.png")));
            imgs.put("Card2", ImageIO.read(Resources.getResourceFile("images/card2.png")));
            imgs.put("Card3", ImageIO.read(Resources.getResourceFile("images/card3.png")));
            imgs.put("Card4", ImageIO.read(Resources.getResourceFile("images/card4.png")));
            imgs.put("Card5", ImageIO.read(Resources.getResourceFile("images/card5.png")));
            imgs.put("Card6", ImageIO.read(Resources.getResourceFile("images/card6.png")));
            imgs.put("Card7", ImageIO.read(Resources.getResourceFile("images/card7.png")));

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
        
        setupComponents();
        setupLayout();
        
        update(gameState, null);
    }
    
    private void setupComponents() {
        statusPanel = new CardPanel(gameState, CardPanel.STATUS_CARD);
        enemiesPanel = new CardPanel(gameState, CardPanel.ENEMIES_CARD);
        eventPanel = new CardPanel(gameState, CardPanel.EVENT_CARD);
        
        actionChoicePanel = new SelectionPanel();
        trackSelectionPanel = new SelectionPanel();
        tunnelMovPanel = new SelectionPanel();
    }

    private void setupLayout() {
        
        Box topBox = Box.createHorizontalBox();
        topBox.add(Box.createHorizontalGlue());
        
            Box leftTopBox = Box.createVerticalBox();
            leftTopBox.add(Box.createVerticalGlue());
            leftTopBox.add(new JLabel("Status"));
            leftTopBox.add(Box.createVerticalGlue());
            leftTopBox.add(statusPanel);
            leftTopBox.add(Box.createVerticalGlue());
            
        topBox.add(leftTopBox);
        topBox.add(Box.createHorizontalGlue());
        
            Box rightBotBox = Box.createVerticalBox();
            rightBotBox.add(Box.createVerticalGlue());
            rightBotBox.add(new JLabel("Enemies"));
            rightBotBox.add(Box.createVerticalGlue());
            rightBotBox.add(enemiesPanel);
            rightBotBox.add(Box.createVerticalGlue());
            
        topBox.add(rightBotBox);
        topBox.add(Box.createHorizontalGlue());

        Box botBox = Box.createHorizontalBox();
        botBox.add(Box.createHorizontalGlue());
        
            Box rightTopBox = Box.createVerticalBox();
            rightTopBox.add(Box.createVerticalGlue());
            rightTopBox.add(new JLabel("Event"));
            rightTopBox.add(Box.createVerticalGlue());
            rightTopBox.add(eventPanel);
            rightTopBox.add(Box.createVerticalGlue());
            
        
        botBox.add(rightTopBox);
        botBox.add(Box.createHorizontalGlue());
        
            Box selectionBox = Box.createHorizontalBox();
        
            selectionBox.add(Box.createHorizontalGlue());
            selectionBox.add(actionChoicePanel);
            selectionBox.add(Box.createHorizontalGlue());
            selectionBox.add(trackSelectionPanel);
            selectionBox.add(Box.createHorizontalGlue());
            selectionBox.add(tunnelMovPanel);
            selectionBox.add(Box.createHorizontalGlue());
        
        botBox.add(selectionBox);
        botBox.add(Box.createVerticalGlue());
        
        Box center = Box.createVerticalBox();
        center.add(Box.createVerticalGlue());
        center.add(topBox);
        center.add(Box.createVerticalGlue());
        center.add(botBox);
        center.add(Box.createVerticalGlue());
        
        setLayout(new BorderLayout());
        add(center, BorderLayout.CENTER);
    }
    
    @Override
    public void update(Observable o, Object o1) {
        if (gameState.getState() instanceof AwaitDraw) {
            eventPanel.setBack();
        }
        
        repaint();
    }
}
