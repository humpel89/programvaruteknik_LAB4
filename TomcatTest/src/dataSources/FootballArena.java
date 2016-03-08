package dataSources;

public enum FootballArena {
	OLYMPIA("Olympia, Helsingborg", "60662", "Helsingborg", null, null), 
	STROMVALLEN("Strömvallen", "60610", "Gävle",
			"http://opendata-download-metobs.smhi.se/explore/zip?parameterIds=2&stationId=107420&period=corrected-archive&includeMetadata=false",
			"SMHI_Data/smhi-opendata_2_107420_corrected-archive_2016-02-01_23-00-00.csv"),
	NYAPARKEN("Nya Parken", "60029", "Norrköping", null, null);

	private final String arenaName;
	private final String arenaId;
	private final String city;
	private final String cityTemperatureURL;
	private final String cityTemperatureLocalPath;


	FootballArena(String arenaName, String arenaId, String city, String cityTemperatureURL, String cityTemperatureLocalPath) {
		this.arenaName = arenaName;
		this.arenaId = arenaId;
		this.city = city;
		this.cityTemperatureURL = cityTemperatureURL;
		this.cityTemperatureLocalPath = cityTemperatureLocalPath;
	}

	public String getArenaName() {
		return arenaName;
	}
	
	public String getArenaId(){
		return arenaId;
	}
	
	public String getCity() {
		return city;
	}

	public String getCityTemperatureURL() {
		return cityTemperatureURL;
	}

	public String getCityTemperatureLocalPath() {
		return cityTemperatureLocalPath;
	}
}
