package dataSources;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;


public class TemperatureSource implements DataSource{
	private String csvFileToRead;
	private CsvToMapParser parser;
	private	Map<String, Object> data;
	public TemperatureSource(String source){
		this.csvFileToRead = source;
	}

	public void setDataSource(String source){
		this.csvFileToRead = source;
	}

	@Override
	public String getName(){
		return "SMHI Temperature from G�vle";
	}

	@Override
	public String getUnit() {
		return "Celsius";
	}

	@Override
	public Map<LocalDate, Double> getData(){
		if(isOnlineUrl(csvFileToRead)){
			data = prepareDataFromURL();
		}
		else{
			data = prepareDataFromFile();
		}
		return finalResultsFrom(data);
	}

	private Map<String, Object> prepareDataFromFile() {
		parser = new CsvToMapParser(csvFileToRead);
		return parser.getResultFromFile();
	}

	private Map<String, Object> prepareDataFromURL() {
		UrlFetcher fetcher = new UrlFetcher(csvFileToRead);
		parser = new CsvToMapParser(fetcher.getContent());
		return parser.getResultFromString();
	}

	private Map<LocalDate, Double> finalResultsFrom(Map<String, Object> data) {
		Map<LocalDate, Double> result = new TreeMap<>();
		LocalDate date = LocalDate.of(2014, 1, 1);
		while(date.getYear() == 2014){
			String dateKey = date.toString();
			result.put(date, Double.valueOf(data.get(dateKey).toString()));
			date = date.plusDays(1);
		}
		return result;
	}	
	private boolean isOnlineUrl(String sourceUrl) {
		return sourceUrl.substring(0, 4).matches("http");
	}
}
