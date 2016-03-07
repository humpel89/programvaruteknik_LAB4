package dataSources;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;


public class TemperatureSource implements DataSource{
	private String csvFileToRead = FootballArena.STROMVALLEN.getCityTemperatureLocalPath();
			//"SMHI_Data/smhi-opendata_2_107420_corrected-archive_2016-02-01_23-00-00.csv";
	
	


	@Override
	public String getName(){

		return "SMHI Temperature from Gävle";
	}

	@Override
	public String getUnit() {

		return "Celsius";
	}

	@Override
	public Map<LocalDate, Double> getData(){
		CsvToMapParser parser = new CsvToMapParser(csvFileToRead);
		
		//UrlFetcher fetcher = new UrlFetcher(FootballArena.STROMVALLEN.getCityTemperatureURL());
		//CsvToMapParser parser = new CsvToMapParser(fetcher.getContent());
		
		Map<String, Object> data = parser.getResult();
		Map<LocalDate, Double> result = new TreeMap<>();
		LocalDate date = LocalDate.of(2014, 1, 1);
		
		while(date.getYear() == 2014){
			String dateKey = date.toString();
			result.put(date, Double.valueOf(data.get(dateKey).toString()));
			date = date.plusDays(1);
		}
		return result;
	}
}
