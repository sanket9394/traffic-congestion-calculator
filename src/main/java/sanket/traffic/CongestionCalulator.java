package sanket.traffic;

import java.util.List;

public class CongestionCalulator {
	
	private Double speedThreshold;
	private int maxCongestion = Integer.MIN_VALUE;
	private int minCongestion = Integer.MAX_VALUE;
	
	public CongestionCalulator(Double speedThreshold) {
		this.speedThreshold = speedThreshold;
	}

	public void calculateCongestionRate(List<ZoneEntity> zonesList, List<TripEntity> tl) {

		for (TripEntity te : tl) {
			for (ZoneEntity ze : zonesList) {

				// pickup lat long & drop lat long
				// Rectangle :
				// (minLat,maxLong)*************(maxLat,maxLong)
				// * *
				// * *
				// (minLat,minLong)*************(maxLat,minLong)
				//
				
				//if any of the lines intersect then yes the TRIP crosses that geohash
				
				//rect : lines 
				// line : 
				if(isIntersecting(te.getPickupLat(), te.getPickupLong(), te.getDropLat(), te.getDropLong(),ze.getMinLat(), ze.getMinLong(), ze.getMaxLat(), ze.getMinLong()) ||
				   isIntersecting(te.getPickupLat(), te.getPickupLong(), te.getDropLat(), te.getDropLong(),ze.getMaxLat(), ze.getMinLong(), ze.getMaxLat(), ze.getMaxLong()) ||
				   isIntersecting(te.getPickupLat(), te.getPickupLong(), te.getDropLat(), te.getDropLong(),ze.getMaxLat(), ze.getMaxLong(), ze.getMinLat(), ze.getMaxLong()) ||
				   isIntersecting(te.getPickupLat(), te.getPickupLong(), te.getDropLat(), te.getDropLong(),ze.getMinLat(), ze.getMinLong(), ze.getMinLat(), ze.getMaxLong()) 
						
						)
				{
					
					//Yes it crosses
					
					if(te.getSpeed() > this.speedThreshold) {
						ze.congestionRate ++ ;
					}
					else {
						ze.congestionRate-- ;
					}
					
					if(this.maxCongestion < ze.congestionRate)
						this.maxCongestion = ze.congestionRate;
					else if(this.minCongestion >ze.congestionRate)
						this.minCongestion =ze.congestionRate; 
					
				}
				
				
				

			}
		}
		
	}

	// line 1 : x1 y1 x2 y2
	// line 2 : x3y3 x4y4

	private boolean isIntersecting(Double x1, Double y1, Double x2, Double y2, Double x3, Double y3, Double x4,
			Double y4) {
		// Considering line 1 x1 y1 x2 y2

		boolean case1 = twoPointsOnSameSide(x1, y1, x2, y2, x3, y3, x4, y4);

		// consider line 2 x3y3 x4y4

		boolean case2 = twoPointsOnSameSide(x3, y3, x4, y4, x1, y1, x2, y2);

		if (case1 == false && case2 == false) {
			//
			return true;
		}

		return false;

	}

	private boolean twoPointsOnSameSide(Double x1, Double y1, Double x2, Double y2, Double px, Double py, Double qx,
			Double qy) {

		if (x1 == x2 && y2 == y1) {
			throw new RuntimeException("Wrong entry");
		}

		Double m;

		if (x1 == x2) {
			// vetical line

			if ((px < x1 && qx < x1) || (px > x1 && qx > x1))
				return true;
			else
				return false;

		} else {
			m = (y2 - y1) / (x2 - x1);

		}

		Double c = y1 - m * x1;

		Double valp = py - m * px - c;
		Double valq = qy - m * qx - c;

		if (valp * valq > 0) {
			return true;
		} else
			return false;

	}

}
