package pkg9cardsiege.models.events;

import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;


public class BoilingOil extends RegularEvent {
    
    public BoilingOil() {
        super(
                "Boiling Oil",
                "+2 to attacks on enemy units in circle spaces",
                2,
                new RegularMovement(RegularMovement.WALL),
                new RegularMovement(RegularMovement.GATES)
        );
    }

    @Override
    public void apply(Game game) {
        game.getDRMS().put(DRM.CIRLCE_SPACES_ATK, 2);
    }
}