package pkg9cardsiege.models.cards;

import java.io.Serializable;


public class Track implements Serializable {
    private String name;
    private int size;
    private int value;
    private int strength;
    
    public Track(String name, int size, int startValue) {
        this.name = name;
        this.size = size;
        this.value = startValue;
        this.strength = 0;
    }
    
    public Track(String name, int size, int startValue, int strength) {
        this.name = name;
        this.size = size;
        this.value = startValue;
        this.strength = strength;
    }
    
    public String getName() {
        return name;
    }
    
    public int getSize() {
        return size;
    }

    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(name);
        
        if (strength > 0)
            sb.append(" (").append(strength).append(")");   
        
        sb.append(": ");
        
        for (int i = 0; i < size; i++)
            sb.append("[").append( (i == value)? "X": i ).append("] ");
        
        
        return sb.toString();
    }
}
