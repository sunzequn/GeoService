package cn.edu.nju.ws.geokb.test.dao.query;

import cn.edu.nju.ws.geokb.dao.query.geonames.ChinaCityDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Sloriac on 16/3/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:conf/spring.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:conf/springmvc.xml")
})
public class ChinaCityDaoTest {

    @Autowired
    ChinaCityDao chinaCityDao;

    @Test
    public void getByName() {
        System.out.println(chinaCityDao.getByName("京"));
    }

    @Test
    public void getChildren() {
        System.out.println(chinaCityDao.getChildren(100000));
    }

    @Test
    public void getById() {
        chinaCityDao.getById(1);
    }

}
