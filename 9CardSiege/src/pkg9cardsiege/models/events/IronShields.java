package pkg9cardsiege.models.events;

import pkg9cardsiege.models.DRM;
import pkg9cardsiege.models.Game;


public class IronShields  extends RegularEvent {
    
    public IronShields() {
        super(
                "Iron Shields", 
                "-1 to attacks on SiegeTower",
                2,
                new RegularMovement(RegularMovement.TREBUCHET)
        );
    }

    @Override
    public void apply(Game game) {
        game.getDRMS().put(DRM.SIEGE_TOWER_ATK, -1);
    }    
    
}
