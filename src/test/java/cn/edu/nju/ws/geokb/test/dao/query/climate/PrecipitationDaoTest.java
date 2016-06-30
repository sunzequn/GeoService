package cn.edu.nju.ws.geokb.test.dao.query.climate;

import cn.edu.nju.ws.geokb.dao.query.climate.PrecipitationDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by sunzequn on 2016/6/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:conf/spring.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:conf/springmvc.xml")
})
public class PrecipitationDaoTest {
    @Autowired
    private PrecipitationDao precipitationDao;

    @Test
    public void getByKey() throws Exception {
        System.out.println(precipitationDao.getByKey(-178.75, -88.75, 2012, 1));
    }


}
