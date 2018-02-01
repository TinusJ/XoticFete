package za.co.crosstek.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class GeoLocation extends CoreEntity {

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    private Double accuracy;

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
