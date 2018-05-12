/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.cards;

/**
 *
 * @author mbcro
 */
public class TrebuchetCount extends Track{
    
    public TrebuchetCount() {
        super("Trebuchets", 3, 2);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(getName());
        
        if (getStrength() > 0)
            sb.append(" (").append(getStrength()).append(")");   
        
        sb.append(": ");
        
        for (int i = 0; i < getSize(); i++)
            sb.append("[").append( (i == getValue())? "X": i+1 ).append("] ");
        
        
        return sb.toString();
    }
}
