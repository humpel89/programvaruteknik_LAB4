package dataSources;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author thomas
 */
public class FootballGoalsSource implements DataSource {

	private FootballArena arenaToCheck = FootballArena.STROMVALLEN;
	private final String FOOTBALLGOALSURL = "http://api.everysport.com/v1/events?apikey=1769e0fdbeabd60f479b1dcaff03bf5c&league=63925&limit=";
	private final String NUMBEROFGAMES = "240"; //240 is max.

	@Override
	public String getName() {
		return "Antal mål per matchdag i fotbollsallsvenskan";
	}

	@Override
	public String getUnit() {
		return "Antal mål";
	}

	@Override
	public Map<LocalDate, Double> getData() {
		UrlFetcher fetcher = new UrlFetcher(FOOTBALLGOALSURL + NUMBEROFGAMES);
		JsonToMapParser parser = new JsonToMapParser(fetcher.getContent());
		Map<String, Object> data = parser.getResult();
		Map<LocalDate, Double> result = new TreeMap<>();

		for (Map event : (List<Map>) data.get("events")) {
			Map<String, Object> facts = (Map<String, Object>) event.get("facts");
			if(facts.containsKey("arena")){
				Map<String, Object> arena = (Map<String, Object>) facts.get("arena");
				arenaIdMatchesChosenArenaId(arenaToCheck, result, event, arena);
			}
		}
		return result;
	}
	
	public void setArenaToCheck(FootballArena arenaToCheck){
		this.arenaToCheck = arenaToCheck;
	}

	private void arenaIdMatchesChosenArenaId(FootballArena arenaToCheck, Map<LocalDate, Double> result, Map event,
			Map<String, Object> arena) {
		if (arena.get("id").toString().matches(arenaToCheck.getArenaId())) {
			LocalDate date = LocalDate.parse(event.get("startDate").toString().substring(0, 10));
			int goals = Integer.parseInt(event.get("visitingTeamScore").toString());
			goals += Integer.parseInt(event.get("homeTeamScore").toString());
			addGoalsToDate(result, date, goals);
		}
	}

	private void addGoalsToDate(Map<LocalDate, Double> result, LocalDate date, int goals) {
		if (!result.containsKey(date)) {
			result.put(date, new Double(goals));
		} else {
			result.put(date, result.get(date) + goals);
		}
	}
	public static void main(String[] args) {
		new FootballGoalsSource().getData(); 
	}
}
