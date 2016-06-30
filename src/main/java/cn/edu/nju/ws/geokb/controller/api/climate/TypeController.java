package cn.edu.nju.ws.geokb.controller.api.climate;

import cn.edu.nju.ws.geokb.service.climate.KoppenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sunzequn on 2016/6/29.
 */
@Controller
@RequestMapping("/api/climate/type")
public class TypeController {

    @Autowired
    private KoppenService koppenService;

    /**
     * 根据经纬度获得Koppen气候类型
     *
     * @param lng 地点经度
     * @param lat 地点纬度
     * @return Koppen气候类型，字符串
     */
    @ResponseBody
    @RequestMapping(value = "/koppen/{lng}/{lat}", method = RequestMethod.GET)
    public String getKoppenType(@PathVariable("lng") double lng, @PathVariable("lat") double lat) {
        if (lng > 180 || lng < -180 || lat > 90 || lat < -90) {
            return "parameters error";
        }
        return koppenService.getKoppenTypeByLntLat(lng, lat);
    }

    @ResponseBody
    @RequestMapping(value = "/zhongxue/{lng}/{lat}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public String getZhongxueType(@PathVariable("lng") double lng, @PathVariable("lat") double lat) {
        if (lng > 180 || lng < -180 || lat > 90 || lat < -90) {
            return "parameters error";
        }
        return koppenService.getZhongxueTypeByLntLat(lng, lat);
    }

    @ResponseBody
    @RequestMapping(value = "/description/{lng}/{lat}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public String getDes(@PathVariable("lng") double lng, @PathVariable("lat") double lat) {
        if (lng > 180 || lng < -180 || lat > 90 || lat < -90) {
            return "parameters error";
        }
        return koppenService.getDesByLntLat(lng, lat);
    }
}
