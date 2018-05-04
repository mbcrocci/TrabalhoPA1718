/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.cards;

/**
 *
 * @author m0nk1w1
 */

enum Tunnel {
    Castle,
    TUNNEL1,
    TUNNEL2,
    ENEMYLINES,
};


public class StatusCard extends Card {
    
    // Map from Track -> int
    private Track wallStrength;
    private Track morale;
    private Track fortressSupplies;
    
    private boolean []tunnel;
    
    private int supplies;
    
    public StatusCard() {
        super();
        
        this.wallStrength = new Track(4, 1);
        this.morale = new Track(4, 1);
        this.fortressSupplies = new Track(4, 1);
        
        tunnel = new boolean[4];
        for (boolean p : tunnel)
            p = false;

        supplies = 0;
    }

    public int getWallStrength() {
        return wallStrength.getValue();
    }

    public int getMorale() {
        return morale.getValue();
    }

    public int getFortressSupplies() {
        return fortressSupplies.getValue();
    }
    
    public int getSupplies() {
        return supplies;
    }
    
    public int getTunnel() {
        for (int i = 0; i < tunnel.length; i++)
            if (tunnel[i])
                return i;
        
        return 0;
    }
    
    public void increaseWall() {
        wallStrength.increase();
    }
    
    public void increaseMorale() {
        morale.increase();
    }
    public void increaseFortressSupplies() {
        fortressSupplies.increase();
    }
    
    public void decreaseWall() {
        wallStrength.decrease();
    }
    
    public void decreaseMorale() {
        morale.decrease();
    }
    public void decreaseFortressSupplies() {
        fortressSupplies.decrease();
    }
}
