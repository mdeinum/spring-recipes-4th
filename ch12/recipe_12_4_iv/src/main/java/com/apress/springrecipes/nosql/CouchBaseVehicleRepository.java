package com.apress.springrecipes.nosql;

import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.query.N1qlQuery;
import org.springframework.data.couchbase.core.CouchbaseTemplate;

import java.util.List;

class CouchBaseVehicleRepository implements VehicleRepository {

    private final CouchbaseTemplate couchbase;

    public CouchBaseVehicleRepository(CouchbaseTemplate couchbase) {
        this.couchbase = couchbase;
    }

    @Override
    public void save(Vehicle vehicle) {
        couchbase.insert(vehicle);
    }

    @Override
    public void delete(Vehicle vehicle) {
        couchbase.remove(vehicle);
    }

    @Override
    public Vehicle findByVehicleNo(String vehicleNo) {

        N1qlQuery query = N1qlQuery.parameterized("SELECT META(default).id AS _ID, META(default).cas AS _CAS, default.* FROM default WHERE vehicleNo = $1", JsonArray.from(vehicleNo));
        List<Vehicle> result = couchbase.findByN1QL(query, Vehicle.class);
        return result.stream().findFirst().orElse(null);
    }
}
