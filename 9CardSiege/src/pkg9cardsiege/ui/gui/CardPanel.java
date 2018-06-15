package pkg9cardsiege.ui.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg9cardsiege.contollers.GameState;


public class CardPanel extends JPanel implements Observer {

    private GameState gameState;
    
    public static final int STATUS_CARD = 0;
    public static final int ENEMIES_CARD = 1;
    public static final int EVENT_CARD = 2;
    
    private final int type;
    
    private boolean front = true; // its false when a event card i face down
    
    private Box cardBox;
    private JLabel label;
    private JPanel panel;
    
    public CardPanel(GameState gameState, int type) {
        this.gameState = gameState;
        this.type = type;
        
        this.label = new JLabel();
        this.label.setFont(new Font("Arial", Font.BOLD, 12));
        
        this.panel = new JPanel();
        // TODO: add image
        
        // TODO: Draw image
        switch(this.type) {
            case STATUS_CARD:
                label.setText("Status Card");
                break;
                
            case ENEMIES_CARD:
                label.setText("Enemy Card");
                break;
                
            case EVENT_CARD:
                label.setText("Event");
                break;
        }
        
        cardBox = Box.createVerticalBox();
        cardBox.add(label, Box.CENTER_ALIGNMENT);
        cardBox.add(panel);
        
        setLayout(new BorderLayout());
        add(cardBox, BorderLayout.CENTER);
    }
    
    public void setBack() {
        front = false;
    }
    
    
    @Override
    public void update(Observable o, Object arg) {
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        switch (type) {
            case EVENT_CARD:
                if (!front) {
                    g.drawImage(GamePanel.getEventCardBackImg(), 0, 0, null);
                    
                } else {
                    int cardNumber = gameState.getGame().getCurrentEvent().getNumber();
                    g.drawImage(
                            GamePanel.getEventCardFrontImg(cardNumber),
                            type, type, label
                    );
                }   break;
            case STATUS_CARD:
                g.drawImage(GamePanel.getStatusCardImg(), 0, 0, null);
                break;
            case ENEMIES_CARD:
                g.drawImage(GamePanel.getEnemiesCardImg(), 0, 0, null);
                break;
            default:
                break;
        }
    }
    
}
