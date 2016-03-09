package cn.edu.nju.ws.geokb.service;

import cn.edu.nju.ws.geokb.bean.ChinaCity;
import cn.edu.nju.ws.geokb.dao.ChinaCityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sloriac on 16/3/9.
 */
@Service
public class ChinaCityHandler {

    @Autowired
    private ChinaCityDao chinaCityDao;

    public Map<String, List<ChinaCity>> directContains(String name){
        List<ChinaCity> chinaCities = chinaCityDao.getByName(name);
        if (chinaCities == null){
            return null;
        }
        Map<String, List<ChinaCity>> containsMap = new HashMap<>();
        for (ChinaCity chinaCity : chinaCities){
            List<ChinaCity> children = chinaCityDao.getChildren(chinaCity.getId());
            if (children != null){
                containsMap.put(chinaCity.getMergername(), children);
            }
        }
        if (containsMap.size() > 0){
            return containsMap;
        }
        return null;
    }
}