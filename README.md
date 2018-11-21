# traffic-congestion-calculator

Static Input : [ZONE DATA]
Takes a CSV with  (Zone_Name , lat_min	, lat_max	, long_min	,long_max)

Variable Input : [The trip data]
> Any number of trips each consisting of (Pickup_Lat, Pickup_Long, Drop_Lat, Drop_Long, AverageSpeed)

* the lats and long should be with in the limits of ZONE DATA

SET A Threshold average speed to say whether the trip had congested route or congestion free

Result: 
Each zone will get a Congestion Rating
> more positive : more congested
> more negative : no congestion


