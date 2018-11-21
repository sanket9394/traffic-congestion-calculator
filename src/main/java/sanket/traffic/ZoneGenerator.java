package sanket.traffic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ZoneGenerator {

	private String resourceFileName = "taxi_zones.csv";

	public List<ZoneEntity> generateZones() {

		ArrayList<ZoneEntity> zonesList = new ArrayList<>();

		String[] zonesDataFromCSV = readFromResource(resourceFileName).split("\\n");

		for (int i = 0; i < zonesDataFromCSV.length; i++) {
			String[] zoneData = zonesDataFromCSV[i].split(",");
			//geo_hash,lat_min,lat_max,long_min,long_max
			ZoneEntity zone = new ZoneEntity(zoneData[0], 
					Double.parseDouble(zoneData[1]),
					Double.parseDouble(zoneData[2]), 
					Double.parseDouble(zoneData[3]), 
					Double.parseDouble(zoneData[4]));

			zonesList.add(zone);

		}

		return zonesList;
	}

	private String readFromResource(String fileName) {
		ClassLoader classLoader = new App().getClass().getClassLoader();

		File file = new File(classLoader.getResource(fileName).getFile());

		// File is found
		System.out.println("File Found : " + file.exists());

		// Read File Content
		String content = "";
		try {
			content = new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;

	}
}
