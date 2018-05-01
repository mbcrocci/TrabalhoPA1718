/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic;

import java.util.Random;

/**
 *
 * @author m0nk1w1
 */
public class Dice {
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
