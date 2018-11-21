package sanket.traffic;

public class TripEntity {


	private Double speed;
	private Double pickupLat;
	private Double pickupLong;
	private Double dropLat;
	private Double dropLong;

	public TripEntity(Double pickupLat, Double pickupLong, Double dropLat, Double dropLong, Double speed) {
		super();
		this.pickupLat = pickupLat;
		this.pickupLong = pickupLong;
		this.dropLat = dropLat;
		this.dropLong = dropLong;
		this.speed = speed;
		
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getPickupLat() {
		return pickupLat;
	}

	public void setPickupLat(Double pickupLat) {
		this.pickupLat = pickupLat;
	}

	public Double getPickupLong() {
		return pickupLong;
	}

	public void setPickupLong(Double pickupLong) {
		this.pickupLong = pickupLong;
	}

	public Double getDropLat() {
		return dropLat;
	}

	public void setDropLat(Double dropLat) {
		this.dropLat = dropLat;
	}

	public Double getDropLong() {
		return dropLong;
	}

	public void setDropLong(Double dropLong) {
		this.dropLong = dropLong;
	}

	
	
}
