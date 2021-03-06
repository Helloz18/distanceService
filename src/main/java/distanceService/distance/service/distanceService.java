package distanceService.distance.service;

import org.springframework.stereotype.Service;

import distanceService.distance.model.Location;

@Service
public class distanceService {
	
	
	/**
	 * this method calculate the distance in miles between two locations.
	 * @param loc1
	 * @param loc2
	 * @return
	 */
	public static double getDistance(Location loc1, Location loc2) {
    	double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
       double lat1 = Math.toRadians(loc1.latitude);
       double lon1 = Math.toRadians(loc1.longitude);
       double lat2 = Math.toRadians(loc2.latitude);
       double lon2 = Math.toRadians(loc2.longitude);

       double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                              + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

       double nauticalMiles = 60 * Math.toDegrees(angle);
       double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
       return statuteMiles;
	}

}
