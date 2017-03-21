package com.apress.springrecipes.vehicle;

import com.apress.springrecipes.vehicle.config.VehicleConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfiguration.class);

        VehicleDao vehicleDao = context.getBean(VehicleDao.class);
        Vehicle vehicle1 = new Vehicle("TEM0442", "Blue", 4, 4);
        Vehicle vehicle2 = new Vehicle("TEM0443", "Black", 4, 6);
        vehicleDao.insert(Arrays.asList(vehicle1, vehicle2));

        vehicleDao.findAll().forEach(System.out::println);

    }

}
