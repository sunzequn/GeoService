package cn.edu.nju.ws.geokb.test.service;

import cn.edu.nju.ws.geokb.service.ChinaCityHandler;
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
public class ChinaCityHandlerTest {

    @Autowired
    private ChinaCityHandler chinaCityHandler;

    @Test
    public void directContainsStringParam() {
        System.out.println(chinaCityHandler.directContains("中国"));
    }

    @Test
    public void directContainsIntParam() {
        System.out.println(chinaCityHandler.directContains(110000).size());
    }

    @Test
    public void transContainsStringParam() {
        System.out.println(chinaCityHandler.transContains("北京"));
    }

    @Test
    public void transContainsIntParam() {
        System.out.println(chinaCityHandler.transContains(110000).size());
    }

    @Test
    public void ifContains() {
        System.out.println(chinaCityHandler.ifContains("江苏省", "北京"));
    }
}
