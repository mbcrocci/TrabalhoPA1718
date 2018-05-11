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
public class EnemyTrackCard extends Card {
    
    private Track wall;
    private Track gates;
    private Track siegeTower;
    
    private Track trebuchet;
    
    //private Integer enemiesInCCA;
    
    public EnemyTrackCard() {
        super();
        
        wall = new Track(4, 4, 2);
        gates = new Track(4, 4, 3);
        siegeTower = new Track(4, 4, 4);
        
        trebuchet = new Track(3, 0);
    }
    
    public Track getTrack(int n) {
        switch (n) {
            case 0: return wall;
            case 1: return gates;
            case 2: return siegeTower;
        }
        
        return null;
    }

    public int getWall() {
        return wall.getValue();
    }
    
    public void advanceWall() {
        wall.decrease();
    }

    public int getGates() {
        return gates.getValue();
    }
    
    public void advanceGates() {
        wall.decrease();
    }

    public int getSiegeTower() {
        return siegeTower.getValue();
    }
    
    public void advanceSiegeTower() {
        wall.decrease();
    }
    
    public int getTrebuchets() {
        return trebuchet.getValue();
    }
    
    public Boolean inCircleSpace(int trackop) {
        return inCircleSpace(getTrack(trackop));
    }
    
    public Boolean inCircleSpace(Track track) {
        return track.getValue() == 1;
    }
    
    
    public int checkCCA() {
        int enemiesInCCA = 0;
        if (wall.getValue() == 0) enemiesInCCA++;
        if (gates.getValue() == 0) enemiesInCCA++;
        if (siegeTower.getValue() == 0) enemiesInCCA++;
        
        return enemiesInCCA;
    }

    public void reduceTrebuchets() {
        trebuchet.decrease();
    }

    public void increaseTrebuchets() {
        trebuchet.increase();
    }
    
    public void removeSiegeTower() {
        siegeTower = null;
    }
}
