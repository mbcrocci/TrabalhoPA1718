package pkg9cardsiege.contollers.states;

import pkg9cardsiege.models.Game;


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
