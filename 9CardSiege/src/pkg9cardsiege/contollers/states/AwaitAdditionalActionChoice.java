package pkg9cardsiege.contollers.states;

import pkg9cardsiege.models.Game;


public class AwaitAdditionalActionChoice extends StateAdapter {
    public AwaitAdditionalActionChoice(Game g) {
        super(g);
    }
    
    @Override
    public IState additionalAction(int op) {
        getGame().aditionalAction(op);
        
        return new AwaitActionChoice(getGame());
    }
}
