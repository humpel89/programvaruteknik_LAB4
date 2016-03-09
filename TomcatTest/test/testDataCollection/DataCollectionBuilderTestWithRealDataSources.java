package testDataCollection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataCollection.DataCollectionBuilder;
import dataCollection.Resolution;
import dataSources.FootballArena;
import dataSources.FootballGoalsSource;
import dataSources.TemperatureSource;

public class DataCollectionBuilderTestWithRealDataSources {

	DataCollectionBuilder dcBuilder;
	FootballGoalsSource goalSource;
	TemperatureSource tempSource;
	
	@Before
	public void setUp() throws Exception {
		
		goalSource = new FootballGoalsSource();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetResultLocalPath() {
		tempSource = new TemperatureSource(FootballArena.STROMVALLEN.getCityTemperatureLocalPath());
		buildDataCollectionAndPrintResult("TestViaLocalPath");
		
	}
	@Test
	public void testGetResultURL() {
		tempSource = new TemperatureSource(FootballArena.STROMVALLEN.getCityTemperatureURL());
		buildDataCollectionAndPrintResult("TestViaURL");
	}
	
	private void buildDataCollectionAndPrintResult(String testType) {
		dcBuilder = new DataCollectionBuilder(goalSource, tempSource, Resolution.DAY);
		System.out.println(testType + ": " + dcBuilder.getResult().getData());
	}



}
