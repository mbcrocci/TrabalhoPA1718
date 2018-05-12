package pkg9cardsiege.logic.states;

public interface IState {
    public IState start();
    public IState finish();
    
    public IState draw();
    
    public IState archersAttack(int track);
    public IState boilingWaterAttack(int track);
    public IState closeCombat();
    public IState coupure();
    public IState rallyTroops(Boolean applyDRM);
    public IState supplyRaid();
    public IState sabotage();
    public IState tunnelMovement();

    public IState additionalAction();
    public IState endTurn();    
    public IState save();
    
    public IState enterTunnel();
    public IState exitTunnel();
    public IState advanceTunnel();
    public IState moveBackTunnel();

    public IState fastMovement();
}
