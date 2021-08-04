package HistoricalEvents.model;

import java.time.Year;
import java.util.ArrayList; //Imports for Year and ArrayList

public class Events implements Comparable<Events> { //Implements the Comparable interface.
	
	//ArrayList to contain SubEvents objects.
	private ArrayList <SubEvents> subevents = new ArrayList<SubEvents>();
	
	private String type;
	private String name;
	private Year year;
	
	public Events() {	
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public int compareTo(Events o) {
		return 0;
	}

	public ArrayList <SubEvents> getSubEvents() {
		return subevents;
	}
	
	public void setSubevents(ArrayList <SubEvents> subevents){
		this.subevents = subevents;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Year getYear() {
		return year;
	}
	
	public void setYear(Year year) {
		this.year = year;
	}
	
	public String toString() { //Used to render the output in a human friendly format.
		return name + " " + type + " " + year;
	}
}
