package cn.edu.nju.ws.geokb.controller.api.climate;

import cn.edu.nju.ws.geokb.service.climate.PrecipitationService;
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
@RequestMapping("/api/climate/precipitation")
public class PrecipitationController {

    @Autowired
    private PrecipitationService precipitationService;

    @ResponseBody
    @RequestMapping(value = "daily/{lng}/{lat}/{year}/{month}", method = RequestMethod.GET)
    public double getDailyPrecipitation(@PathVariable("lng") double lng, @PathVariable("lat") double lat, @PathVariable("year") int year, @PathVariable("month") int month) {
        return precipitationService.getDailyPrecipitation(lng, lat, year, month);
    }

    @ResponseBody
    @RequestMapping(value = "monthly/{lng}/{lat}/{year}/{month}", method = RequestMethod.GET)
    public double getMonthlyPrecipitation(@PathVariable("lng") double lng, @PathVariable("lat") double lat, @PathVariable("year") int year, @PathVariable("month") int month) {
        return precipitationService.getMonthlyPrecipitation(lng, lat, year, month);
    }

}
