package sanket.traffic;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class ZoneEntity {

	private String name;
	private Double maxLat;
	private Double maxLong;
	private Double minLat;
	private Double minLong;

	int congestionRate=0;

	public ZoneEntity(String name, Double minLat, Double maxLat, Double minLong, Double maxLong) {
		super();
		this.name = name;
		this.maxLat = maxLat;
		this.maxLong = maxLong;
		this.minLat = minLat;
		this.minLong = minLong;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMaxLat() {
		return maxLat;
	}

	public void setMaxLat(Double maxLat) {
		this.maxLat = maxLat;
	}

	public Double getMaxLong() {
		return maxLong;
	}

	public void setMaxLong(Double maxLong) {
		this.maxLong = maxLong;
	}

	public Double getMinLat() {
		return minLat;
	}

	public void setMinLat(Double minLat) {
		this.minLat = minLat;
	}

	public Double getMinLong() {
		return minLong;
	}

	public void setMinLong(Double minLong) {
		this.minLong = minLong;
	}

	public int getCongestion() {
		return congestionRate;
	}

	public void setCongestion(int congestionRate) {
		this.congestionRate = congestionRate;
	}

	
	public void printMe() {
		System.out.println("Zone name:"+this.name+" | MAX_LAT:"+this.maxLat+" | MAX_LONG:"+this.maxLong+" | MIN_LAT:"+this.minLat+" | MIN_LONG:"+this.minLong +" | CONGESTION:"+this.congestionRate);
	}
}
