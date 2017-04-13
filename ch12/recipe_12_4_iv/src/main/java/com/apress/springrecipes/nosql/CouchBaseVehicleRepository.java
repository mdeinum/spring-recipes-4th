package com.apress.springrecipes.nosql;

import com.couchbase.client.java.query.N1qlParams;
import com.couchbase.client.java.query.N1qlQuery;
import org.springframework.data.couchbase.core.CouchbaseTemplate;

class CouchBaseVehicleRepository implements VehicleRepository {

    private final CouchbaseTemplate couchbase;

    public CouchBaseVehicleRepository(CouchbaseTemplate couchbase) {
        this.couchbase = couchbase;
    }

    @Override
    public void save(Vehicle vehicle) {
        couchbase.save(vehicle);
    }

    @Override
    public void delete(Vehicle vehicle) {
        couchbase.remove(vehicle);
    }

    @Override
    public Vehicle findByVehicleNo(String vehicleNo) {

        N1qlQuery query = N1qlQuery.simple("SELECT * FROM default", N1qlParams.build().rawParam("vehicleNo", vehicleNo));

        couchbase.queryN1QL(query).allRows().forEach(r -> r.value().);

        return couchbase.findById(vehicleNo, Vehicle.class);
    }
}
