package pkg9cardsiege.logic.states;

import pkg9cardsiege.logic.Game;


public class StateAdapter implements IState {
    
    public Game game;
    
    public StateAdapter(Game game) {
        this.game = game;
    }
    
    public Game getGame() {
        return game;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }
    
    
    @Override
    public IState start() {
        return this;
    }

    @Override
    public IState finish() {
        return this;
    }
    
    @Override
    public IState draw() {
        return this;
    }
    
    @Override
    public IState archersAttack(int trackOption) {
        return this;
    }
    
    @Override
    public IState boilingWaterAttack(int trackOption) {
        return this;
    }
    
    @Override
    public IState closeCombat() {
        return this;
    }
    
    @Override
    public IState coupure() {
        return this;
    }
    
    @Override
    public IState rallyTroops(Boolean applyDRM) {
        return this;
    }
    
    @Override
    public IState supplyRaid() {
        return this;
    }
    
    @Override
    public IState sabotage() {
        return this;
    }
    
    @Override
    public IState endTurn() {
        return this;
    }
    
    @Override
    public IState tunnelMovement() {
        return this;
    }
    
    @Override
    public IState additionalAction() {
        return this;
    }
    
    @Override
    public IState save() {
        return this;
    }
    @Override
    public IState enterTunnel() {
        return this;
    }
    @Override
    public IState exitTunnel() {
        return this;
    }
    @Override
    public IState advanceTunnel() {
        return this;
    }
    @Override
    public IState moveBackTunnel() {
        return this;
    }

    @Override
    public IState fastMovement() {
        return this;
    }
}
