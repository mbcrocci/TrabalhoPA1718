package pkg9cardsiege.models.events;

import pkg9cardsiege.models.Game;


public class BadWeather extends RegularEvent {
    public BadWeather() {
        super(
                "Bad Weather",
                "Only raid and sabotage action allowed this turn",
                2,
                new NoEnemyMovement()
        );
    }

    @Override
    public void apply(Game game) {
        game.raidAndSabotageOnlyTurn();
    }
}
