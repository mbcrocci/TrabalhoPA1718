package pkg9cardsiege.logic.events;

import java.util.HashMap;
import pkg9cardsiege.logic.DRM;
import pkg9cardsiege.logic.Game;

public class GuardsDistracted extends RegularEvent {
    
    public GuardsDistracted() {
        super(
                "Guards Distracted",
                "+1 to sabotage action\n+1 to morale action",
                2,
                new SlowestUnitMovement()
        );
    }

    @Override
    public void apply(Game game) {
        HashMap<DRM, Integer> drms = game.getDRMS();
        
       drms.put(DRM.SABOTAGE_ACT, 1);
       drms.put(DRM.MORALE_ACT, 1);
    }
    
}
