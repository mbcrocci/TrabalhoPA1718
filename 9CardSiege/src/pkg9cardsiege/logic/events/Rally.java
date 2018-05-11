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
public class Rally  extends RegularEvent {
    
    public Rally () {
        super(
                "Rally!", 
                "+1 to attacks on Close Combat or Circle Spaces",
                3,
                new RegularMovement(RegularMovement.GATES),
                new RegularMovement(RegularMovement.TREBUCHET)
        );
    }

    @Override
    public void apply(Game game) {
        game.getDRMS().put(DRM.CLOSE_COMBAT_ATK, 1);
        game.getDRMS().put(DRM.CIRLCE_SPACES_ATK, 1);
    }    
    
}
