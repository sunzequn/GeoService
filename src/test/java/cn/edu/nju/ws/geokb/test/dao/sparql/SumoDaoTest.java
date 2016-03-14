package cn.edu.nju.ws.geokb.test.dao.sparql;

import cn.edu.nju.ws.geokb.dao.sparql.SumoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by sloriac on 16-3-14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:conf/spring.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:conf/springmvc.xml")
})
public class SumoDaoTest {

    @Autowired
    private SumoDao sumoDao;

    @Test
    public void testGetAllSumoRelations() throws Exception {
        System.out.println(sumoDao.getAllSumoRelations());
    }
}