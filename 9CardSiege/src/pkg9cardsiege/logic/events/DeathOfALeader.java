/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.events;

import pkg9cardsiege.logic.Game;

/**
 *
 * @author mbcro
 */
public class DeathOfALeader extends RegularEvent {
    public DeathOfALeader () {
        super(
                "Death of a Leader",
                "Reduce morale by 1",
                2,
                new RegularMovement(RegularMovement.WALL),
                new RegularMovement(RegularMovement.TREBUCHET)
        );
    }

    @Override
    public void apply(Game game) {
        game.getStatusCard().decreaseMorale();
    }
}
