package pkg9cardsiege.models.events;

import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;


public class EnemyFatigue   extends RegularEvent {
    
    public EnemyFatigue () {
        super(
                "Enemy Fatige", 
                "_1 to Coupure, Raid and Sabotage actions",
                3,
                new RegularMovement(RegularMovement.WALL)
        );
    }

    @Override
    public void apply(Game game) {
        game.getDRMS().put(DRM.COUPURE_ACT, 1);
        game.getDRMS().put(DRM.RAID_ACT, 1);
        game.getDRMS().put(DRM.SABOTAGE_ACT, 1);
    }    
}
