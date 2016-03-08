package dataSources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CsvToMapParser {
	private final String csvFileToRead;
	private BufferedReader reader;

	private String line = "";
	private String csvSeparator = ";";
	private String desiredYear = "2014";
	private Map<String, Object> data;

	public CsvToMapParser(String csvFileToRead) {
		this.csvFileToRead = csvFileToRead;
	}

//	public Map<String, Object> getResult() {
//		//return translateCsvFromString();
//		return getResultFromFile();
//	}
	public Map<String, Object> getResultFromString() {
		String[] separated;
		Map<String, Object> value = new HashMap<String, Object>();
		separated = csvFileToRead.split(";");

		for (int i = 0; i < separated.length; i++) {
			if (separated[i].startsWith("Y")) {
				value.put((separated[i - 2]),
						Double.parseDouble(separated[i - 1]));
			}
		}
		return value;
	}

	public Map<String, Object> getResultFromFile() {
		try {
			reader = new BufferedReader(new FileReader(csvFileToRead));
			data = new TreeMap<>();
			while ((line = reader.readLine()) != null) {
				if (lineHas(desiredYear)) {
					String[] linePart = line.split(csvSeparator);
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
