/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.events;

import pkg9cardsiege.logic.Game;
import pkg9cardsiege.logic.cards.EnemyTrackCard;

/**
 *
 * @author m0nk1w1
 */
public class RegularMovement extends EnemyMovement {
    private enum trackMovementType {
        WALL,
        GATES,
        TREBUCHET,
    }
    
    private trackMovementType trackMovement;
    
    public RegularMovement(trackMovementType type) {
        super();
        trackMovement = type;
    }
    
    @Override
    public void apply(Game game) {
        EnemyTrackCard etc = game.getEnemyTrackCard();
        
        switch (trackMovement) {
            case WALL: etc.advanceWall(); break;
            case GATES: etc.advanceGates(); break;
            case TREBUCHET: etc.advanceSiegeTower(); break;
        }
        
        // TODO: check if they went to CCA
    }
}
