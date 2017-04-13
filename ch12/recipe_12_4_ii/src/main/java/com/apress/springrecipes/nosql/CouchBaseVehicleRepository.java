package com.apress.springrecipes.nosql;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.RawJsonDocument;
import com.couchbase.client.java.document.SerializableDocument;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.query.N1qlQuery;

class CouchBaseVehicleRepository implements VehicleRepository {

    private final Bucket bucket;

    public CouchBaseVehicleRepository(Bucket bucket) {
        this.bucket=bucket;
    }

    @Override
    public void save(Vehicle vehicle) {
        SerializableDocument vehicleDoc = SerializableDocument.create(vehicle.getVehicleNo(), vehicle);
        bucket.upsert(vehicleDoc);
    }

    @Override
    public void delete(Vehicle vehicle) {
        bucket.remove(vehicle.getVehicleNo());
    }

    @Override
    public Vehicle findByVehicleNo(String vehicleNo) {
        N1qlQuery query = N1qlQuery.parameterized("select default.* from default where vehicleNo=$1", JsonArray.from(vehicleNo));
        return bucket.query(query).allRows().stream().findFirst()
                .map(row -> row.value())
                .map(jsonObject -> jsonObject.toString())
                .map(json -> RawJsonDocument.)
                .orElse(null);


    }
}
