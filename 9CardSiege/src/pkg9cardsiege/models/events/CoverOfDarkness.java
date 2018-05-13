package pkg9cardsiege.models.events;

import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;


public class CoverOfDarkness  extends RegularEvent {
    
    public CoverOfDarkness() {
        super(
                "Cover of Darkness", 
                "+1 to Raid and Sabotage actions",
                3,
                new SlowestUnitMovement()
        );
    }

    @Override
    public void apply(Game game) {
        game.getDRMS().put(DRM.RAID_ACT, 1);
        game.getDRMS().put(DRM.SABOTAGE_ACT, 1);
    }
}