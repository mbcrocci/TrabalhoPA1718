package pkg9cardsiege.contollers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import pkg9cardsiege.models.Game;
import pkg9cardsiege.contollers.states.AwaitStart;
import pkg9cardsiege.contollers.states.IState;


public class GameState extends Observable implements Serializable {
    private Game game;
    private IState state;
    
    public GameState() {
        this.game = new Game();
        this.state = new AwaitStart(game);
        
        setChanged();
        notifyObservers();
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
        this.state = state;
    }
    
    public ArrayList<String> getMessages() {
        return game.getMessages();
    }
    
    public void clearMessages() {
        game.clearMessages();
    }
    
    @Override
    public String toString() {
        return game.toString();
    }
    
    // -------- State methods --------
    public void start() {
        setState(getState().start());
        
        setChanged();
        notifyObservers();
    }
    
    public void draw() {
        setState(getState().draw());
        
        setChanged();
        notifyObservers();
    }

    
    // -------- Player Action methods ------
    
    public void archersAttack() {
        setState(getState().archersAttack());
        
        setChanged();
        notifyObservers();
    }
    
    public void boilingWaterAttack() {
        setState(getState().boilingWaterAttack());
        
        setChanged();
        notifyObservers();
    }
    
    public void closeCombat() {
        setState(getState().closeCombat());
        
        setChanged();
        notifyObservers();
    }
    
    public void coupure() {
        setState(getState().coupure());
        
        setChanged();
        notifyObservers();
    }
    
    public void rallyTroops(Boolean applyDRM) {
       setState(getState().rallyTroops(applyDRM));
       
       setChanged();
        notifyObservers();
    }
    
    public void supplyRaid() {
        setState(getState().supplyRaid());
        
        setChanged();
        notifyObservers();
    }
    
    public void sabotage() {
        setState(getState().sabotage());
        
        setChanged();
        notifyObservers();
    }
    
    public void additionalAction() {
        setState(getState().additionalAction());
        
        setChanged();
        notifyObservers();
    }
    
    public void additionalAction(int op) {
        setState(getState().additionalAction(op));
        
        setChanged();
        notifyObservers();
    }
    
    public void endTurn() {
        setState(getState().endTurn());
        
        setChanged();
        notifyObservers();
    }
    
    public void save() {
        setState(getState().save());
        
        setChanged();
        notifyObservers();
    }

    public void tunnelMovement() {
        setState(getState().tunnelMovement());
        
        setChanged();
        notifyObservers();
    }
    // ------- Tunnel Movement methods ---------
    
    public void enterTunnel() {
        setState(getState().enterTunnel());
        
        setChanged();
        notifyObservers();
    }
    
    public void exitTunnel() {
        setState(getState().exitTunnel());
        
        setChanged();
        notifyObservers();
    }
    
    public void advanceTunnel() {
        setState(getState().advanceTunnel());
        
        setChanged();
        notifyObservers();
    }
    
    public void moveBackTunnel() {
       setState(getState().moveBackTunnel());
       
       setChanged();
        notifyObservers();
    }
    
    public void fastMovement() {
        setState(getState().fastMovement());
        
        setChanged();
        notifyObservers();
    }    
    
    public void selectTrack(int track) {
        setState(getState().selectTrack(track));
        
        setChanged();
        notifyObservers();
    }
}
