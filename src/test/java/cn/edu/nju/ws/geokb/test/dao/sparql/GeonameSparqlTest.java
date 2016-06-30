package cn.edu.nju.ws.geokb.test.dao.sparql;

import cn.edu.nju.ws.geokb.dao.sparql.geonames.GeonameSparql;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by sunzequn on 2016/6/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:conf/spring.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:conf/springmvc.xml")
})
public class GeonameSparqlTest {

    @Autowired
    private GeonameSparql geonameSparql;

    @Test
    public void getByChineseNameTest() throws Exception {
        System.out.println(geonameSparql.getByChineseName("大别山").hasNext() + "--------------");
    }

}