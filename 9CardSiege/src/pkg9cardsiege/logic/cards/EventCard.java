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
    
    private Event []events;
    
    public EventCard(int number, Event e1, Event e2, Event e3) {
        events = new Event[3];
        events[0] = e1;
        events[1] = e2;
        events[2] = e3;
    }
    
    public Event getEvent(int day) {
        return events[day-1];
    }
}
