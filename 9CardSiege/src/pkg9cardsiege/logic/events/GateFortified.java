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
