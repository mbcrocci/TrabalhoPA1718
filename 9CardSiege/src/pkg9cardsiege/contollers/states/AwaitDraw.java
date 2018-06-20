package pkg9cardsiege.contollers.states;

import pkg9cardsiege.models.Game;
import pkg9cardsiege.models.cards.EventCard;
import pkg9cardsiege.models.events.Event;


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
        //game.addMessage("Drawn Card:\n" + card.toString());
        
        Event currentEvent = card.getEvent(game.getDay());
        //game.addMessage("Applied Event:\n" + currentEvent.toString());
        
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
