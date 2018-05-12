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
public class Tunnel extends Track {
    // Positons:
    // CASTLE      = 0
    // TUNNEL1     = 1
    // TUNNEL2     = 2
    // EnemmyLines = 3
    
    public Tunnel() {
        super("Tunnel", 4, 0);
    }
    
    public int getPosition() {
        return getValue();
    }
    
    public void clear() {
        setValue(0);
    
    }
    
    public void advance() {
        if (getValue() < 3)
            increase();
    }
    
    // Check if soldiers returned to the Castle must be made
    public void moveBack() {
        if (getValue() > 0)
            decrease();
    }
    
    // This action can only be performed if there are ActionPoints to be used
    // This check should be performed before using this funciton
    public void exitTunnel() {
        setValue(3);
    }  
    
    public Boolean inTunnel() {
        return (getValue() == 1 || getValue() == 2);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
