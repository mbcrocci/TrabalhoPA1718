package pkg9cardsiege.models.events;

import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;


public class RepairedTrebuchet  extends RegularEvent {
    
    public RepairedTrebuchet() {
        super(
                "Repaired Trebuchet", 
                "Add 1 Trebuchet (max 3)",
                2,
                new RegularMovement(RegularMovement.WALL)
        );
    }

    @Override
    public void apply(Game game) {
        game.getEnemyTrackCard().increaseTrebuchets();
        game.getDRMS().put(DRM.COUPURE_ACT, 1);
    }    
}
