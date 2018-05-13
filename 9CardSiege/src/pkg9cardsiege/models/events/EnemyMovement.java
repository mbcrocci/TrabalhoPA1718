package pkg9cardsiege.models.events;

import java.io.Serializable;
import pkg9cardsiege.models.Game;


public abstract class EnemyMovement implements Serializable {
    public abstract void apply(Game game);
}
