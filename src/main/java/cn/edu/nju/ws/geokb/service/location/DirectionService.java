package cn.edu.nju.ws.geokb.service.location;

import cn.edu.nju.ws.geokb.handler.location.constant.Direction;
import cn.edu.nju.ws.geokb.handler.location.direction.DirCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunzequn on 2016/6/30.
 */
@Service
public class DirectionService {

    @Autowired
    private DirCalculator dirCalculator;

    public Direction direction(double lat1, double lng1, double lat2, double lng2) {
        return dirCalculator.direction(lat1, lng1, lat2, lng2);
    }
}
