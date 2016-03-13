package cn.edu.nju.ws.geokb.test.dao.query;

import cn.edu.nju.ws.geokb.dao.query.SynsetDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;

/**
 * Created by Sloriac on 16/3/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:conf/spring.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:conf/springmvc.xml")
})
public class SynsetDaoTest {

    @Autowired
    private SynsetDao synsetDao;

    @Test
    public void testGetWordsOfSynset() throws Exception {
        System.out.println(synsetDao.getWordsOfSynset(new BigDecimal(200774403)));
    }
}