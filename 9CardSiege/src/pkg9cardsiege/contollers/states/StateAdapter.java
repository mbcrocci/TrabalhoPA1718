package pkg9cardsiege.contollers.states;

import java.io.Serializable;
import pkg9cardsiege.models.Game;


public class StateAdapter implements IState, Serializable {
    
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
    public IState archersAttack() {
        return this;
    }
    
    @Override
    public IState boilingWaterAttack() {
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
    public IState rallyTroops() {
        return this;
    }
    
    @Override
    public IState rallyTroops(Boolean c) {
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
         // Victory or Loss Check Phase
        if (getGame().victoryLossCheck()) {
            return new GameOver(getGame());
        }
        
        // End of Day Phase
        if (getGame().isDeckEmpty())
            getGame().endDay();
        
        if (getGame().getDay() == 3)
            return new GameOver(getGame());
        
        getGame().setupTurn();
        return new AwaitDraw(getGame());
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
    public IState additionalAction(int op) {
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
    
    @Override
    public IState selectTrack(int track) {
        return this;
    }
}
