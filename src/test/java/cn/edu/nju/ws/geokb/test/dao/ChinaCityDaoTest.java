package cn.edu.nju.ws.geokb.test.dao;

import cn.edu.nju.ws.geokb.dao.ChinaCityDao;
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
    public void getByNameTest(){
        System.out.println(chinaCityDao.getByName("北京"));
    }

    @Test
    public void getChildrenTest(){
        System.out.println(chinaCityDao.getChildren(100000));
    }

}