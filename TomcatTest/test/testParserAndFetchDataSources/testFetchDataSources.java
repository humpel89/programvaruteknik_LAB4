package testParserAndFetchDataSources;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import dataSources.FootballArena;
import dataSources.FootballGoalsSource;
import dataSources.TemperatureSource;

public class testFetchDataSources {
	FootballGoalsSource goalSource;
	TemperatureSource temperatureSource;
	Map<LocalDate, Double> gamesAtStromvallen;
	
	@Before
	public void setUp() throws Exception {
		goalSource = new FootballGoalsSource();
		temperatureSource = new TemperatureSource();
		gamesAtStromvallen = goalSource.getData();
	}

	@Test
	public void testFetchFootballGoals() {
		assertEquals("Antal mål per matchdag i fotbollsallsvenskan", goalSource.getName());
		assertEquals("Antal mål", goalSource.getUnit());
	}

	@Test
	public void testFetchTemperatureData() {
		temperatureSource.getData();
		assertEquals("Celsius", temperatureSource.getUnit());
	}

	@Test
	public void testFootballGoalsEqualsData() {
		System.out.println(gamesAtStromvallen);
		assertEquals(14, gamesAtStromvallen.size());	
		
		goalSource.setArenaToCheck(FootballArena.NYAPARKEN);
		System.out.println(goalSource.getData());
		assertEquals(15, goalSource.getData().size());	
	}
	@Test
	public void testGameDatesVsExpectedScore(){
		assertEquals("3.0",(gamesAtStromvallen.get(LocalDate.of(2014, 4, 6))).toString());
		assertEquals("1.0",(gamesAtStromvallen.get(LocalDate.of(2014, 5, 11))).toString());
		assertEquals("0.0",(gamesAtStromvallen.get(LocalDate.of(2014, 8, 16))).toString());
		assertEquals("4.0",(gamesAtStromvallen.get(LocalDate.of(2014, 9, 14))).toString());
	}
}
