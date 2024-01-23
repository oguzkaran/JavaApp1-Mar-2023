package com.alicankececi.rental.vehicle;

public class VehicleOperation {
    //...
    public void payTax(Vehicle vehicle)
    {
        System.out.println("-----------------------------------------");
        System.out.printf("Plate:%s%n", vehicle.getPlate());
        System.out.printf("Year:%d%n", vehicle.getYear());
        System.out.printf("Tax:%f%n", vehicle.calculateTax());
        System.out.println("-----------------------------------------");
    }
}
