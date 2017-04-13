package com.apress.springrecipes.nosql;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.SerializableDocument;

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
        return (Vehicle) bucket.get(vehicleNo,SerializableDocument.class).content();

    }
}
