package pkg9cardsiege.models.cards;


public class EnemyTrackCard extends Card {
    
    private Track wall;
    private Track gates;
    private Track siegeTower;
    
    private Track trebuchet;
    
    //private Integer enemiesInCCA;
    
    public EnemyTrackCard() {
        super();
        
        wall = new Track("Wall", 5, 4, 2);
        gates = new Track("Gates", 5, 4, 3);
        siegeTower = new Track("Siege Tower", 5, 4, 4);
        
        trebuchet = new TrebuchetCount();
    }
    
    public Track getTrack(int n) {
        switch (n) {
            case 0: return wall;
            case 1: return gates;
            case 2: return siegeTower;
        }
        
        return null;
    }

    public int getWall() {
        return wall.getValue();
    }
    
    public void advanceWall() {
        wall.decrease();
    }

    public int getGates() {
        return gates.getValue();
    }
    
    public void advanceGates() {
        gates.decrease();
    }

    public int getSiegeTower() {
        return siegeTower.getValue();
    }
    
    public void advanceSiegeTower() {
        siegeTower.decrease();
    }
    
    public int getTrebuchets() {
        return trebuchet.getValue();
    }
    
    public Boolean inCircleSpace(int trackop) {
        return inCircleSpace(getTrack(trackop));
    }
    
    public Boolean inCircleSpace(Track track) {
        return track.getValue() == 1;
    }
    
    
    public int checkCCA() {
        int enemiesInCCA = 0;
        if (wall.getValue() == 0) enemiesInCCA++;
        if (gates.getValue() == 0) enemiesInCCA++;
        if (siegeTower.getValue() == 0) enemiesInCCA++;
        
        return enemiesInCCA;
    }

    public void reduceTrebuchets() {
        trebuchet.decrease();
    }

    public void increaseTrebuchets() {
        trebuchet.increase();
    }
    
    public void removeSiegeTower() {
        siegeTower = null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n-------ENEMY TRACK CARD------\n");
        sb.append(wall.toString()).append("\n");
        sb.append(gates.toString()).append("\n");
        sb.append(siegeTower.toString()).append("\n");
        sb.append(trebuchet.toString()).append("\n");
        
        sb.append("-----------------------------\n");

        return sb.toString();
    }
}
