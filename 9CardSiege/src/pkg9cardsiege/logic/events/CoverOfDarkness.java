/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.events;

import pkg9cardsiege.logic.DRM;
import pkg9cardsiege.logic.Game;

/**
 *
 * @author mbcro
 */
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