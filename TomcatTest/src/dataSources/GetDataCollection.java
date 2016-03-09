package dataSources;


import dataCollection.DataCollectionBuilder;
import dataCollection.Resolution;

public class GetDataCollection {
	DataCollectionBuilder dcBuilder;
	FootballGoalsSource goalSource;
	TemperatureSource tempSource;
	
	
	public GetDataCollection(){
		
	}
	
	public void getData(){
		goalSource = new FootballGoalsSource();
		tempSource = new TemperatureSource(FootballArena.STROMVALLEN.getCityTemperatureLocalPath());
		dcBuilder = new DataCollectionBuilder(goalSource, tempSource, Resolution.DAY);
		System.out.println(": " + dcBuilder.getResult().getData());
		
	}

}
