package za.co.crosstek.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import za.co.crosstek.anot.EntityAnotation;
import za.co.crosstek.anot.FieldAnotation;  
import za.co.crosstek.enums.EntityAttribute;

@Entity
@EntityAnotation(attributes = {EntityAttribute.REST}, label = "GeoLocation", icon = "fafa-map-marker")
public class GeoLocation extends CoreEntity {

    @NotNull
    @FieldAnotation(label = "Latitude")
    private Double latitude;

    @NotNull
    @FieldAnotation(label = "Longitude")
    private Double longitude;

    @FieldAnotation(label = "Accuracy")
    private Double accuracy;

    @FieldAnotation(label = "Altidtude")
    private Double altitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "Latitude: " + latitude + ", Longitude: " + longitude;
    }
}
