package pkg9cardsiege.models.events;

import java.util.ArrayList;
import pkg9cardsiege.models.Game;
import pkg9cardsiege.models.cards.StatusCard;


public class TrebuchetEvent extends Event {
    public TrebuchetEvent() {
        this.name = "Trebuchet Attack";
        this.description =
                "3 trebuchets - 2 dmg to wall\n" +
                "2 trebuchets - 1 dmg to wall\n" +
                "1 trebuchets - 1 dmg to wall on D6 roll of 4, 5 or 6\n";
        enemyAdvancementOrders = new ArrayList<>();
    }

    @Override
    public void apply(Game game) {
        StatusCard sc = game.getStatusCard();
        int trebuchets = game.getEnemyTrackCard().getTrebuchets();
        
        switch (trebuchets) {
            case 3:
                sc.decreaseWall();
                sc.decreaseWall();
                break;
            case 2:
                sc.decreaseWall();
                break;
            case 1:
                int roll = game.getDice().roll();
                if (roll >= 4)
                    sc.decreaseWall();
                break;

            default:
                break;
        }
    }
}
