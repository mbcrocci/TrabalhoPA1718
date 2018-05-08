/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.events;

import java.util.ArrayList;
import java.util.Collection;
import pkg9cardsiege.logic.Game;
import pkg9cardsiege.logic.cards.EnemyTrackCard;

/**
 *
 * @author m0nk1w1
 */
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
