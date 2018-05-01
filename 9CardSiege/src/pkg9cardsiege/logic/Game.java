/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic;

import java.util.ArrayList;
import java.util.Collections;

import pkg9cardsiege.logic.cards.Card;
import pkg9cardsiege.logic.cards.EventCard;


public class Game {
    private Dice dice;
    private ArrayList<Card> deck;
    
    
    
    public void createDeck() {
        // make sure its empty
        deck.clear();
        
        // create and add to deck the 7 event cards
        deck.add(new EventCard());
        
        // maybe not here, instead in game sequence
        shuffleDeck();
    }
    
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }
}
