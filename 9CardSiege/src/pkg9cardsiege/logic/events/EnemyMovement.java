package pkg9cardsiege.logic.events;

import java.io.Serializable;
import pkg9cardsiege.logic.Game;


public abstract class EnemyMovement implements Serializable {
    public abstract void apply(Game game);
}
