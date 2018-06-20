package pkg9cardsiege.contollers.states;

import java.util.ArrayList;
import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;
import pkg9cardsiege.models.cards.Track;

public class AwaitActionChoice extends StateAdapter {

    public AwaitActionChoice(Game game) {
        super(game);
    }
    
    @Override
    public IState archersAttack() {
        return new AwaitTrackSelection(getGame(), 0);
    }
    
    @Override
    public IState boilingWaterAttack() {
        return new AwaitTrackSelection(getGame(), 1);
    }
    
    @Override
    public IState closeCombat() {
        if (!getGame().useAP()) {
            getGame().addMessage("Nao tem AP para usar. Acabe o turno.");
            return new AwaitActionChoice(getGame());
        }
        ArrayList<Track> tracks = new ArrayList<>();
        
        if (getGame().getEnemyTrackCard().getGates() == 0)
            tracks.add(getGame().getEnemyTrackCard().getTrack(0));
        
        if (getGame().getEnemyTrackCard().getGates() == 0)
            tracks.add(getGame().getEnemyTrackCard().getTrack(1));
        
        if (getGame().getEnemyTrackCard().getSiegeTower() == 0)
            tracks.add(getGame().getEnemyTrackCard().getTrack(2));
        
        
        // make a roll for each track beacause
        // if it was 1 against 2 combined
        // tracks, you wouldnt be able to win.
        // (max roll + drm = 7 vs CCAStrength = 8)
        for (Track track: tracks) {
            int roll = getGame().getDice().roll();
        
            if (roll == 1)
                getGame().getStatusCard().decreaseMorale();
        
            roll += getGame().getDRMS().get(DRM.CLOSE_COMBAT_ATK);
        
            getGame().addMessage("Roll: " + roll);
            if (roll > track.getStrength())
                track.decrease();
        }
        return this;
    }
    
    @Override
    public IState coupure() {
        if (!getGame().useAP()) {
            getGame().addMessage("Nao tem AP para usar. Acabe o turno.");
            return new AwaitActionChoice(getGame());
        }
        
        int roll = getGame().getDice().roll() + getGame().getDRMS().get(DRM.COUPURE_ACT);
        
        if (roll > 4)
            getGame().getStatusCard().increaseWall();
        
        return this;
    }
    
    @Override
    public IState rallyTroops(Boolean applyDRM) {
        if (!getGame().useAP()) {
            getGame().addMessage("Nao tem AP para usar. Acabe o turno.");
            return new AwaitActionChoice(getGame());
        }
        
        int roll = 0;
        
        if (applyDRM) {
            getGame().getStatusCard().getFortressSupplies();
            roll = getGame().getDRMS().get(DRM.MORALE_ACT);
        }
        
        roll += getGame().getDice().roll();
        
        if (roll > 4)
            getGame().getStatusCard().increaseMorale();
        
        return this;
    }
    
    @Override
    public IState supplyRaid() {
        if (!getGame().useAP()) {
            getGame().addMessage("Nao tem AP para usar. Acabe o turno.");
            return new AwaitActionChoice(getGame());
        }
        
        if (getGame().getStatusCard().getSupplies() == 2)
            return this;
        
        // if soldiers are not on enemy lines, return
        if (getGame().getStatusCard().getTunnel().getPosition() != 3)
            return this;
        
        int roll = getGame().getDice().roll() + getGame().getDRMS().get(DRM.RAID_ACT);
        
        if (roll == 6) {
            getGame().getStatusCard().increaseSupplies();
            getGame().getStatusCard().increaseSupplies();
            
        } else if (2 < roll && roll < 6) {
            getGame().getStatusCard().increaseSupplies();
            
        } else if (roll == 1) {
            getGame().capture();
        }
        
        return this;
    }
    
    @Override
    public IState sabotage() {
        if (!getGame().useAP()) {
            getGame().addMessage("Nao tem AP para usar. Acabe o turno.");
            return new AwaitActionChoice(getGame());
        }
        // if no unit on Enemy Lines
        if (getGame().getStatusCard().getTunnel().getPosition() != 3)
            return this;
        
        int roll = getGame().getDice().roll() + getGame().getDRMS().get(DRM.SABOTAGE_ACT);
        
        if (roll == 1)
            getGame().capture();
            
        else if (roll > 4)
            getGame().getEnemyTrackCard().reduceTrebuchets();
        
        return this;
    }
    
    
    @Override
    public IState additionalAction() {
        return new AwaitAdditionalActionChoice(getGame());
    }
    
    @Override
    public IState tunnelMovement() {
        return new AwaitTunnelMovChoice(getGame());
    }
    
    @Override
    public IState save() {
        getGame().save();
        return this;
    }
}
