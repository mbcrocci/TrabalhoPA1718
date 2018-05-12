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

import pkg9cardsiege.logic.events.BadWeather;
import pkg9cardsiege.logic.events.BoilingOil;
import pkg9cardsiege.logic.events.Collapsed;
import pkg9cardsiege.logic.events.CoverOfDarkness;
import pkg9cardsiege.logic.events.DeathOfALeader;
import pkg9cardsiege.logic.events.DeterminedEnemy;
import pkg9cardsiege.logic.events.EnemyFatigue;
import pkg9cardsiege.logic.events.Faith;
import pkg9cardsiege.logic.events.FlamingArrows;
import pkg9cardsiege.logic.events.GateFortified;
import pkg9cardsiege.logic.events.GuardsDistracted;
import pkg9cardsiege.logic.events.Ilness;
import pkg9cardsiege.logic.events.IronShields;
import pkg9cardsiege.logic.events.Rally;
import pkg9cardsiege.logic.events.RepairedTrebuchet;
import pkg9cardsiege.logic.events.SuppliesSpoiled;
import pkg9cardsiege.logic.events.TrebuchetEvent;
import pkg9cardsiege.logic.events.VolleyOfArrows;


public class Game {
    private int day = 0;
    
    private int actionPoints = 0;
    
    private Boolean freeTunnelMov = false;
    private int trackChoice;
    
    private HashMap<DRM, Integer> drms;
    
    private Dice dice;
    
    private StatusCard statusCard;
    private EnemyTrackCard enemyTrackCard;
    // card deck from where the player draws his cards
    private ArrayList<EventCard> deck;
    private boolean raidAndSabotageOnlyTurn;
    
    
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
        
        deck = new ArrayList<>();
    }
    
    // Returns true if any of the conditions to loose apply.
    // In that case the game should modify its state and end itself.
    public Boolean victoryLossCheck() {
        return enemyTrackCard.checkCCA() == 2
            || statusCard.getWallStrength() == 0
            || statusCard.getMorale() == 0
            || statusCard.getSupplies() == 0;
    }
    
    public void setupTurn() {
        freeTunnelMov = true;
        clearDRMS();
        actionPoints = 0;
        
        // Enemy Line Check
        if (statusCard.getTunnel().getPosition() == 3) {
            int roll = dice.roll();
            if (roll == 1) {
                capture();
            }
        }
    }
    
    public void endDay() {
        createDeck();
        shuffleDeck();
        
        statusCard.decreaseSupplies();
        
        automaticMovement();
        
        day++;
    }
    
    public void clearDRMS() {
        drms.forEach((drm, value) -> drms.put(drm, 0));
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
    
    public int getDay() {
        return day;
    }
    
    public Dice getDice() {
        return dice;
    }
    
    public HashMap<DRM, Integer> getDRMS() {
        return drms;
    }
    
    public void createDeck() {
        // make sure its empty
        deck.clear();
        
        // create and add to deck the 7 event cards
        deck.add(new EventCard(
                1,
                new TrebuchetEvent(),
                new TrebuchetEvent(),
                new TrebuchetEvent()
        ));
        deck.add(new EventCard(
                2,
                new Ilness(),
                new GuardsDistracted(),
                new TrebuchetEvent()
        ));
        deck.add(new EventCard(
                3,
                new SuppliesSpoiled(),
                new BadWeather(),
                new BoilingOil()
        ));
        deck.add(new EventCard(
                4,
                new DeathOfALeader(),
                new GateFortified(),
                new FlamingArrows()
        ));
        deck.add(new EventCard(
                5,
                new VolleyOfArrows(),
                new Collapsed(),
                new RepairedTrebuchet()
        ));
        deck.add(new EventCard(
                6,
                new CoverOfDarkness(),
                new EnemyFatigue(),
                new Rally()
        ));
        deck.add(new EventCard(
                7,
                new DeterminedEnemy(),
                new IronShields(),
                new Faith()
        ));
    }
    
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }
    
    public Boolean isDeckEmpty() {
        return deck.isEmpty();
    }

    public EventCard drawCard() {
        return deck.remove(0);
    }
    
    public Boolean getFreeMov() {
        return freeTunnelMov;
    }
    
    public void setTrackChoice(int t) {
        trackChoice = t;
    }
    
    
    // TODO: finish
    public void aditionalAction(int option) {
        if (option == 0)
            statusCard.decreaseMorale();
        
        else if (option == 1)
            // TODO: check if its FortressSupplies instead
            statusCard.decreaseSupplies();     
    }
    
    public void capture() {
        statusCard.getTunnel().clear();
        statusCard.clearSupplies();
        statusCard.decreaseMorale();
    } 
    
    // Actions that operate with Tunnel
    public void enterTunnel() {
        if (statusCard.getTunnel().getPosition() == 0
            && useAP()) {
            statusCard.getTunnel().advance();
            freeTunnelMov = false;
        }
    }
    
    public void exitTunnel() {
        if (statusCard.getTunnel().getPosition() == 2)
            statusCard.getTunnel().advance();
        
        else if (statusCard.getTunnel().getPosition() == 1) {
            statusCard.getTunnel().moveBack();
            statusCard.addSupplies();
            statusCard.clearSupplies();
        }
    }
    
    public void advanceTunnel() {
        if (freeTunnelMov)
            statusCard.getTunnel().advance();
        
        else if (useAP())
            statusCard.getTunnel().advance();
    }
    
    public void moveBackTunnel() {
        if (freeTunnelMov)
            statusCard.getTunnel().moveBack();
        
        else if (useAP())
            statusCard.getTunnel().moveBack();
    }
    
    public void fastMovement() {
        if (statusCard.getTunnel().inTunnel() && useAP()) {
            statusCard.getTunnel().exitTunnel();
        }
    }
    
    private void automaticMovement() {
        int pos = statusCard.getTunnel().getPosition();
        if (pos == 1 || pos == 2) {
            statusCard.addSupplies();
            statusCard.clearSupplies();
            statusCard.getTunnel().clear();
            
        } else if (pos == 3) {
            capture();
        }
    }

    public void raidAndSabotageOnlyTurn() {
        raidAndSabotageOnlyTurn = true; 
    }

    public void removeSiegeTower() {
        enemyTrackCard.removeSiegeTower();
    }  

    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(statusCard.toString());
        sb.append(enemyTrackCard.toString());
        
        sb.append("Action Points: ").append(actionPoints).append("\n");

        return sb.toString();
    }
}
