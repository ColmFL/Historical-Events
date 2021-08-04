package HistoricalEvents.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

//EventsContainer is in the Singleton pattern.
public class EventsContainer {
	
	private static EventsContainer me; //Only instance of EventsContainer which can exist.
	
	private ArrayList <Events> events;  //ArrayList holding type Events

	//Only default constructor can be called.
	public EventsContainer() {
		this.events = new ArrayList<Events>();
	}
	
	public static EventsContainer getInstance() {
		if (me == null) me = new EventsContainer();
		return me;
		}
	
	//Wrapped in order to discourage modification.
	public void add(Events events) {
		this.events.add(events);
		}

	//Outright prevents modification. 
	public Collection<Events> getEvents() {
		return Collections.unmodifiableCollection(this.events);
	}

	public void setEvents(ArrayList<Events> events) {
		this.events = events;
	}
}
