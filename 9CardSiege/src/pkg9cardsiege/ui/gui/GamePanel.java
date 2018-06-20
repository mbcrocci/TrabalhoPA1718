package pkg9cardsiege.ui.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.contollers.states.AwaitActionChoice;
import pkg9cardsiege.contollers.states.AwaitDraw;
import pkg9cardsiege.contollers.states.AwaitTrackSelection;
import pkg9cardsiege.contollers.states.AwaitTunnelMovChoice;


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
    private ActionChoicePanel actionChoicePanel;
    private TrackSelectPanel trackSelectionPanel;
    private TunnelMovePanel tunnelMovPanel;
    private JPanel choicePanel;
    private JLabel choiceLabel;
    private JLabel dayLabel;
    private JLabel actionPointsLabel;
    private JButton endTurnBtn;
    private JLabel messagesLabel;

        
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
        
        actionChoicePanel = new ActionChoicePanel(gameState);
        trackSelectionPanel = new TrackSelectPanel(gameState);
        tunnelMovPanel = new TunnelMovePanel(gameState);
        
        choicePanel = new JPanel();
        choiceLabel = new JLabel();
        
        dayLabel = new JLabel("Day 1");
        actionPointsLabel = new JLabel("AP: ");
        
        endTurnBtn = new JButton("End Turn");
        endTurnBtn.addActionListener((e) -> gameState.endTurn());
        
        messagesLabel = new JLabel("");
    }

    private void setupLayout() {
        
        Box leftTopBox = Box.createVerticalBox();
        leftTopBox.add(Box.createVerticalGlue());
        leftTopBox.add(new JLabel("Status"));
        leftTopBox.add(Box.createVerticalGlue());
        leftTopBox.add(statusPanel);
        leftTopBox.add(Box.createVerticalGlue());
        
        Box rightTopBox = Box.createVerticalBox();
        rightTopBox.add(Box.createVerticalGlue());
        rightTopBox.add(new JLabel("Enemies"));
        rightTopBox.add(Box.createVerticalGlue());
        rightTopBox.add(enemiesPanel);
        rightTopBox.add(Box.createVerticalGlue());
        
        Box topBox = Box.createHorizontalBox();
        topBox.add(Box.createHorizontalGlue());
        topBox.add(leftTopBox);
        topBox.add(Box.createHorizontalGlue());
        topBox.add(rightTopBox);
        topBox.add(Box.createHorizontalGlue());
        
        
        Box leftBotBox = Box.createVerticalBox();
        leftBotBox.add(Box.createVerticalGlue());
        leftBotBox.add(new JLabel("Event"));
        leftBotBox.add(Box.createVerticalGlue());
        leftBotBox.add(eventPanel);
        leftBotBox.add(Box.createVerticalGlue());
        
        Box rightBotBox = Box.createVerticalBox();
        rightBotBox.add(Box.createVerticalGlue());
        rightBotBox.add(choiceLabel);
        rightBotBox.add(Box.createVerticalGlue());
        rightBotBox.add(choicePanel);
        rightBotBox.add(Box.createVerticalGlue());

        Box botBox = Box.createHorizontalBox();
        botBox.add(Box.createHorizontalGlue());
        botBox.add(leftBotBox);
        botBox.add(Box.createHorizontalGlue());
        botBox.add(rightBotBox);
        botBox.add(Box.createHorizontalGlue());
        
        Box center = Box.createVerticalBox();
        center.add(Box.createVerticalGlue());
        center.add(topBox);
        center.add(Box.createVerticalGlue());
        center.add(botBox);
        center.add(Box.createVerticalGlue());
        
        center.setBorder(new LineBorder(Color.DARK_GRAY));
        
        
        JPanel south = new JPanel();
        south.setPreferredSize(new Dimension(Constants.DIM_X_SOUTH, Constants.DIM_Y_SOUTH));
        south.setBorder(new LineBorder(Color.DARK_GRAY));
        south.add(dayLabel);
        south.add(actionPointsLabel);
        south.add(endTurnBtn);
        south.add(messagesLabel);
        
        
        setLayout(new BorderLayout());
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);
    }
    
    public void swapChoicePanel(JPanel newPanel) {
        choicePanel.removeAll();
        choicePanel.add(newPanel);
        choicePanel.setVisible(true);
    }
    
    @Override
    public void update(Observable o, Object o1) {
        dayLabel.setText("Day " + (gameState.getGame().getDay()+1));
        actionPointsLabel.setText("AP: " + gameState.getGame().getAP());
        
        if (gameState.getMessages().size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Messages: ");
            gameState.getMessages().forEach((msg) -> {
                sb.append(msg).append("\n\t");
            });
            gameState.clearMessages();
            
            messagesLabel.setText(sb.toString());
        } else {
            messagesLabel.setText("");
        }
        
        if (gameState.getState() instanceof AwaitDraw) {
            System.out.println("CARDS IN DECK => " + gameState.getGame().getDeckSize());
            
            eventPanel.setBack();
        
            choicePanel.setVisible(false);
            choiceLabel.setText("");
        
        } else if (gameState.getState() instanceof AwaitActionChoice) {
            swapChoicePanel(actionChoicePanel);
            choiceLabel.setText("Select Action");
        
        } else if (gameState.getState() instanceof AwaitTrackSelection) {
            swapChoicePanel(trackSelectionPanel);
            choiceLabel.setText("Select Track");
        
        } else if (gameState.getState() instanceof AwaitTunnelMovChoice) {
            swapChoicePanel(tunnelMovPanel);
            choiceLabel.setText("Select Tunnel Movement");
        
        }   
        
        revalidate();
        repaint();
    }
}
