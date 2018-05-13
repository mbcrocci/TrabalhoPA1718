
package pkg9cardsiege.models;

import java.io.Serializable;


public enum DRM implements Serializable {
    // drms on actions
    SABOTAGE_ACT,
    MORALE_ACT,
    COUPURE_ACT,
    RAID_ACT,
    
    // drms on attacks
    LADDERS_ATK,
    BATTERY_RAM_ATK,
    SIEGE_TOWER_ATK,
    SIEGE_ENGINE_ATK,
    
    CLOSE_COMBAT_ATK,
    CIRLCE_SPACES_ATK
}
