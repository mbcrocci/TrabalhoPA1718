/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.cards;

import java.util.Arrays;
import pkg9cardsiege.logic.Game;
import pkg9cardsiege.logic.Soldier;

/**
 *
 * @author m0nk1w1
 */
public class Tunnel {
    private Soldier soldiers;
    private int position;
    // Positons:
    // CASTLE      = 0
    // TUNNEL1     = 1
    // TUNNEL2     = 2
    // EnemmyLines = 3
    
    private int freeMov;
    
    public Tunnel() {
        this.soldiers = new Soldier();
        this.position = 0;
        this.freeMov = 1;
    }
    
    public int getPosition() {
        return position;
    }
    
    public void clear() {
        position = 0;
    
    }
    
    public void advance() {
        if (position < 3)
            position++;
    }
    
    // Check if soldiers returned to the Castle must be made
    public void moveBack() {
        if (position > 0)
            position--;
    }
    
    public void freeMovement() {
        if (freeMov > 0) {
            advance();
            freeMov = 0;
        }
    }
    
    // This action can only be performed if there are ActionPoints to be used
    // This check should be performed before using this funciton
    public void fastMovement() {
           if (position == 1) {
               position = 2;
               
           } else {
               position = 3;
           }        
    }
    
    public void automaticMovement() {
        if (position == 1 || position == 2)
            position = 0;
        
        else if (position == 3)
            // TODO: call capture procedure
            ;
    }    
}
