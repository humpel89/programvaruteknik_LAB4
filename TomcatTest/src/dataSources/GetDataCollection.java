package dataSources;

import dataCollection.DataCollection;
import dataCollection.DataCollectionBuilder;
import dataCollection.Resolution;

public class GetDataCollection {

	DataCollectionBuilder dcBuilder;
	FootballGoalsSource goalSource;
	TemperatureSource tempSource;
	
	public GetDataCollection(){
		
	}
	
	public void getData(){
		tempSource = new TemperatureSource(FootballArena.STROMVALLEN.getCityTemperatureLocalPath());
		goalSource = new FootballGoalsSource();
		dcBuilder = new DataCollectionBuilder(goalSource, tempSource, Resolution.DAY);
		
		System.out.println(tempSource.getData().toString());
	}

}
