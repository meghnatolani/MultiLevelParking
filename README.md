# MultiLevelParking

Description :
Design a multi level vehicle parking system which among other
features, gives a parking slot number for a given vehicle intending to park.

View of Parking Lot with slot numbers
<pre>
1  2  3  4  5
---->----->---  
10 9  8  7  6
11 12 13 14 15 
--<----<------
20 19 18 17 16
</pre>

Constraints :
1. Number of levels of parking should be given as input from console (N).
2. Parking lot is numbered from 0 - (N-1). In one parking lot there are 20 parking spaces.
3. Entry is between gate 1 and 10.
4. Exit is near gate 20 and 11.
5. Every parking lot is reserved with 10 parking space for car and 10 for bike.
6. Cars are parked from parking space 11 - 20, Bike from 1 - 10
7. Parking preference is given close to the exit gate, so cars will be parked starting from Parking space 20, 11, 19 so on.
And Bikes will be parked from parking space 6, 5, 7 and so on.
8. To maintain 7, cars and bike will be stacked as and when they come. Which means, In one parking space there can be 2 cars and 5 bikes.
Hence in a parking lot, there can be 20 cars and 50 bikes.
9. If there is a VIP in vehicle, there will be no stacking done. There would be just one bike/car in that parking space.

Input Sample :
OUT CAR KA-50-19-1
IN CAR GJ-40-05-2 NOT 46
IN CAR GJ-40-05-3 NOT 46
OUT CAR GJ-40-05-2
IN BIKE GJ-40-05-5 NOT 46
IN BIKE GJ-40-05-6 NOT 46
IN BIKE KA-50-19-7 VIP 45
IN CAR GJ-40-05-8 NOT 46
IN CAR GJ-40-05-9 NOT 46
IN CAR KA-50-19-10 VIP 45

Output :
CAR KA-50-19-1 not present in the Parking Lot
ENTRY : CAR GJ-40-05-2 Parking Lot : 0 Parking Space : 20
ENTRY : CAR GJ-40-05-3 Parking Lot : 0 Parking Space : 20
EXIT : CAR GJ-40-05-2 Parking Lot : 0 Parking Space : 20
ENTRY : BIKE GJ-40-05-5 Parking Lot : 0 Parking Space : 6
ENTRY : BIKE GJ-40-05-6 Parking Lot : 0 Parking Space : 6
ENTRY : BIKE KA-50-19-7 Parking Lot : 0 Parking Space : 6
ENTRY : CAR GJ-40-05-8 Parking Lot : 0 Parking Space : 20
ENTRY : CAR GJ-40-05-9 Parking Lot : 0 Parking Space : 11
ENTRY : CAR KA-50-19-10 Parking Lot : 0 Parking Space : 11
