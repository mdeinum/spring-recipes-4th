package com.apress.springrecipes.nosql;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

class CouchBaseVehicleRepository implements VehicleRepository {

    private final Bucket bucket;

    public CouchBaseVehicleRepository(Bucket bucket) {
        this.bucket=bucket;
    }

    @Override
    public void save(Vehicle vehicle) {
        JsonObject vehicleJson = JsonObject.empty()
                .put("vehicleNo", vehicle.getVehicleNo())
                .put("color", vehicle.getColor())
                .put("wheels", vehicle.getWheel())
                .put("seat", vehicle.getSeat());

        JsonDocument vehicleDoc = JsonDocument.create(vehicle.getVehicleNo(), vehicleJson);
        bucket.upsert(vehicleDoc);
    }

    @Override
    public void delete(Vehicle vehicle) {
        bucket.remove(vehicle.getVehicleNo());
    }

    @Override
    public Vehicle findByVehicleNo(String vehicleNo) {
        final JsonObject content = bucket.get(vehicleNo).content();
        return new Vehicle(content.getString("vehicleNo"), content.getString("color"), content.getInt("wheels"), content.getInt("seat"));
    }
}
