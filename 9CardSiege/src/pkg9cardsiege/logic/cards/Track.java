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
public class Track {
    private int size;
    private int value;
    
    public Track(int size, int startValue) {
        this.size = size;
        this.value = startValue;
    }

    public int getValue() {
        return value;
    }
    
    public void increase() {
        if (value < size)
            value++;
    }
    
    public void decrease() {
        if (value > 0)
            value--;
    }
}
