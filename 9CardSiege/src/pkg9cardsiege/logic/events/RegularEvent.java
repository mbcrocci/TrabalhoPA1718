package pkg9cardsiege.logic.events;

import java.util.ArrayList;
import java.util.Arrays;


public class RegularEvent extends Event {

    public RegularEvent(String name, String description, int actionPoints,
                        EnemyMovement ...ems) {
        this.name = name;
        this.description = description;
        this.actionPointAllowance = actionPoints;
        
        this.enemyAdvancementOrders = new ArrayList<>();
        this.enemyAdvancementOrders.addAll(Arrays.asList(ems));
    }
}
