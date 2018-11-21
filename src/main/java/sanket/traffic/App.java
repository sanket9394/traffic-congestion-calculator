package sanket.traffic;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// SET UP PRE REQUIRED ZONES [ ONE TIME ]
		List<ZoneEntity> zonesList = new ZoneGenerator().generateZones();
		System.out.println("Fixed set of ZONES : ");
		for (ZoneEntity z : zonesList) {
			z.printMe();
		}

		// GET TRIP DATA
		List<TripEntity> tripList = new TripDataHandler().fetchTrips();
		
		new CongestionCalulator(50.0).calculateCongestionRate(zonesList, tripList);
		
		
		for (ZoneEntity z : zonesList) {
			z.printMe();
		}

	}

}
