package dataCollection;

import java.time.LocalDate;
import java.util.Map;

public interface DataSource2 {
	
	public String getName();
	
	public String getUnit();
	
	public Map<LocalDate, Double> getData();

}
