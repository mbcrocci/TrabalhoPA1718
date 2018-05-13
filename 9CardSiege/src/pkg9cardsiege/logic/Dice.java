package pkg9cardsiege.logic;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author m0nk1w1
 */
public class Dice implements Serializable {
    private Random numberGenerator;
    private final int max = 6;
    private final int min = 1;
    
    public Dice() {
        this.numberGenerator = new Random();
    }
    
    public int roll() {
        return numberGenerator.nextInt((max - min) + 1) + min;
    }
    
}
