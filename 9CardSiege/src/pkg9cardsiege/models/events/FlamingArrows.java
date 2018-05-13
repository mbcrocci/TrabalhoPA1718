package pkg9cardsiege.models.events;

import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;


public class FlamingArrows extends RegularEvent {
    
    public FlamingArrows() {
        super(
                "Flaming Arrows", 
                "+1 to attacks on the Siege Engine",
                3,
                new RegularMovement(RegularMovement.TREBUCHET)
        );
    }

    @Override
    public void apply(Game game) {
        game.getDRMS().put(DRM.SIEGE_ENGINE_ATK, 1);
    }
    
}
