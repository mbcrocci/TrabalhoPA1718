package pkg9cardsiege.logic.states;

public interface IState {
    public IState start();
    public IState finish();
    
    public IState draw();
    
    public IState archersAttack();
    public IState boilingWaterAttack();
    public IState closeCombat();
    public IState coupure();
    public IState rallyTroops(Boolean applyDRM);
    public IState supplyRaid();
    public IState sabotage();
    public IState tunnelMovement();
    
    public IState selectTrack(int t);

    public IState additionalAction();
    public IState endTurn();    
    public IState save();
    
    public IState enterTunnel();
    public IState exitTunnel();
    public IState advanceTunnel();
    public IState moveBackTunnel();

    public IState fastMovement();
}
