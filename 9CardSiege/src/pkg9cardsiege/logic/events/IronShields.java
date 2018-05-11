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
public class IronShields  extends RegularEvent {
    
    public IronShields() {
        super(
                "Iron Shields", 
                "-1 to attacks on SiegeTower",
                2,
                new RegularMovement(RegularMovement.TREBUCHET)
        );
    }

    @Override
    public void apply(Game game) {
        game.getDRMS().put(DRM.SIEGE_TOWER_ATK, -1);
    }    
    
}
