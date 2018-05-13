package pkg9cardsiege.contollers.states;

import pkg9cardsiege.models.Game;

public class AwaitTunnelMovChoice extends StateAdapter {
    
    public AwaitTunnelMovChoice(Game game) {
        super(game);
    }
    
    @Override
    public IState enterTunnel() {
        getGame().enterTunnel();
        
        return new AwaitActionChoice(getGame());
    }
    
    @Override
    public IState exitTunnel() {
        getGame().exitTunnel();
        
        return new AwaitActionChoice(getGame());
    }
    
    @Override
    public IState advanceTunnel() {
        getGame().advanceTunnel();
        
        return new AwaitActionChoice(getGame());
    }
    
    @Override
    public IState moveBackTunnel() {
        getGame().moveBackTunnel();
        
        return new AwaitActionChoice(getGame());
    }
    
    @Override
    public IState fastMovement() {
        getGame().fastMovement();
        
        return new AwaitActionChoice(getGame());
    }
}
