// team - remote - pull to upstream -> comecar
// team - add -> adicionar ficheiros
// commit-> marcar ponto/guardar versao nova
// team - remote - push to upstream -> enviar mudancas

package pkg9cardsiege;

import pkg9cardsiege.logic.GameState;
import pkg9cardsiege.ui.text.TextUserInterface;

public class Main {

    public static void main(String[] args) {
        TextUserInterface textui = new TextUserInterface(new GameState());
        textui.run();
    }
    
}
