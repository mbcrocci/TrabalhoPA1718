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
public class Collapsed extends RegularEvent {
    public Collapsed() {
        super(
                "Collapsed!",
                "Siege Tower Removed from game if on starting space",
                2,
                new RegularMovement(RegularMovement.WALL),
                new RegularMovement(RegularMovement.GATES)
        );
    }

    @Override
    public void apply(Game game) {
        game.removeSiegeTower();
    }    
}
