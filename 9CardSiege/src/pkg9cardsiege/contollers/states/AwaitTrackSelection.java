package pkg9cardsiege.contollers.states;

import pkg9cardsiege.models.Game;

public class AwaitTrackSelection extends StateAdapter {
    
    public AwaitTrackSelection(Game game) {
        super(game);
    }
    
    
    @Override
    public IState selectTrack(int track) {
        getGame().setTrackChoice(track);
        
        return new AwaitActionChoice(getGame());
    }
}
