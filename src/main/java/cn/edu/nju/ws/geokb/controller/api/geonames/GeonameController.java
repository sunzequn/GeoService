package cn.edu.nju.ws.geokb.controller.api.geonames;

import cn.edu.nju.ws.geokb.bean.geonames.Geoname;
import cn.edu.nju.ws.geokb.service.geonames.GeonameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sunzequn on 2016/6/29.
 */
@Controller
@RequestMapping("/api/geonames")
public class GeonameController {

    @Autowired
    private GeonameService geonameService;

    @ResponseBody
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public List<Geoname> getByChineseName(@PathVariable("name") String name) throws Exception {
        return geonameService.getByChineseName(name);
    }
}
