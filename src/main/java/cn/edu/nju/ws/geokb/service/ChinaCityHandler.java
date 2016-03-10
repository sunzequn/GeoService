package cn.edu.nju.ws.geokb.service;

import cn.edu.nju.ws.geokb.bean.ChinaCity;
import cn.edu.nju.ws.geokb.dao.ChinaCityDao;
import cn.edu.nju.ws.geokb.utils.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<ChinaCity> directContains(int id) {
        return chinaCityDao.getChildren(id);
    }

    public List<ChinaCity> transContains(int id) {
        List<ChinaCity> chinaCities = new ArrayList<>();
        List<ChinaCity> children = chinaCityDao.getChildren(id);
        if (children != null) {
            chinaCities.addAll(children);
            for (ChinaCity child : children) {
                List<ChinaCity> contains = chinaCityDao.getChildren(child.getId());
                if (contains != null) {
                    chinaCities.addAll(contains);
                }
            }
            return chinaCities;
        }
        return null;
    }

    public Map<String, List<ChinaCity>> transContains(String name) {
        List<ChinaCity> chinaCities = chinaCityDao.getByName(name);
        if (chinaCities != null) {
            Map<String, List<ChinaCity>> containsMap = new HashMap<>();
            for (ChinaCity chinaCity : chinaCities) {
                List<ChinaCity> children = transContains(chinaCity.getId());
                if (children != null) {
                    containsMap.put(chinaCity.getMergername(), children);
                }
            }
            if (containsMap.size() > 0) {
                return containsMap;
            }
        }
        return null;
    }

    public Map<String, List<ChinaCity>> directContains(String name) {
        List<ChinaCity> chinaCities = chinaCityDao.getByName(name);
        if (chinaCities != null) {
            Map<String, List<ChinaCity>> containsMap = new HashMap<>();
            for (ChinaCity chinaCity : chinaCities) {
                List<ChinaCity> children = directContains(chinaCity.getId());
                if (children != null) {
                    containsMap.put(chinaCity.getMergername(), children);
                }
            }
            if (containsMap.size() > 0) {
                return containsMap;
            }
        }
        return null;
    }

    public int ifContains(String parentName, String childName){
        List<ChinaCity> relatedCities = chinaCityDao.getByName(parentName);
        if (relatedCities == null || relatedCities.size() > 1){
            return -1;
        }
        List<ChinaCity> children = transContains(relatedCities.get(0).getId());
        if (children != null){
            for (ChinaCity child : children){
                if (child.getName().equals(childName) || child.getShortname().equals(childName)){
                    return 1;
                }
            }
            return 0;
        }

        return -1;








    }

}
