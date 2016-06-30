package cn.edu.nju.ws.geokb.controller.api.geonames;

import cn.edu.nju.ws.geokb.bean.geonames.ChinaCity;
import cn.edu.nju.ws.geokb.bean.geonames.Position;
import cn.edu.nju.ws.geokb.service.geonames.ChinaCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Sloriac on 16/3/10.
 */
@Controller
@RequestMapping("/api/china")
public class ChinaCityController {

    @Autowired
    private ChinaCityService chinaCityService;

    @ResponseBody
    @RequestMapping(value = "/contains/{name}", method = RequestMethod.GET)
    public Map<String, List<ChinaCity>> getContains(@PathVariable("name") String name){
        return chinaCityService.directContains(name);
    }

    @ResponseBody
    @RequestMapping(value = "/contains/trans/{name}", method = RequestMethod.GET)
    public Map<String, List<ChinaCity>> getTransContains(@PathVariable("name") String name){
        return chinaCityService.transContains(name);
    }

    @ResponseBody
    @RequestMapping(value = "/contains/{parentName}/{childName}", method = RequestMethod.GET)
    public Integer ifContains(@PathVariable("parentName") String parentName, @PathVariable("childName") String childName){
        return chinaCityService.ifContains(parentName, childName);
    }

    @ResponseBody
    @RequestMapping(value = "/position/{name}", method = RequestMethod.GET)
    public Position getChinaCityPositionByName(@PathVariable("name") String name) {
        return chinaCityService.getChinaCityPositionByName(name);
    }

}
