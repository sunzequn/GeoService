package cn.edu.nju.ws.geokb.bean.geonames;

/**
 * Created by sunzequn on 2016/6/30.
 */
public class Position {

    private double longitude;
    private double latitude;

    public Position(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Position{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
