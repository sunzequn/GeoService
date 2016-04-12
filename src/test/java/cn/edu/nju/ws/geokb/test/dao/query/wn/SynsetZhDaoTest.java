package cn.edu.nju.ws.geokb.test.dao.query.wn;

import cn.edu.nju.ws.geokb.dao.query.wn.SynsetZhDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Sloriac on 16/3/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:conf/spring.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:conf/springmvc.xml")
})
public class SynsetZhDaoTest {

    @Autowired
    SynsetZhDao synsetZhDao;

    @Test
    public void testGetByZhFromDefault() throws Exception {
        System.out.println(synsetZhDao.getByZhFromDefault("河流"));
        System.out.println(synsetZhDao.getByZhFromDefault("山"));
        System.out.println(synsetZhDao.getByZhFromDefault("盆地"));
        System.out.println(synsetZhDao.getByZhFromDefault("城市"));
    }

    @Test
    public void testGetByZhFromArtifact() throws Exception {
        System.out.println(synsetZhDao.getByZhFromArtifact("河流"));
        System.out.println(synsetZhDao.getByZhFromArtifact("山"));
        System.out.println(synsetZhDao.getByZhFromArtifact("盆地"));
        System.out.println(synsetZhDao.getByZhFromArtifact("城市"));
    }

    @Test
    public void testGetByZh() throws Exception {
        System.out.println(synsetZhDao.getByZh("河流"));
        System.out.println(synsetZhDao.getByZh("山"));
        System.out.println(synsetZhDao.getByZh("盆地"));
        System.out.println(synsetZhDao.getByZh("城市"));
    }

    @Test
    public void testCountNum() throws Exception {
        synsetZhDao.countNum();
    }
}