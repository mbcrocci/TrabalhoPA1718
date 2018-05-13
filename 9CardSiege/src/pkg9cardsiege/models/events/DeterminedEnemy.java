package pkg9cardsiege.models.events;

import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;

public class DeterminedEnemy extends RegularEvent {
    
    public DeterminedEnemy() {
        super(
                "Determined Enemy",
                "+1 attacks on the Battering Ram",
                2,
                new RegularMovement(RegularMovement.GATES)
        );
    }

    @Override
    public void apply(Game game) {
        game.getDRMS().put(DRM.BATTERY_RAM_ATK, 1);
    }    
}
