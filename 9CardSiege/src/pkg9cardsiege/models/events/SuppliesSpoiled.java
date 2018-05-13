package pkg9cardsiege.models.events;

import pkg9cardsiege.models.Game;

public class SuppliesSpoiled extends RegularEvent {
    
    public SuppliesSpoiled() {
        super("Supplies Spoiled",
                "Reduce supplies by 1\n",
                2,
                new RegularMovement(RegularMovement.WALL)
        );
    }

    @Override
    public void apply(Game game) {
        game.getStatusCard().decreaseSupplies();
    }
}
