/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9cardsiege.logic.cards;

import pkg9cardsiege.logic.events.Event;

/**
 *
 * @author m0nk1w1
 */
public class EventCard extends Card {
    private int number;
    
    private Event []days;
    
    public EventCard(int number, Event d1, Event d2, Event d3) {
        days = new Event[3];
        days[0] = d1;
        days[1] = d2;
        days[2] = d3;
    }
    
    public Event getEvent(int day) {
        return days[day];
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
