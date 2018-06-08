# RentVehicle

#### RentVehicleOnHourlyBasis

here you can view and choose different types of vehicle ,view variety of models for selected vehicle varying in price for different models.Can book vehicle based on hourly basis for a day and view total rental cost for the trip.

#### VehicleType
Type: `enum`  
RentalVehicle contains different types of vehicle with wide range of variety
#### VehicleModel
Type: `Model entity`  
VehicleModel contains variety of model corresponding to a particular VehicleType
#### Vehicle
Type: `Model entity`  
For a specific VehicleModel it contains many vehicles differentiating based on registration number
#### BookVehicle
Type: `Model entity`  
User can book a vehicle based on the VehicleModel User is interested in.
#### ReturnVehicle
Type: `Model entity`  
User can return a vehicle by giving bookingid and getting total rental cost for trip

### Methods
#### .bookVehicle()
Type: `function`  
Inputs: `UserId ,VehicleModelId `  
Generates Booking number for User when there is availability of vehicle for the particular VehicleModel.  
Returns: bookingid

#### .returnVehicle()
Type: `function`  
Inputs: `Booking Id`  
Computes total rent generated for a booking id from the time of booking and marks the vehicle as unbooked
Returns: rental cost

