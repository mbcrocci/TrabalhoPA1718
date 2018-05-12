package pkg9cardsiege.logic.states;

public interface IState {
    public IState start();
    public IState finish();
    
    
    public IState draw();
    public IState chooseTrack(int track);
    public IState chooseTunnelMovement();
    
    public IState archersAttack();
    public IState boilingWaterAttack();
    public IState closeCombat();
    public IState coupure();
    public IState rallyTroops();
    public IState supplyRaid();
    public IState sabotage();
    public IState tunnelMovement();

    public IState endTurn();    
    public IState save();
    
    public IState enterTunnel();
    public IState exitTunnel();
    public IState advanceTunnel();
    public IState moveBackTunnel();

    public IState fastMovement();
}
