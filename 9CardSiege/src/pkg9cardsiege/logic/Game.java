/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic;

import java.util.ArrayList;
import java.util.Collections;

import pkg9cardsiege.logic.cards.Card;
import pkg9cardsiege.logic.cards.EnemyTrackCard;
import pkg9cardsiege.logic.cards.EventCard;
import pkg9cardsiege.logic.cards.StatusCard;
import pkg9cardsiege.logic.events.Event;


public class Game {
    private int day;
    
    private Dice dice;
    
    private StatusCard statusCard;
    private EnemyTrackCard enemyTrackCard;
    // card deck from where the player draws his cards
    private ArrayList<EventCard> deck;
    
    
    public Game() {
        this.dice = new Dice();
        this.statusCard = new StatusCard();
        this.enemyTrackCard = new EnemyTrackCard();
    }
    
    // TODO: make sure this should be here or in main function
    public void run() {
        // Enemy Line Check
        int roll = dice.roll();
        
        // capture procedure
        if (roll == 1) {
            // TODO
        }
        
        
        // Card Play Phase
        // TODO: change state do Draw
        EventCard card = draw();
        Event currentEvent = card.getEvent(day);
        
        // Event Phase
        currentEvent.apply(this);
        
        // Enemy Movement Phase
        currentEvent.applyEnemyMovement(this);
        
        // Player Actions
        
        // Victory or Loss Check Phase
        
        // End of Day Phase
    }
    
    // Returns true if any of the conditions to loose apply.
    // In that case the game should modify its state and end itself.
    public Boolean victoryLossCheck() {
        return enemyTrackCard.checkCCA() == 2
            || statusCard.getWallStrength() == 0
            || statusCard.getMorale() == 0
            || statusCard.getSupplies() == 0;
    }
    
    public void endDay() {
        
    }
    
    public EnemyTrackCard getEnemyTrackCard() {
        return enemyTrackCard;
    }
    
    public StatusCard getStatusCard() {
        return statusCard;
    }
    
    public Dice getDice() {
        return dice;
    }
    
    public void createDeck() {
        // make sure its empty
        deck.clear();
        
        // create and add to deck the 7 event cards
        //deck.add(new EventCard());
        
        // maybe not here, instead in game sequence
        shuffleDeck();
    }
    
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    private EventCard draw() {
        return deck.remove(0);
    }
}
