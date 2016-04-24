package cn.edu.nju.ws.geokb.bean.geonames;

/**
 * Created by sunzequn on 2016/4/24.
 */
public class Koppen {

    private String longitude;
    private String latitude;
    private String type;

    public Koppen() {
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Koppen{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
