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
        Track track = getGame().getEnemyTrackCard().getTrack(
                getGame().getTrackChoice()
        );

        // roll
        int roll = getGame().getDice().roll();
        
        // apply drm
        switch(getGame().getTrackChoice()) {
            case 0: roll += getGame().getDRMS().get(DRM.LADDERS_ATK); break;
            case 1: roll += getGame().getDRMS().get(DRM.BATTERY_RAM_ATK); break;
            case 2: roll +=getGame().getDRMS().get(DRM.SIEGE_TOWER_ATK); break;
        }
        
        
        // check if track is on circle space so we can apply circle space drm
        if (getGame().getEnemyTrackCard().inCircleSpace(track))
            roll += getGame().getDRMS().get(DRM.CIRLCE_SPACES_ATK);
        
        getGame().addMessage("Roll: " + roll);
        
        // if roll bigger that trackStrength
        if (roll > track.getStrength())
            track.decrease();
            
        // if roll equal or less it does nothing
        return this;
    }
    
    @Override
    public IState boilingWaterAttack() {
        Track track = getGame().getEnemyTrackCard().getTrack(
                getGame().getTrackChoice()
        );
        
        if (!getGame().getEnemyTrackCard().inCircleSpace(track))
            return this;
        
        int roll = getGame().getDice().roll();
        
        switch(getGame().getTrackChoice()) {
            case 0: roll += getGame().getDRMS().get(DRM.LADDERS_ATK); break;
            case 1: roll += getGame().getDRMS().get(DRM.BATTERY_RAM_ATK); break;
            case 2: roll += getGame().getDRMS().get(DRM.SIEGE_TOWER_ATK); break;
        }
        
        if (getGame().getEnemyTrackCard().inCircleSpace(track))
            roll += getGame().getDRMS().get(DRM.CIRLCE_SPACES_ATK);
        
        // check if roll with drm is 1. if so it fails
        if (roll == 1)
            return this;
        
        // apply automatic drm
        roll++;
        getGame().addMessage("Roll: " + roll);
        if (roll > track.getStrength())
            track.decrease();
        
        return this;
    }
    
    @Override
    public IState closeCombat() {
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
        int roll = getGame().getDice().roll() + getGame().getDRMS().get(DRM.COUPURE_ACT);
        
        if (roll > 4)
            getGame().getStatusCard().increaseWall();
        
        return this;
    }
    
    @Override
    public IState rallyTroops(Boolean applyDRM) {
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
    public IState additionalAction() {
        return this;
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
