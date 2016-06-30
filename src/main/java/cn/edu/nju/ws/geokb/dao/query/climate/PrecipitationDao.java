package cn.edu.nju.ws.geokb.dao.query.climate;

import cn.edu.nju.ws.geokb.bean.climate.Precipitation;
import cn.edu.nju.ws.geokb.dao.query.base.ClimateBaseQuery;
import cn.edu.nju.ws.geokb.utils.ListUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunzequn on 2016/6/30.
 */
@Repository
public class PrecipitationDao extends ClimateBaseQuery {

    private static final String TABLE = "precipitation_monthly";

    /**
     * 根据主键（经度，纬度，年，月）查询
     *
     * @param lng
     * @param lat
     * @param year
     * @param month
     * @return
     */
    public Precipitation getByKey(double lng, double lat, int year, int month) {
        String sql = "select * from " + TABLE + " where longitude = ? and latitude = ? and year = ? and month = ?";
        Object[] params = {lng, lat, year, month};
        List<Precipitation> precipitations = query(sql, params, Precipitation.class);
        if (ListUtil.isEmpty(precipitations)) {
            return null;
        } else {
            return precipitations.get(0);
        }
    }
}
