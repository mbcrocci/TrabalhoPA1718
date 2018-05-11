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
    private int strength;
    
    public Track(int size, int startValue) {
        this.size = size;
        this.value = startValue;
        this.strength = 0;
    }
    
    public Track(int size, int startValue, int strength) {
        this.size = size;
        this.value = startValue;
        this.strength = strength;
    }

    public int getValue() {
        return value;
    }
    
    public int getStrength() {
        return strength;
    }
        
    public void increase() {
        if (value < size)
            value++;
    }
    
    public void increase(int n) {
        for (int i = 0; i < n; i++)
            increase();
    }
    
    public void decrease() {
        if (value > 0)
            value--;
    }
}
