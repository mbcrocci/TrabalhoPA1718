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
