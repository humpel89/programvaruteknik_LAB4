package dataHandler;

import com.owlike.genson.Genson;

import dataCollection.DataCollectionBuilder;
import dataCollection.Resolution;
import dataSources.FootballArena;
import dataSources.FootballGoalsSource;
import dataSources.TemperatureSource;

public class DataSourcesToJsonConverter {
	String jsonString;

	public DataSourcesToJsonConverter() {
		this(new FootballGoalsSource(), new TemperatureSource(FootballArena.STROMVALLEN.getCityTemperatureURL()),
				Resolution.DAY);
	}

	public DataSourcesToJsonConverter(FootballGoalsSource goalSource, TemperatureSource tempSource, Resolution res) {
		DataCollectionBuilder dcBuilder = new DataCollectionBuilder(goalSource, tempSource, res);
		jsonString = new Genson().serialize(dcBuilder.getResult());
	}

	public String getString() {

		return jsonString;
	}
}
