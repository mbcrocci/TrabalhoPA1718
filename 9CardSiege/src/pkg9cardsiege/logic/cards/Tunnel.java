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
public class Tunnel {
    private int position;
    // Positons:
    // CASTLE      = 0
    // TUNNEL1     = 1
    // TUNNEL2     = 2
    // EnemmyLines = 3
    
    public Tunnel() {
        this.position = 0;
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
    
    // This action can only be performed if there are ActionPoints to be used
    // This check should be performed before using this funciton
    public void exitTunnel() {
        position = 3;
    }  
    
    public Boolean inTunnel() {
        return (position == 1 || position == 2);
    }
}
