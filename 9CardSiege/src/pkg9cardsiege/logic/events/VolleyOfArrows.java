/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.events;

import java.util.HashMap;
import pkg9cardsiege.logic.DRM;
import pkg9cardsiege.logic.Game;

/**
 *
 * @author mbcro
 */
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
