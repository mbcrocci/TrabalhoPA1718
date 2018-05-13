package pkg9cardsiege.models.events;

import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;


public class Rally  extends RegularEvent {
    
    public Rally () {
        super(
                "Rally!", 
                "+1 to attacks on Close Combat or Circle Spaces",
                3,
                new RegularMovement(RegularMovement.GATES),
                new RegularMovement(RegularMovement.TREBUCHET)
        );
    }

    @Override
    public void apply(Game game) {
        game.getDRMS().put(DRM.CLOSE_COMBAT_ATK, 1);
        game.getDRMS().put(DRM.CIRLCE_SPACES_ATK, 1);
    }    
    
}
