package com.apress.springrecipes.nosql;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudBaseConfiguration {

    @Bean(destroyMethod = "disconnect")
    public Cluster cluster() {
        return CouchbaseCluster.create();
    }

    @Bean
    public Bucket bucket(Cluster cluster) {
        return cluster.openBucket();
    }

    @Bean
    public CouchBaseVehicleRepository vehicleRepository(Bucket bucket) {
        return new CouchBaseVehicleRepository(bucket);
    }
}
