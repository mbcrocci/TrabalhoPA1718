package pkg9cardsiege.models.events;

import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;


public class GateFortified extends RegularEvent {
    public GateFortified () {
        super(
                "Gate Fortified",
                "+1 to attacks on the Battering Ram",
                2,
                new RegularMovement(RegularMovement.WALL),
                new RegularMovement(RegularMovement.GATES)
        );
    }

    @Override
    public void apply(Game game) {
        game.getDRMS().put(DRM.BATTERY_RAM_ATK, 1);
    }
}
