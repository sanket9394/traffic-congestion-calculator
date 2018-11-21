package sanket.traffic;

import java.util.ArrayList;
import java.util.List;

public class TripDataHandler {

	public List<TripEntity> fetchTrips() {

		Double lat1 = 40.68786621 + Double.valueOf(Math.random() * (40.74279785 - 40.68786621));
		Double long1 = -74.1796875 + Double.valueOf(Math.random() * (-74.15771484 + 74.1796875));

		TripEntity te1 = new TripEntity(40.71279785, -74.16771484, 40.68786621, -74.1796875, 24.0);

		List<TripEntity> tl = new ArrayList<TripEntity>();

		tl.add(te1);

		return tl;

	}

}
