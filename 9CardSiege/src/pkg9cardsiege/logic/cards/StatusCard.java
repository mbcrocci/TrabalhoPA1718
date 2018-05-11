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

public class StatusCard extends Card {
    
    // Map from Track -> int
    private Track wallStrength;
    private Track morale;
    private Track fortressSupplies;
    
    private Tunnel tunnel;
    
    private int supplies;
    
    public StatusCard() {
        super();
        
        this.wallStrength = new Track(4, 1);
        this.morale = new Track(4, 1);
        this.fortressSupplies = new Track(4, 1);
        
        this.tunnel = new Tunnel();

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
    
    public Tunnel getTunnel() {
        return tunnel;
    }
    
    public int getPosition() {
        return tunnel.getPosition();
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
    
    public void increaseSupplies() {
        if (supplies < 2)
            supplies++;
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

    public void decreaseSupplies() {
        if (supplies > 0) {
            supplies--;
            
            if (supplies == 0)
                addSupplies();
        }
        

    }

    public void clearSupplies() {
        supplies = 0;
    }

    public void addSupplies() {
        fortressSupplies.increase(supplies);
    }
}
