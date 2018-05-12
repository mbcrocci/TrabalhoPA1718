package pkg9cardsiege.ui.text;

import java.util.Scanner;
import pkg9cardsiege.logic.GameState;
import pkg9cardsiege.logic.states.AwaitActionChoice;
import pkg9cardsiege.logic.states.AwaitDraw;
import pkg9cardsiege.logic.states.AwaitStart;
import pkg9cardsiege.logic.states.AwaitTrackSelection;
import pkg9cardsiege.logic.states.AwaitTunnelMovChoice;
import pkg9cardsiege.logic.states.GameOver;

public class TextUserInterface {
    private GameState gameState;
    private Scanner scanner;
    
    private Boolean trackSelected = false;
    
    public TextUserInterface(GameState gameState) {
        this.gameState = gameState;
        this.scanner = new Scanner(System.in);
    }
    
    public void showGame() {
        System.out.println(gameState);
    }
    
    public void run() {
        while (!(gameState.getState() instanceof GameOver)) {
            
            if (gameState.getMessages().size() > 0) {
                System.out.println("");
                
                gameState.getMessages().forEach((msg) -> {
                    System.out.println("--> " + msg);
                });
                
                gameState.clearMessages();
            }
            
            System.out.println(gameState.toString());
            
            if (gameState.getState() instanceof AwaitStart)
                getUserInputWhileAwaitingStart();
            
            else if(gameState.getState() instanceof AwaitDraw)
                getUserInputWhileAwaitingDraw();
            
            else if(gameState.getState() instanceof AwaitActionChoice)
                getUserInputWhileAwaitingActionChoice();
            
            else if (gameState.getState() instanceof AwaitTunnelMovChoice)
                getUserInputWhileTunnelMovementChoice();
            
            else if (gameState.getState() instanceof AwaitTrackSelection)
                getUserInputWhileAwaitngTrackSelection();
        }
    }
    
    private void getUserInputWhileAwaitingDraw() {
        System.out.println("Press any key to draw card!");
        System.out.println(">> ");
        
        scanner.nextLine();
        
        gameState.draw();
    }
    
    private void getUserInputWhileAwaitingStart() {
        int value;
        
        System.out.println("1 - Start Game");
        System.out.println("2 - Load Game");
        
        System.out.println(">> ");
        
        while(!scanner.hasNextInt()) 
            scanner.next();
        
        value = scanner.nextInt();
        
        System.out.println("DEBUG: value = " + value);
        
        switch (value) {
            case 1: gameState.start();
            //case 2: gameState.resume();
        }
    }
    
    private void getUserInputWhileAwaitingActionChoice() {
        int value;
                
        System.out.println("1 - Archers Attack");
        System.out.println("2 - Boiling Water Attack");
        System.out.println("3 - Close Combat Attack");
        System.out.println("4 - Coupure");
        System.out.println("5 - Rally Troops");
        System.out.println("6 - Tunnel Movement");
        System.out.println("7 - Supply Raid");
        System.out.println("8 - Sabotage");
        System.out.println("9 - Additional Action");
        System.out.println("10 - End Turn");
        System.out.println("0 - Save Game");
        System.out.println(">> ");
        
        while (!scanner.hasNextInt())
            scanner.next();
        
        value = scanner.nextInt();
        
        if (value == 1 || value == 2)
            if (!trackSelected) {
                gameState.setState(new AwaitTrackSelection(gameState.getGame()));
                return;
            }

        switch (value) {
            case 1:
                gameState.archersAttack();
                break;
            case 2:
                gameState.boilingWaterAttack();
                break;
            case 3:
                gameState.closeCombat();
                break;
            case 4:
                gameState.coupure();
                break;
            case 5:
                gameState.rallyTroops(applyDRM());
                break;
            case 6:
                gameState.tunnelMovement();
                break;
            case 7:
                gameState.supplyRaid();
                break;
            case 8:
                gameState.sabotage();
                break;
            case 9:
                gameState.additionalAction();
                break;
            case 10:
                gameState.endTurn();
                break;
            case 0:
                gameState.save();
                break;
        } 
        
        // if it reached here it already performed the attack
        // so, we can reset track selection
        trackSelected = false;
    }
    
    private Boolean applyDRM() {
        System.out.println("Do you wish to spend 1 supply to applay +1 DRM in moralle roll?");
        System.out.println(">> ");
        
        while (!scanner.hasNextLine())
            scanner.next();
        
        String s = scanner.nextLine();
        return s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("S");
    }
    
    private void getUserInputWhileAwaitngTrackSelection() {
        int value;
        
        System.out.println("1 - Wall");
        System.out.println("2 - Gates");
        System.out.println("3 - Trebuchets");
        System.out.println(">> ");
        
        while (!scanner.hasNextInt())
            scanner.next();
        
        value = scanner.nextInt();
        
        gameState.selectTrack(value);
    }
    
    private void getUserInputWhileTunnelMovementChoice() {
        int value;
        
        System.out.println("1 - Enter Tunnel (1 AP)");
        System.out.println("2 - Exit Tunnel (free)");
        System.out.println("3 - Advance (free or 1 AP)");
        System.out.println("4 - Move Back (free or 1 AP)");
        System.out.println("5 - FastMovement (1 AP)");
        System.out.println(">> ");
        
        while (!scanner.hasNextInt())
            scanner.next();
        
        value = scanner.nextInt();
        
        switch(value) {
            case 1:
                gameState.enterTunnel();
                break;
            case 2:
                gameState.exitTunnel();
                break;
            case 3:
                gameState.advanceTunnel();
                break;
            case 4:
                gameState.moveBackTunnel();
                break;
            case 5:
                gameState.fastMovement();
                break;
        }
    }
}
