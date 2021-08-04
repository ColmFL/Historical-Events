package HistoricalEvents;

import java.util.Scanner; 
import java.io.File;
import java.io.IOException;
import java.time.Year;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import HistoricalEvents.model.EventsContainer;
import HistoricalEvents.model.Events;
import HistoricalEvents.model.SubEvents;
import HistoricalEvents.model.Timeline;

public class Application {

	public static void main(String[] args) {
		
		ObjectMapper mapper1 = new ObjectMapper(); //Object mapper with readValue method and covered with a try and catch
		EventsContainer events = new EventsContainer();
		try {
			events = mapper1.readValue(new File("data.json"), EventsContainer.class);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Timeline tl = new Timeline (events);
	
		int menu = 0;
		Scanner console = new Scanner(System.in);
		
		System.out.println("Please press '1' to enter a year, press '2' to enter a range of years"
				+ ", press '3' for the full timeline of events, or press '4' to exit.");
				
		while (menu != 4) { //This while loop with 4 if statements will create a menu with 4 choices
			System.out.println();
		System.out.println("Enter selection: ");
		menu = console.nextInt();
		
		if (menu == 1) {
			System.out.print("Enter a year name: ");
			System.out.println(tl.getEventsYear(Year.of(console.nextInt())));
		}
		
		if (menu == 2) {
			System.out.println("Enter start year: ");
			int input = console.nextInt();
			System.out.println("Enter end year: ");
			int input2 = console.nextInt();
			System.out.println(tl.getEventsYears(Year.of(input) , Year.of(input2)));
		}
		
		if (menu == 3) {
				for (Events c : events.getEvents()) {
				System.out.println(c.getName());
				System.out.println(c.getType());
				System.out.println(c.getYear());
				for (SubEvents d : c.getSubEvents())
					System.out.println(" " + d.getName() + " " + d.getYear());	
			}
		}
		
		if (menu == 4) {
			System.out.println("||Goodbye||");
		}
		}	
		//Always close the scanner.
		console.close();
	}
}
