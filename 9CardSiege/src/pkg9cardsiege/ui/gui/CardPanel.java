package pkg9cardsiege.ui.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg9cardsiege.contollers.GameState;


public class CardPanel extends JPanel implements Observer {

    private GameState gameState;
    
    public static final int STATUS_CARD = 0;
    private final String STATUS_IMG_PATH = "images/status_card.gif";
    
    public static final int ENEMIES_CARD = 1;
    private final String ENEMIES_IMG_PATH = "images/enemies_card.gif";
    
    public static final int EVENT_CARD = 2;
    private final String EVENT_IMG_PATH = "images/event_card.gif";
    
    private final int type;
    
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
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
