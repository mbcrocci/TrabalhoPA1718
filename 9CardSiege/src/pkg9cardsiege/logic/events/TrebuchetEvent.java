package pkg9cardsiege.logic.events;

import java.util.ArrayList;
import pkg9cardsiege.logic.Game;
import pkg9cardsiege.logic.cards.StatusCard;


public class TrebuchetEvent extends Event {
    public TrebuchetEvent() {
        this.name = new String("Trebuchet Attack");
        this.description = new String(
                "3 trebuchets - 2 dmg to wall\n" +
                "2 trebuchets - 1 dmg to wall\n" +
                "1 trebuchets - 1 dmg to wall on D6 roll of 4, 5 or 6\n"
        );
        enemyAdvancementOrders = new ArrayList<>();
    }

   // @Override
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
