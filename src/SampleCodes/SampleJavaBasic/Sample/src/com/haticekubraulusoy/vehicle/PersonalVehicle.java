package com.haticekubraulusoy.vehicle;

import com.alicankececi.rental.vehicle.Vehicle;

public abstract class PersonalVehicle extends Vehicle {
    protected int controlPeriod;

    //...

    public PersonalVehicle(int period)
    {
        controlPeriod = period;
    }
    //...
}
