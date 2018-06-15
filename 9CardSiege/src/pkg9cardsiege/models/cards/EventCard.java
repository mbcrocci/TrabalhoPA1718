package pkg9cardsiege.models.cards;

import pkg9cardsiege.models.events.Event;


public class EventCard extends Card {
    private int number;
    
    private Event []days;
    
    public EventCard(int number, Event d1, Event d2, Event d3) {
        this.number = number;
        days = new Event[3];
        days[0] = d1;
        days[1] = d2;
        days[2] = d3;
    }
    
    public Event getEvent(int day) {
        return days[day];
    }
    
    public int getNumber() {
        return number;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("-------- EVENT CARD ---------").append("\n");
        
        for(Event e: days)
            sb.append(e);
        
        return sb.toString();
    }
}
