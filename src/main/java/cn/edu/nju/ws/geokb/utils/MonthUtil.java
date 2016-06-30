package cn.edu.nju.ws.geokb.utils;

/**
 * Created by sunzequn on 2016/6/30.
 */
public class MonthUtil {

    /**
     * 获得某年某月的天数
     *
     * @param year  年份
     * @param month 月份
     * @return 该月的天数
     */
    public static int daysOfMonth(int year, int month) {
        if (month == 2) {
            if (YearUtil.isLeap(year)) {
                return 29;
            } else {
                return 28;
            }
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 11) {
            return 31;
        }
        return 30;
    }


}
