package pkg9cardsiege.models.events;

import pkg9cardsiege.models.Game;


public class Collapsed extends RegularEvent {
    public Collapsed() {
        super(
                "Collapsed!",
                "Siege Tower Removed from game if on starting space",
                2,
                new RegularMovement(RegularMovement.WALL),
                new RegularMovement(RegularMovement.GATES)
        );
    }

    @Override
    public void apply(Game game) {
        game.removeSiegeTower();
    }    
}
