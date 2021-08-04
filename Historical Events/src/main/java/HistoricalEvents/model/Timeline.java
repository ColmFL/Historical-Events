package HistoricalEvents.model;

import java.time.Year;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Timeline implements Comparable<Events> { //Implements Comparble to allow comparison of Event objects
	
	private TreeMap <Year, TreeSet<Events>> tl= new TreeMap<Year, TreeSet<Events>>(); //TreeSet and TreeMap which create the timeline
	//Year and events are the keys
	
	//Constructor which takes in the type EventsContainer.
	public Timeline(EventsContainer event) {		
		
		for(Events event1 : event.getEvents()) {
			if(tl.containsKey(event1.getYear())){
				TreeSet<Events> evs = tl.get(event1.getYear());
				evs.add(event1);
				tl.put(event1.getYear(), evs);
			}
			else {
				TreeSet<Events> evs = new TreeSet<Events>();
				evs.add(event1);
				tl.put(event1.getYear(), evs);
			}	
		}
	}

	//Implements the inherited method from Comparable interface.
	public int compareTo(Events o) {
		return 0;
	}

	public TreeSet<Events> getEventsYear(Year of) { //Used for option 1 of menu.
		return tl.get(of);
	}
	
	public SortedMap<Year, TreeSet<Events>> getEventsYears(Year of1, Year of) { //Used for option 2 of menu.
		return tl.subMap(of1, of);
	}
}
	
