package cn.edu.nju.ws.geokb.test.utils;

import cn.edu.nju.ws.geokb.utils.YearUtil;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by sunzequn on 2016/6/30.
 */
public class YearUtilTest {

    @Test
    public void isLeapTest() {
        Assert.assertEquals(YearUtil.isLeap(2123), false);
        Assert.assertEquals(YearUtil.isLeap(2012), true);
        Assert.assertEquals(YearUtil.isLeap(2000), true);
        Assert.assertEquals(YearUtil.isLeap(2100), false);
    }
}
