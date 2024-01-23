package com.baturhansahin.app.rental;

import com.alicankececi.rental.vehicle.Vehicle;
import com.alicankececi.rental.vehicle.VehicleOperation;
import com.emrekantarci.VehicleFactory;
import org.csystem.util.thread.ThreadUtil;

public class RentalVehicleDemoApp {
    public static void run()
    {
        VehicleFactory factory = new VehicleFactory();
        VehicleOperation vehicleOperation = new VehicleOperation();

        while (true) {
            Vehicle vehicle = factory.createVehicle();

            vehicleOperation.payTax(vehicle);
            ThreadUtil.sleep(2000);
        }
    }
    public static void main(String[] args)
    {
        run();
    }
}
