package dataSources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class CsvToMapParser {
	private final String csvFileToRead;
	private BufferedReader reader;

	private String line = "";
	private String lineSeparator = ";";
	private String desiredYear = "2014";
	private Map<String, Object> data;

	public CsvToMapParser(String csvFileToRead) {
		this.csvFileToRead = csvFileToRead;
	}

	public Map<String, Object> getResult() {
		return translateCsv();
	}

	// Referens
	// http://www.beingjavaguys.com/2013/09/read-and-parse-csv-file-in-java.html
	private Map<String, Object> translateCsv() {
		try {
			reader = new BufferedReader(new FileReader(csvFileToRead));
			data = new TreeMap<>();
			while ((line = reader.readLine()) != null) {
				if (lineHas(desiredYear)) {
					String[] linePart = line.split(lineSeparator);
					data.put(linePart[2], linePart[3]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	private boolean lineHas(String desiredYear) {
		if (line.length() > desiredYear.length()) {
			String lineYear = line.substring(0, 4);
			return lineYear.equals(desiredYear);
		}
		return false;
	}
}
