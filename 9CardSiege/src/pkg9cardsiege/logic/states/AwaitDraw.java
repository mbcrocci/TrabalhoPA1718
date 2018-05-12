/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.states;

import pkg9cardsiege.logic.Game;
import pkg9cardsiege.logic.cards.EventCard;
import pkg9cardsiege.logic.events.Event;

/**
 *
 * @author mbcro
 */
public class AwaitDraw extends StateAdapter {
    
    public AwaitDraw(Game game) {
        super(game);
    }
    
    @Override
    public IState finish() {
        return new GameOver(getGame());
    }
    
    @Override
    public IState draw() {
        EventCard card = game.drawCard();
        game.addMessage("Drawn Card: " + card.toString());
        
        Event currentEvent = card.getEvent(game.getDay());
        game.addMessage("Applied Event: " + currentEvent.toString());
        
        // add action points
        game.addAP(currentEvent.getActionPointAllowance());
        
        // Event Phase
        currentEvent.apply(game);
        
        // Enemy Movement Phase
        currentEvent.applyEnemyMovement(game);
        
        // check if there are 3 enemies in CCA => loose
        if (game.getEnemyTrackCard().checkCCA() == 3) {
            return new GameOver(game);
        }
        
        return new AwaitActionChoice(getGame());
    }
}
