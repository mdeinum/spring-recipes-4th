package com.apress.springrecipes.nosql;

import com.apress.springrecipes.nosql.config.MongoConfiguration;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import reactor.core.publisher.Flux;

import java.util.Arrays;

/**
 * Created by marten on 22-09-14.
 */
public class Main {

    public static final String DB_NAME = "vehicledb";

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfiguration.class);
        VehicleRepository repository = ctx.getBean(VehicleRepository.class);

        repository.count().
                subscribe(cnt -> System.out.println("Number of Vehicles: " + cnt.longValue()));

        repository.saveAll(
                Flux.fromIterable(
                        Arrays.asList(
                                new Vehicle("TEM0001", "RED", 4, 4),
                                new Vehicle("TEM0002", "RED", 4, 4)))).subscribe();

        repository.count().subscribe(cnt -> System.out.println("Number of Vehicles: " + cnt.longValue()));

        repository.findByVehicleNo("TEM0001").subscribe(v -> ToStringBuilder.reflectionToString(v, ToStringStyle.SHORT_PREFIX_STYLE));


        repository.deleteAll().block();

        repository.count().subscribe(cnt -> System.out.println("Number of Vehicles: " + cnt.longValue()));

        ((AbstractApplicationContext) ctx).close();

    }
}
