/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.events;

import java.util.ArrayList;
import pkg9cardsiege.logic.Game;

/**
 *
 * @author m0nk1w1
 */
public class Event {
    public int actionPointAllowance;
    
    public String name;
    public String description;
    
    public ArrayList<EnemyMovement> EnemyAdvancementOrders;

    public int getActionPointAllowance() {
        return actionPointAllowance;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public void apply(Game game) {}
    
    public void applyEnemyMovement(Game game) {
        EnemyAdvancementOrders.forEach((e) -> { e.apply(game); });
    }
}
