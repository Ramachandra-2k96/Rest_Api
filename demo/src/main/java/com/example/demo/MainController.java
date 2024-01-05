package com.example.demo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	    @GetMapping("/getTime/{City}")
	    public Map<String, Object> getTimeForCity(@PathVariable("City") String City) {
	        Map<String, Object> response = new LinkedHashMap<>();
	        LocalDateTime dt=LocalDateTime.now();
	        DateTimeFormatter formmater=DateTimeFormatter.ofPattern("HH:mm:ss");
	        switch(City) {
	        case "San Francisco":
	        					dt=dt.minusHours(13).minusMinutes(30);
	        					response.put("City ",City);
								response.put("Time ",dt.format(formmater)); 
	        					break;
	        case "New York":
					        	dt=dt.minusHours(10).minusMinutes(30);
					        	response.put("City ",City);
								response.put("Time ",dt.format(formmater));
	        					break;
	        case "London":
				        	dt=dt.minusHours(5).minusMinutes(30);
				        	response.put("City ",City);
							response.put("Time ",dt.format(formmater));
							break;
	        case "Dubai":
				        	dt=dt.minusHours(1).minusMinutes(30);
				        	response.put("City ",City);
							response.put("Time ",dt.format(formmater));
							break;
	        case "Bangalore":
				        	response.put("City ",City);
							response.put("Time ",dt.format(formmater));
							break;
	        case "Singapore":
				        	dt=dt.plusHours(2).plusMinutes(30);
				        	response.put("City ",City);
							response.put("Time ",dt.format(formmater));
							break;
	        case "Tokyo":
				        	dt=dt.plusHours(3).plusMinutes(30);
				        	response.put("City ",City);
							response.put("Time ",dt.format(formmater));
							break;
	        case "Sydney":
				        	dt=dt.plusHours(5).plusMinutes(30);
							response.put("City ",City);
							response.put("Time ",dt.format(formmater));
							break;
			default:response.put("Value : ",false);
	        }
	        return response;
	    }
	    
	    // This will print all the available Cities in ZoneID we can use that in above class
	    @GetMapping("/getCites")
	    public Map<String,Object> showCities()
	    {
	    	Map<String,Object> allDetails =new LinkedHashMap<>();
	    	Map<String,Object> cities;
	    	Set<String> zones=ZoneId.getAvailableZoneIds();
	    	ZonedDateTime time;
	    	DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");//24hrs format
	    	int i=1;
	    	for(String zone : zones)
	    	{
	    		cities =new LinkedHashMap<>();
	    		time=ZonedDateTime.now(ZoneId.of(zone));
	    		cities.put("Place ", zone);
	    		cities.put("Time ", time.format(formatter));
	    		allDetails.put("City-Id "+String.valueOf(i++), cities);
	    	}
			return allDetails;
	    }

}

