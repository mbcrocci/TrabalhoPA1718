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
 * @author mbcro
 */
public class Event {
    protected String name;
    protected String description;
    protected int actionPointAllowance;

    protected ArrayList<EnemyMovement> enemyAdvancementOrders;

    public int getActionPointAllowance() {
        return actionPointAllowance;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public ArrayList<EnemyMovement> getEnemyMovements() {
        return enemyAdvancementOrders;
    }
    
    public void apply(Game game) {}
    
    public void applyEnemyMovement(Game game) {
        enemyAdvancementOrders.forEach((e) -> { e.apply(game); });
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb  .append("----- ")
            .append(name).append(": ")
            .append(actionPointAllowance)
            .append(" -----").append("\n")
            .append(description).append("\n");
        
        return sb.toString();
    }
}
