package cn.edu.nju.ws.geokb.test.service;

import cn.edu.nju.ws.geokb.dao.query.geonames.GeonamecnDao;
import cn.edu.nju.ws.geokb.service.geonames.ChinaCityService;
import cn.edu.nju.ws.geokb.service.geonames.GeonameService;
import cn.edu.nju.ws.geokb.utils.ReadUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sunzequn on 2016/6/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:conf/spring.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:conf/springmvc.xml")
})
public class Tets {

    private static final String FILE = "D:\\Code\\github\\GeoService\\src\\main\\resources\\data\\data";
    @Autowired
    private GeonamecnDao geonamecnDao;
    @Autowired
    private GeonameService geonameService;

    private Set<String> places = new HashSet<>();

    @Before
    public void init() {
        System.out.println(geonameService);
        ReadUtil readUtil = new ReadUtil(FILE);
        List<String> lines = readUtil.readByLine();
        for (String line : lines) {
            if (!line.startsWith("*")) {
                places.add(line.trim());
            }
        }
        System.out.println(places.size());
    }

    @Test
    public void geoname() throws Exception {
        int num = 0;
        for (String place : places) {
            if (geonameService.getByChineseName(place) != null) {
                num++;
            } else {
                System.out.println(place);
            }
        }
        System.out.println("有 " + num);
    }

    @Test
    public void zh() throws Exception {
        int num = 0;
        for (String place : places) {
            if (geonamecnDao.getByZh(place) != null) {
                num++;
            } else {
                System.out.println(place);
            }
        }
        System.out.println("有 " + num);
    }


}
