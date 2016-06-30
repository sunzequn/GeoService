package cn.edu.nju.ws.geokb.service.location;

import cn.edu.nju.ws.geokb.handler.location.distance.LongLatCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunzequn on 2016/6/30.
 */
@Service
public class DistanceService {

    @Autowired
    private LongLatCalculator longLatCalculator;

    public double distance(double lat1, double lon1, double lat2, double lon2) {
        return longLatCalculator.distance(lat1, lon1, lat2, lon2);
    }
}
