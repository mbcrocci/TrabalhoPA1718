package pkg9cardsiege.ui.gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.contollers.states.AwaitDraw;
import pkg9cardsiege.models.cards.StatusCard;


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
    
    private BufferedImage img;
    
    public CardPanel(GameState gameState, int type) {
        this.gameState = gameState;
        this.type = type;
        
        if (type == EVENT_CARD)
            front = false;
        
        setImg();
        
        Dimension d = new Dimension(
                Constants.GAP_X_CARD + img.getWidth() + Constants.GAP_X_CARD,
                Constants.GAP_Y_CARD + img.getHeight()  + Constants.GAP_X_CARD
        );
        
        System.out.println("IMG WIDTH: " + img.getWidth());
        System.out.println("IMG HEIGHT: "+ img.getHeight());
        
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);
        
        setBackground(Color.LIGHT_GRAY);
        
        addMouseListener(new EventListener());
    }
    
    public void setBack() {
        front = false;
    }
    
    public void setImg() {
        switch (type) {
            case EVENT_CARD:
                if (!front) {
                    img = GamePanel.getEventCardBackImg();
                    
                } else {
                    int cardNumber = gameState.getGame().getCurrentEvent().getNumber();
                    img = GamePanel.getEventCardFrontImg(cardNumber);
                }   break;
                
            case STATUS_CARD:
                img = GamePanel.getStatusCardImg();
                break;
            case ENEMIES_CARD:
                img = GamePanel.getEnemiesCardImg();
                break;
            default:
                break;
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if (type == EVENT_CARD && gameState.getState() instanceof AwaitDraw)
            setBack();
        
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (img != null)
            g.drawImage(
                img, Constants.GAP_X_CARD, Constants.GAP_Y_CARD, null);
        
        drawCubes(g);
    }
    
    public void drawCubes(Graphics g) {
        switch(this.type) {
        case STATUS_CARD:
            drawStatusCubes(g);
            break;
            
        case ENEMIES_CARD:
            drawEnemiesCubes(g);
            break;
        }
    }
    
    public void drawStatusCubes(Graphics g) {
        StatusCard sc = gameState.getGame().getStatusCard();
        int x = 0, y = 0, width, height;
        
        width = Constants.DIM_X_CUBE;
        height = Constants.DIM_Y_CUBE;
        
        switch (sc.getWallStrength()) {
        case 0:
            x = Constants.GAP_X_SURRENDER;
            y = Constants.GAP_Y_SURRENDER;
            break;
        case 1:
            x = Constants.GAP_X_TRACK;
            y = Constants.GAP_Y_TRACK + (Constants.DIM_Y_CUBE + Constants.GAP_Y_TRACK_SPACE) * 3;
            break;
        case 2:
            x = Constants.GAP_X_TRACK;
            y = Constants.GAP_Y_TRACK + (Constants.DIM_Y_CUBE + Constants.GAP_Y_TRACK_SPACE) * 2;
            break;
        case 3:
            x = Constants.GAP_X_TRACK;
            y = Constants.GAP_Y_TRACK + Constants.DIM_Y_CUBE + Constants.GAP_Y_TRACK_SPACE;
            break;
        case 4:
            x = Constants.GAP_X_TRACK;
            y = Constants.GAP_Y_TRACK;
            break;
        }
        
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);
        
        switch (sc.getMorale()) {
        case 0:
            x = Constants.GAP_X_SURRENDER;
            y = Constants.GAP_Y_SURRENDER;
            break;
        case 1:
            x = Constants.GAP_X_TRACK + Constants.GAP_X_TRACK_SPACE + Constants.DIM_X_CUBE;
            y = Constants.GAP_Y_TRACK + (Constants.DIM_Y_CUBE + Constants.GAP_Y_TRACK_SPACE) * 3;
            break;
        case 2:
            x = Constants.GAP_X_TRACK + Constants.GAP_X_TRACK_SPACE + Constants.DIM_X_CUBE;
            y = Constants.GAP_Y_TRACK + (Constants.DIM_Y_CUBE + Constants.GAP_Y_TRACK_SPACE) * 2;
            break;
        case 3:
            x = Constants.GAP_X_TRACK + Constants.GAP_X_TRACK_SPACE + Constants.DIM_X_CUBE;
            y = Constants.GAP_Y_TRACK + (Constants.DIM_Y_CUBE + Constants.GAP_Y_TRACK_SPACE) * 1;
            break;
        case 4:
            x = Constants.GAP_X_TRACK + Constants.GAP_X_TRACK_SPACE + Constants.DIM_X_CUBE;
            y = Constants.GAP_Y_TRACK;
            break;
        }
        
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);
        
        switch (sc.getFortressSupplies()) {
        case 0:
            x = Constants.GAP_X_SURRENDER;
            y = Constants.GAP_Y_SURRENDER;
            break;
        case 1:
            x = Constants.GAP_X_TRACK + (Constants.GAP_X_TRACK_SPACE + Constants.DIM_X_CUBE) * 2;
            y = Constants.GAP_Y_TRACK + (Constants.DIM_Y_CUBE + Constants.GAP_Y_TRACK_SPACE) * 3;
            break;
        case 2:
            x = Constants.GAP_X_TRACK + (Constants.GAP_X_TRACK_SPACE + Constants.DIM_X_CUBE) * 2;
            y = Constants.GAP_Y_TRACK + (Constants.DIM_Y_CUBE + Constants.GAP_Y_TRACK_SPACE) * 2;
            break;
        case 3:
            x = Constants.GAP_X_TRACK + (Constants.GAP_X_TRACK_SPACE + Constants.DIM_X_CUBE) * 2;
            y = Constants.GAP_Y_TRACK + (Constants.DIM_Y_CUBE + Constants.GAP_Y_TRACK_SPACE) * 1;
            break;
        case 4:
            x = Constants.GAP_X_TRACK + (Constants.GAP_X_TRACK_SPACE + Constants.DIM_X_CUBE) * 2;
            y = Constants.GAP_Y_TRACK;
            break;
        }
        
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);
        
        if (sc.getTunnel().getPosition() != 0) {
            y = Constants.GAP_Y_TUNNEL;
            g.setColor(Color.BLUE);
            
            switch (sc.getTunnel().getPosition()) {
                case 1:
                    x = Constants.GAP_X_TUNNEL;
                    break;
                case 2:
                    x = Constants.GAP_X_TUNNEL + Constants.DIM_X_CUBE;
                    break;
                case 3:
                    x = Constants.GAP_X_TUNNEL + Constants.DIM_X_CUBE * 2;
                    break;
                case 4:
                    x = Constants.GAP_X_TUNNEL + Constants.DIM_X_CUBE * 3;
                    break;
            }
            
            g.fillRect(x, y, width, height);
        }
        
        if (sc.getSupplies() != 0) {
            x = Constants.GAP_X_SUPPLIES;
            g.setColor(Color.YELLOW);
            
            switch (sc.getSupplies()) {
            case 1:
                y = Constants.GAP_Y_SUPPLIES;
                break;
            case 2:
                y = Constants.GAP_Y_SUPPLIES - Constants.DIM_Y_CUBE;
            }
            
            g.fillRect(x, y, width, height);
        }
    }
    
    public void drawEnemiesCubes(Graphics g) {
        
    }
    
    private class EventListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent me) {
            if (gameState.getState() instanceof AwaitDraw) {
                
                gameState.draw();
                
                front = true;
                setImg();
                
                //notify();
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    }
}
