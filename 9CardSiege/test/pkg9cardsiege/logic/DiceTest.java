/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic;

import pkg9cardsiege.models.Dice;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class DiceTest {
    
    public DiceTest() {
    }
    
    /**
     * Test of roll method, of class Dice.
     * 
     * Tests if numbers are generated between 1 and 6 (including)
     * by generating 20 numbers and checking if they are inside bounds.
     */
    @Test
    public void testRoll() {
        System.out.println("Testing roll");
        
        Dice dice = new Dice();
        ArrayList<Integer> generatedNumbers = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            generatedNumbers.add( dice.roll() );
        }
        
        int numbersOutsideBounds = 0;
        
        for (int i : generatedNumbers)
            if (i < 1 || i > 6)
                numbersOutsideBounds++;
        
        // If numbers are generated correctly there should not be any numbersOutsideBounds
        assertEquals(numbersOutsideBounds, 0);
    }
    
}
