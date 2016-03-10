package cn.edu.nju.ws.geokb.controller.api;

import cn.edu.nju.ws.geokb.bean.ChinaCity;
import cn.edu.nju.ws.geokb.service.ChinaCityHandler;
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
@RequestMapping("/api/contains/china")
public class ChinaCityApiController {

    @Autowired
    private ChinaCityHandler chinaCityHandler;

    @ResponseBody
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Map<String, List<ChinaCity>> getContains(@PathVariable("name") String name){
        return chinaCityHandler.directContains(name);
    }
}
