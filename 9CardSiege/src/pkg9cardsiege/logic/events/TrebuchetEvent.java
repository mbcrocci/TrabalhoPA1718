/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.events;

import pkg9cardsiege.logic.Game;
import pkg9cardsiege.logic.cards.EnemyTrackCard;
import pkg9cardsiege.logic.cards.StatusCard;

/**
 *
 * @author m0nk1w1
 */
public class TrebuchetEvent extends Event{
    public TrebuchetEvent() {
        super();
        
        EnemyAdvancementOrders.add(new NoEnemyMovement());
    }

    @Override
    public void apply(Game game) {
        EnemyTrackCard etc = game.getEnemyTrackCard();
        StatusCard sc = game.getStatusCard();
        int trebuchets = etc.getTrebuchets();
        
        switch (trebuchets) {
            case 3:
                sc.decreaseWall();
                sc.decreaseWall();
                break;
            case 2:
                sc.decreaseWall();
                break;
            case 1:
                // roll
                sc.decreaseWall();
                break;
            default:
                break;
        }
    }
}
