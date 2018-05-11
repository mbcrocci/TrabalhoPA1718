/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import pkg9cardsiege.logic.cards.EnemyTrackCard;
import pkg9cardsiege.logic.cards.EventCard;
import pkg9cardsiege.logic.cards.StatusCard;
import pkg9cardsiege.logic.cards.Track;
import pkg9cardsiege.logic.events.Event;


public class Game {
    private int day;
    
    private int actionPoints = 0;
    
    private HashMap<DRM, Integer> drms;
    
    private Dice dice;
    
    private StatusCard statusCard;
    private EnemyTrackCard enemyTrackCard;
    // card deck from where the player draws his cards
    private ArrayList<EventCard> deck;
    
    
    public Game() {
        this.dice = new Dice();
        this.statusCard = new StatusCard();
        this.enemyTrackCard = new EnemyTrackCard();
        
        // create drms' hashmap and fill it
        drms = new HashMap();
        drms.put(DRM.SABOTAGE_ACT, 0);
        drms.put(DRM.MORALE_ACT, 0);
        drms.put(DRM.COUPURE_ACT, 0);
        drms.put(DRM.RAID_ACT, 0);
        drms.put(DRM.BATTERY_RAM_ATK, 0);
        drms.put(DRM.SIEGE_TOWER_ATK, 0);
        drms.put(DRM.SIEGE_ENGINE_ATK, 0);
        drms.put(DRM.CLOSE_COMBAT_ATK, 0);
        drms.put(DRM.CIRLCE_SPACES_ATK, 0);
        
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
        
        // add action points
        addAP(currentEvent.getActionPointAllowance());
        
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
        createDeck();
        shuffleDeck();
        
        statusCard.decreaseSupplies();
        
        int soldierPosition = statusCard.getTunnel().getPosition();
        if (soldierPosition == 1 || soldierPosition == 2)
            statusCard.getTunnel().automaticMovement();
    }
    
    public EnemyTrackCard getEnemyTrackCard() {
        return enemyTrackCard;
    }
    
    public StatusCard getStatusCard() {
        return statusCard;
    }
    
    public int getAP() {
        return actionPoints;
    }
    
    public void addAP() {
        actionPoints++;
    }
    
    public void addAP(int n) {
        actionPoints += n;
    }
    
    // When used in conjuction with other checks, should be used last
    public Boolean useAP() {
        if (actionPoints > 0) {
            actionPoints--;
            return true;
        }
        
        return false;
    }
    
    public Boolean useAP(int n) {
        if (actionPoints - n >= 0) {
            actionPoints -= n;
            return true;
        }
        
        return false;
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
    
    // ACTIONS
    
    public void capture() {
        statusCard.getTunnel().clear();
        // TODO: raided supplies
        statusCard.decreaseMorale();
    }
    
    // Attacks
    public void archersAttack() {
        // choose track to attack
        int trackOption = 0; // TODO: actually get a choice
        Track track = enemyTrackCard.getTrack(trackOption);

        // roll
        int roll = dice.roll();
        
        // apply drm
        switch(trackOption) {
            //case 0: roll += drms.get(null); break;
            case 1: roll += drms.get(DRM.BATTERY_RAM_ATK); break;
            case 2: roll += drms.get(DRM.SIEGE_TOWER_ATK); break;
        }
        
        
        // check if track is on circle space so we can apply circle space drm
        if (enemyTrackCard.inCircleSpace(track))
            roll += drms.get(DRM.CIRLCE_SPACES_ATK);
        
        // if roll bigger that trackStrength
        if (roll > track.getStrength())
            track.decrease();
            
        // if roll equal or less it does nothing
    }
    
    public void boilingWaterAttack() {
        int trackOption = 0;// choose track to attack
        Track track = enemyTrackCard.getTrack(trackOption);
        
        if (!enemyTrackCard.inCircleSpace(track))
            return;
        
        int roll = dice.roll();
        
        switch(trackOption) {
            case 1: roll += drms.get(DRM.BATTERY_RAM_ATK); break;
            case 2: roll += drms.get(DRM.SIEGE_TOWER_ATK); break;
        }
        
        if (enemyTrackCard.inCircleSpace(track))
            roll += drms.get(DRM.CIRLCE_SPACES_ATK);
        
        // check if roll with drm is 1. if so it fails
        if (roll == 1) return;
        
        // apply automatic drm
        roll++;
        
        if (roll > track.getStrength())
            track.decrease();
    }
    
    // 
    public void closeCombat() {
        ArrayList<Track> tracks = new ArrayList<>();
        
        if (enemyTrackCard.getGates() == 0)
            tracks.add(enemyTrackCard.getTrack(0));
        
        if (enemyTrackCard.getGates() == 0)
            tracks.add(enemyTrackCard.getTrack(1));
        
        if (enemyTrackCard.getSiegeTower() == 0)
            tracks.add(enemyTrackCard.getTrack(2));
        
        
        // make a roll for each track beacause
        // if it was 1 against 2 combined
        // tracks, you wouldnt be able to win.
        // (max roll + drm = 7 vs CCAStrength = 8)
        for (Track track: tracks) {
            int roll = dice.roll();
        
            if (roll == 1)
                statusCard.decreaseMorale();
        
            roll += drms.get(DRM.CLOSE_COMBAT_ATK);
        
            if (roll > track.getStrength())
                track.decrease();
        }
    }
    
    public void coupure() {
        int roll = dice.roll() + drms.get(DRM.COUPURE_ACT);
        
        if (roll > 4)
            statusCard.increaseWall();
    }
    
    public void rallyTroops() {
        int roll = dice.roll() + drms.get(DRM.MORALE_ACT);
        
        if (roll > 4)
            statusCard.increaseMorale();
        
        // TODO: roll to get morale drm and spend supplies
    }
    
    
    
    // Actions that operate with Tunnel
    
    public void enterTunnel() {
        if (statusCard.getTunnel().getPosition() == 0
            && useAP())
            statusCard.getTunnel().advance();
    }
    
    public void fastMovement() {
        if (useAP()) {
            statusCard.getTunnel().fastMovement();
        }
    }
    
    public void supplyRaid() {
        if (statusCard.getSupplies() == 2)
            return;
        
        // if soldiers are not on enemy lines, return
        if (statusCard.getTunnel().getPosition() != 3)
            return;
        
        int roll = dice.roll();
        
        if (roll == 6) {
            // raid 2 supplies
        } else if (2 < roll && roll < 6) {
            // raid 1 supply
        } else if (roll == 1) {
            // capture
        }
    }
    
    public void sabotage() {
        // if no unit on Enemy Lines
        if (statusCard.getTunnel().getPosition() != 3)
            return;
        
        int roll = dice.roll() + drms.get(DRM.SABOTAGE_ACT);
        
        if (roll == 1)
            // capture
            
        
        else if (roll > 4)
            enemyTrackCard.reduceTrebuchets();
        
    }
}
