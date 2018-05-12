package pkg9cardsiege.logic;

import pkg9cardsiege.logic.states.AwaitStart;
import pkg9cardsiege.logic.states.IState;


public class GameState {
    private Game game;
    private IState state;
    
    public GameState() {
        this.game = new Game();
        this.state = new AwaitStart(game);
    }
    
    public Game getGame() {
        return game;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }
    
    public IState getState() {
        return state;
    }
    
    public void setState(IState state) {
        
    }
    
    @Override
    public String toString() {
        return game.toString();
    }
    
    // -------- State methods --------
    public void start() {
        setState(getState().start());
    }
    
    public void draw() {
        setState(getState().draw());
    }

    
    // -------- Player Action methods ------
    
    public void archersAttack(int trackOption) {
        setState(getState().archersAttack(trackOption));
    }
    
    public void boilingWaterAttack(int trackOption) {
        setState(getState().boilingWaterAttack(trackOption));
    }
    
    public void closeCombat() {
        setState(getState().closeCombat());
    }
    
    public void coupure() {
        setState(getState().coupure());
    }
    
    public void rallyTroops(Boolean applyDRM) {
       setState(getState().rallyTroops(applyDRM));
    }
    
    public void supplyRaid() {
        setState(getState().supplyRaid());
    }
    
    public void sabotage() {
        setState(getState().sabotage());
    }
    
    public void additionalAction() {
        setState(getState().additionalAction());
    }
    
    public void endTurn() {
        setState(getState().endTurn());
    }
    
    public void save() {
        setState(getState().save());
    }

    public void tunnelMovement() {
        setState(getState().tunnelMovement());
    }
    // ------- Tunnel Movement methods ---------
    
    public void enterTunnel() {
        setState(getState().enterTunnel());
    }
    
    public void exitTunnel() {
        setState(getState().exitTunnel());
    }
    
    public void advanceTunnel() {
        setState(getState().advanceTunnel());
    }
    
    public void moveBackTunnel() {
       setState(getState().moveBackTunnel());
    }
    
    public void fastMovement() {
        setState(getState().fastMovement());
    }    
}
