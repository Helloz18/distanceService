package distanceService.distance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import distanceService.distance.model.Location;
import distanceService.distance.service.distanceService;

@RestController
public class distanceController {

	/**
	 * get distance between two location
	 * @param location1
	 * @param location2
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@RequestMapping(path="/distance")
	public Double distance(String location1, String location2) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Double longitude1 = mapper.readTree(location1).get("longitude").asDouble();
		Double latitude1 = mapper.readTree(location1).get("latitude").asDouble(); 
		Double longitude2 = mapper.readTree(location2).get("longitude").asDouble();
		Double latitude2 = mapper.readTree(location2).get("latitude").asDouble(); 
		
		Location firstLocation = new Location(longitude1, latitude1);
		Location secondLocation = new Location(longitude2, latitude2);
		return distanceService.getDistance(firstLocation, secondLocation);
	}
	
}
