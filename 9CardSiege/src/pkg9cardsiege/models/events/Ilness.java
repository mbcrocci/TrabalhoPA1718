package pkg9cardsiege.models.events;

import pkg9cardsiege.models.Game;


public class Ilness extends RegularEvent {
    public Ilness() {
        super(
            "Ilness",
            "Reduce morale by 1\nReduce supplies by 1",
            2,
            new RegularMovement(RegularMovement.TREBUCHET)
        );
    }
    

    @Override
    public void apply(Game game) {
        game.getStatusCard().decreaseMorale();
        game.getStatusCard().decreaseSupplies();
    }    
}
