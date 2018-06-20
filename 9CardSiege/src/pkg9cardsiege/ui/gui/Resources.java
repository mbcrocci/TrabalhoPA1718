package pkg9cardsiege.ui.gui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import pkg9cardsiege.contollers.GameState;


public class Resources {
    public static final URL getResourceFile(String name) {
        URL url = Resources.class.getResource(name);
        return url;
    }
    
    public void saveGameToFile(String filename, GameState gameState) throws IOException {
        ObjectOutputStream oout = null;
        
        try {
            oout = new ObjectOutputStream(new FileOutputStream(filename));
            
            oout.writeObject(gameState);
            
        } finally {
            if (oout != null)
                oout.close();
        }
    }
    
    public GameState getGameFromFile (String filename) throws IOException, ClassNotFoundException {
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
    
    
}
