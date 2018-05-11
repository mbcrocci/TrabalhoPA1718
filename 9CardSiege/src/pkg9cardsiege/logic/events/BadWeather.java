/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.events;

import pkg9cardsiege.logic.Game;

/**
 *
 * @author mbcro
 */
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
