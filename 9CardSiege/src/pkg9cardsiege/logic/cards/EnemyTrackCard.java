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
    
    public EnemyTrackCard() {
        super();
        
        wall = new Track(4, 4);
        gates = new Track(4, 4);
        siegeTower = new Track(4, 4);
        
        trebuchet = new Track(3, 0);
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
}
