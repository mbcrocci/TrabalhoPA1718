package pkg9cardsiege.models.events;

import pkg9cardsiege.models.Game;


public class NoEnemyMovement extends EnemyMovement {

    @Override
    public void apply(Game game) {
        // does nothing
    }
}
