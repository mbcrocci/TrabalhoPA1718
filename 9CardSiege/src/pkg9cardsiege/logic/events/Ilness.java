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
public class Ilness extends RegularEvent {
    public Ilness() {
        super(
            "Ilness",
            "Reduce morale by 1\nReduce supplies by 1",
            2,
            new RegularMovement(RegularMovement.TREBUCHET)
        );
    }
    

    @Override
    public void apply(Game game) {
        game.getStatusCard().decreaseMorale();
        game.getStatusCard().decreaseSupplies();
    }    
}
