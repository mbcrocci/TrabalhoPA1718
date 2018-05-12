/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.states;

import pkg9cardsiege.logic.Game;

/**
 *
 * @author mbcro
 */
public class AwaitStart extends StateAdapter {
    
    public AwaitStart(Game game) {
        super(game);
    }
    
    @Override
    public IState start() {
        getGame().createDeck();
        getGame().shuffleDeck();
        
        getGame().setupTurn();
        
        return new AwaitDraw(getGame());
    }
}
