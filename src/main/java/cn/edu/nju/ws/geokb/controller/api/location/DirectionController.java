package cn.edu.nju.ws.geokb.controller.api.location;

import cn.edu.nju.ws.geokb.handler.location.constant.Direction;
import cn.edu.nju.ws.geokb.service.location.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sunzequn on 2016/6/30.
 */
@Controller
@RequestMapping("/api/direction")
public class DirectionController {

    @Autowired
    private DirectionService directionService;

    @ResponseBody
    @RequestMapping(value = "/{lng1}/{lat1}/{lng2}/{lat2}", method = RequestMethod.GET)
    public Direction getDirection(@PathVariable("lng1") double lng1, @PathVariable("lat1") double lat1, @PathVariable("lng2") double lng2, @PathVariable("lat2") double lat2) {
        return directionService.direction(lat1, lng1, lat2, lng2);
    }
}
