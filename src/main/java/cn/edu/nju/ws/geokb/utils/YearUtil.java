package cn.edu.nju.ws.geokb.utils;

/**
 * Created by sunzequn on 2016/6/30.
 */
public class YearUtil {

    /**
     * 判断年份是否是闰年
     *
     * @param year 年份
     * @return 是闰年返回true，否则返回false
     */
    public static boolean isLeap(int year) {
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
    }
}
