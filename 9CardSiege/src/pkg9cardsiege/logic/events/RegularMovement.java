package pkg9cardsiege.logic.events;

import pkg9cardsiege.logic.Game;
import pkg9cardsiege.logic.cards.EnemyTrackCard;


public class RegularMovement extends EnemyMovement { 
    public static final int WALL      = 0;
    public static final int GATES     = 1;
    public static final int TREBUCHET = 2;
    
    private final int trackMovementType;
    
    public RegularMovement(int type) {
        trackMovementType = type;
    }
    
    @Override
    public void apply(Game game) {
        EnemyTrackCard etc = game.getEnemyTrackCard();
        
        switch (trackMovementType) {
            case WALL: etc.advanceWall(); break;
            case GATES: etc.advanceGates(); break;
            case TREBUCHET: etc.advanceSiegeTower(); break;
        }
        
        // TODO: check if they went to CCA (maybe leave it to Game)
    }
}