package pkg9cardsiege;

import pkg9cardsiege.contollers.GameState;
import pkg9cardsiege.ui.gui.GameFrame;
import pkg9cardsiege.ui.text.TextUserInterface;


public class Main {

    public static void main(String[] args) {
        TextUserInterface textui = new TextUserInterface(new GameState());
        //textui.run();
        
        new GameFrame(new GameState());
    }
    
}
