package testParserAndFetchDataSources;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dataSources.FootballArena;

public class TestArena {
	FootballArena arena;

	@Before
	public void setUp() throws Exception {
		arena = FootballArena.STROMVALLEN;
	}

	@Test
	public void testArenaAlias() {
		assertEquals(FootballArena.STROMVALLEN, arena);
		assertNotEquals(FootballArena.NYAPARKEN, arena);
	}

	@Test
	public void testgetArenaCity() {
		assertEquals("Gävle", arena.getCity());
	}

	@Test
	public void testGetArenaName() {
		assertEquals("Strömvallen", arena.getArenaName());
	}

	@Test
	public void testGetCityTemperatureURL() {
		String gavleURL = "http://opendata-download-metobs.smhi.se/api/version/latest/parameter/2/station/107420/period/corrected-archive/data.csv";
		assertEquals(gavleURL, arena.getCityTemperatureURL());
	}
	
	@Test
	public void testGetCityTemperatureLocalPath() {
	    	String gavleLocalPath = "SMHI_Data/smhi-opendata_2_107420_corrected-archive_2016-02-01_23-00-00.csv";
	    	assertEquals(gavleLocalPath, arena.getCityTemperatureLocalPath());
	}
}
