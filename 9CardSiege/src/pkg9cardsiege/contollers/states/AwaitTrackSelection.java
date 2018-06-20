package pkg9cardsiege.contollers.states;

import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;
import pkg9cardsiege.models.cards.Track;

public class AwaitTrackSelection extends StateAdapter {
    
    private int attack; // 0 -> archers Attack
                        // 1 -> boiling attack
    
    public AwaitTrackSelection(Game game, int attack) {
        super(game);
        this.attack = attack;
    }
    
    
    @Override
    public IState selectTrack(int track) {
        getGame().setTrackChoice(track);
        
        System.out.println("GOing to attack");
        if (attack == 0)
            this.archersAttack();
        
        else if (attack == 1)
            this.boilingWaterAttack();
        
        return new AwaitActionChoice(getGame());
    }
    
    @Override
    public IState archersAttack() {
        
        if (!getGame().useAP()) {
            getGame().addMessage("Nao tem AP para usar. Acabe o turno.");
            return new AwaitActionChoice(getGame());
        }
        
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
            track.increase(); // increase because the lower the track gets the close the enemy is
            
        // if roll equal or less it does nothing
        return new AwaitActionChoice(getGame());
    }
    
    @Override
    public IState boilingWaterAttack() {
        if (!getGame().useAP()) {
            getGame().addMessage("Nao tem AP para usar. Acabe o turno.");
            return new AwaitActionChoice(getGame());
        }
        
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
            track.increase(); // increase because the lower the track gets the close the enemy is
        
        return new AwaitActionChoice(getGame());
    }
}
