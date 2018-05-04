/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.cards;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author m0nk1w1
 */
public class StatusCardTest {
    StatusCard status;
    
    public StatusCardTest() {
        status = new StatusCard();
    }


    @Test
    public void testIncreaseWall() {
        System.out.println("increaseWall");
        status.increaseWall();
        assertEquals(2, status.getWallStrength());
    }

    @Test
    public void testIncreaseMorale() {
        System.out.println("increaseMorale");
        status.increaseMorale();
        assertEquals(2, status.getMorale());
    }

    @Test
    public void testIncreaseSupplies() {
        System.out.println("increaseSupplies");
        status.increaseFortressSupplies();
        assertEquals(2, status.getFortressSupplies());
    }

    @Test
    public void testDecreaseWall() {
        System.out.println("decreaseWall");
        status.decreaseWall();
        assertEquals(0, status.getWallStrength());
    }

    @Test
    public void testDecreaseMorale() {
        System.out.println("decreaseMorale");
        status.decreaseMorale();
        assertEquals(0, status.getMorale());
    }

    @Test
    public void testDecreaseSupplies() {
        System.out.println("decreaseSupplies");
        status.decreaseFortressSupplies();
        assertEquals(0, status.getFortressSupplies());
    }
    
}
