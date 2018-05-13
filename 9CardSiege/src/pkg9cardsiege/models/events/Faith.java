package pkg9cardsiege.models.events;

import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;


public class Faith  extends RegularEvent {
    
    public Faith() {
        super(
                "Faith", 
                "+1 to attacks on the Battering Ram, Ladders, and Morale action",
                3,
                new RegularMovement(RegularMovement.WALL),
                new RegularMovement(RegularMovement.GATES),
                new RegularMovement(RegularMovement.TREBUCHET)
        );
    }

    @Override
    public void apply(Game game) {
        game.getDRMS().put(DRM.BATTERY_RAM_ATK, 1);
        game.getDRMS().put(DRM.LADDERS_ATK, 1);
        game.getDRMS().put(DRM.SIEGE_TOWER_ATK, 1);
                
    }    
    
}
