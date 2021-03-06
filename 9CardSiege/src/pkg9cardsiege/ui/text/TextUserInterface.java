package pkg9cardsiege.ui.text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.contollers.states.AwaitActionChoice;
import pkg9cardsiege.contollers.states.AwaitAdditionalActionChoice;
import pkg9cardsiege.contollers.states.AwaitRallyTroops;
import pkg9cardsiege.contollers.states.AwaitDraw;
import pkg9cardsiege.contollers.states.AwaitStart;
import pkg9cardsiege.contollers.states.AwaitTrackSelection;
import pkg9cardsiege.contollers.states.AwaitTunnelMovChoice;
import pkg9cardsiege.contollers.states.GameOver;

public class TextUserInterface {
    private GameState gameState;
    private Scanner scanner;
    
    private static final String FILENAME = "savedgame";
    
    public TextUserInterface(GameState gameState) {
        this.gameState = gameState;
        this.scanner = new Scanner(System.in);
    }
    
    private void saveGameToFile(String filename) throws IOException {
        ObjectOutputStream oout = null;
        
        try {
            oout = new ObjectOutputStream(new FileOutputStream(filename));
            
            oout.writeObject(gameState);
            
        } finally {
            if (oout != null)
                oout.close();   
        }
    }
    
    private GameState getGameFromFile (String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream oin = null;
        GameState gs = null;
        
        try  {
            oin = new ObjectInputStream(new FileInputStream(filename));
            
            gs = (GameState) oin.readObject();
            
        } finally {
            if (oin != null)
                oin.close();
        }
        
        return gs;  
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
            
            else if (gameState.getState() instanceof AwaitAdditionalActionChoice)
                getUserInputWhileAwaitingAdditionalChoice();
            
            else if (gameState.getState() instanceof AwaitRallyTroops)
                getUserInputWhileAwaitingApplyDRM();
        }
    }
    
    private void getUserInputWhileAwaitingDraw() {
        System.out.println("Press any number to draw card!");
        System.out.println(">> ");
        
        while(!scanner.hasNextInt())
            scanner.next();
        
        int i = scanner.nextInt(); // unused; its just to lock
        
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
        
        switch (value) {
            case 1: gameState.start(); break;
            case 2:
                GameState newGS = null;
                try {
                    newGS = getGameFromFile(FILENAME);
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Couldn't load game.");

                } finally {
                    if (newGS != null)
                        gameState = newGS;
                }
                break;
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
                gameState.rallyTroops();
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
                try {
                    saveGameToFile(FILENAME);
                } catch (IOException e) {
                    System.out.println("Couldn't save game.");

                }
                break;
        } 
    }
    
    private void getUserInputWhileAwaitingAdditionalChoice() {
        System.out.println("Do you wish to spend 1 morale or 1 supply?");
        System.out.println("1 - morale");
        System.out.println("2 - supply");
        System.out.println(">> ");
        
        while (!scanner.hasNextInt())
            scanner.next();
        
        int op = scanner.nextInt();
        
        gameState.additionalAction(op);
    }
    
    private void getUserInputWhileAwaitingApplyDRM() {
        System.out.println("Do you wish to spend 1 supply to applay +1 DRM in moralle roll?");
        System.out.println(">> ");
        
        while (!scanner.hasNextLine())
            scanner.next();
        
        String s = scanner.nextLine();
        gameState.rallyTroops(
            s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("S")
        );
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
