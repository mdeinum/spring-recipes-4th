package com.apress.springrecipes.nosql;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;

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
    public CouchBaseVehicleRepository vehicleRepository(CouchbaseTemplate couchbaseTemplate) {
        return new CouchBaseVehicleRepository(couchbaseTemplate);
    }

    @Bean
    public CouchbaseTemplate couchbaseTemplate(Cluster cluster, Bucket bucket) {
        return new CouchbaseTemplate(cluster.clusterManager("admin","admin2017").info(), bucket);
    }
}
