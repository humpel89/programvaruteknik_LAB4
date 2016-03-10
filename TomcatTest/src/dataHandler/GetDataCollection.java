package dataHandler;


import com.owlike.genson.Genson;

import dataCollection.DataCollectionBuilder;
import dataCollection.Resolution;
import dataSources.FootballArena;
import dataSources.FootballGoalsSource;
import dataSources.TemperatureSource;

public class GetDataCollection {
	String jsonString;
	
	public GetDataCollection(){
		FootballGoalsSource goalSource = new FootballGoalsSource();
		TemperatureSource tempSource = new TemperatureSource(FootballArena.STROMVALLEN.getCityTemperatureURL());
		DataCollectionBuilder dcBuilder = new DataCollectionBuilder(goalSource, tempSource, Resolution.DAY);

	jsonString = new Genson().serialize(dcBuilder.getResult());
	}
	
	public String getData(){
		
		return jsonString;
	}
	
	
	public static void main(String[] args) {
	
	}

}
