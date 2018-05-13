package pkg9cardsiege.models.events;

import pkg9cardsiege.models.Game;
import pkg9cardsiege.models.cards.EnemyTrackCard;


public class SlowestUnitMovement extends EnemyMovement {

    public SlowestUnitMovement() {
    }

    @Override
    public void apply(Game game) {
        EnemyTrackCard etc = game.getEnemyTrackCard();
        
        Integer []values = new Integer[3];
        
        values[0] = etc.getWall();
        values[1] = etc.getGates();
        values[2] = etc.getSiegeTower();
        
        // Calculates what's the furthest track
        Integer max = 0;
        for (Integer value1 : values) {
            max = Math.max(max, value1);
        }
        
        // Because there can be tracks at the same distance
        // it checks what tracks are at that maximum value
        // and applies the corresponding movement.
        for (Integer value: values)
            if (value.equals(max))
                switch(value) {
                    case 0: etc.advanceWall(); break;
                    case 1: etc.advanceGates(); break;
                    case 2: etc.advanceSiegeTower(); break;
                }
    }
}
