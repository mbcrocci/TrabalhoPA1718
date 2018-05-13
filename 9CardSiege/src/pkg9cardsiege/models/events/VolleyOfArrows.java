package pkg9cardsiege.models.events;

import java.util.HashMap;
import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;


public class VolleyOfArrows  extends RegularEvent {
    
    public VolleyOfArrows() {
        super(
                "Volley of Arrowss", 
                "+1 to all attacks",
                3,
                new RegularMovement(RegularMovement.GATES)
        );
    }

    @Override
    public void apply(Game game) {
        HashMap<DRM, Integer> drms = game.getDRMS();
        drms.put(DRM.BATTERY_RAM_ATK, 1);
        drms.put(DRM.SIEGE_TOWER_ATK, 1);
        drms.put(DRM.SIEGE_ENGINE_ATK, 1);
        drms.put(DRM.CIRLCE_SPACES_ATK, 1);
        drms.put(DRM.CLOSE_COMBAT_ATK, 1);
    }
}
