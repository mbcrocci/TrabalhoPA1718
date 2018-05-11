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
public class RepairedTrebuchet  extends RegularEvent {
    
    public RepairedTrebuchet() {
        super(
                "Repaired Trebuchet", 
                "Add 1 Trebuchet (max 3)",
                2,
                new RegularMovement(RegularMovement.WALL)
        );
    }

    @Override
    public void apply(Game game) {
        game.getEnemyTrackCard().increaseTrebuchets();
        game.getDRMS().put(DRM.COUPURE_ACT, 1);
    }    
}
