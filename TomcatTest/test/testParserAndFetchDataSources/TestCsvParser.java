package testParserAndFetchDataSources;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataSources.CsvToMapParser;
import dataSources.FootballArena;

public class TestCsvParser {
	
	CsvToMapParser csvParser;
	FootballArena arena;
	
	@Before
	public void setUp() throws Exception {
		arena = FootballArena.STROMVALLEN;
		csvParser = new CsvToMapParser(arena.getCityTemperatureLocalPath());
	}

	@After
	public void tearDown() throws Exception {
		csvParser = null;
	}

	@Test
	public void testGetResultForStromvallen2014() {
		Map<String, Object> data = csvParser.getResultFromFile();
		assertEquals(null, data.get("1997-01-01"));
		assertEquals(null, data.get("2004-01-01"));
		assertEquals(null, data.get("2013-12-31"));
		assertEquals("2.5", (data.get("2014-01-01")));
		assertEquals("0.2", (data.get("2014-02-18")));
		assertEquals("3.8", (data.get("2014-12-31")));
		assertEquals(null, data.get("2015-01-01"));
	}

}
