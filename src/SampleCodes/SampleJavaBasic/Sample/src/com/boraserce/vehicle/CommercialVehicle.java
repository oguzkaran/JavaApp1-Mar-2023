package com.boraserce.vehicle;

import com.alicankececi.rental.vehicle.Vehicle;

public abstract class CommercialVehicle extends Vehicle {
    protected boolean forPassenger;

    //...

    public CommercialVehicle(boolean passenger)
    {
        forPassenger = passenger;
    }

    //...
}
