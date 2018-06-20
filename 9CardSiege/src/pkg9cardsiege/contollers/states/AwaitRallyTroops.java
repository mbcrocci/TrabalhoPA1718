package pkg9cardsiege.contollers.states;

import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;


public class AwaitRallyTroops extends StateAdapter {
    private Boolean choice;
    
    public AwaitRallyTroops(Game game) {
        super(game);
    }
    
    @Override
    public IState rallyTroops(Boolean c) {
        this.choice = c;
        
        return this.rallyTroops();
    }

    @Override
    public IState rallyTroops() {
        if (!getGame().useAP()) {
            getGame().addMessage("Nao tem AP para usar. Acabe o turno.");
            return new AwaitActionChoice(getGame());
        }
        
        int roll = 0;
        
        if (choice) {
            getGame().getStatusCard().getFortressSupplies();
            roll = getGame().getDRMS().get(DRM.MORALE_ACT);
        }
        
        roll += getGame().getDice().roll();
        
        if (roll > 4)
            getGame().getStatusCard().increaseMorale();
        
        return new AwaitActionChoice(game);
    }
    
}
