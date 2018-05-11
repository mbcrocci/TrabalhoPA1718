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
public class Faith  extends RegularEvent {
    
    public Faith() {
        super(
                "Faith", 
                "+1 to attacks on the Battering Ram, Ladders, and Morale action",
                3,
                new RegularMovement(RegularMovement.WALL),
                new RegularMovement(RegularMovement.GATES),
                new RegularMovement(RegularMovement.TREBUCHET)
        );
    }

    @Override
    public void apply(Game game) {
        game.getDRMS().put(DRM.BATTERY_RAM_ATK, 1);
        game.getDRMS().put(DRM.LADDERS_ATK, 1);
        game.getDRMS().put(DRM.SIEGE_TOWER_ATK, 1);
                
    }    
    
}
