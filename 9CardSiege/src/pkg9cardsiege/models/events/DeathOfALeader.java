package pkg9cardsiege.models.events;

import pkg9cardsiege.models.Game;


public class DeathOfALeader extends RegularEvent {
    public DeathOfALeader () {
        super(
                "Death of a Leader",
                "Reduce morale by 1",
                2,
                new RegularMovement(RegularMovement.WALL),
                new RegularMovement(RegularMovement.TREBUCHET)
        );
    }

    @Override
    public void apply(Game game) {
        game.getStatusCard().decreaseMorale();
    }
}
