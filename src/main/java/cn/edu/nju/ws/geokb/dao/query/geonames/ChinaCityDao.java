package cn.edu.nju.ws.geokb.dao.query.geonames;

import cn.edu.nju.ws.geokb.bean.geonames.ChinaCity;
import cn.edu.nju.ws.geokb.dao.query.base.BaseQuery;
import cn.edu.nju.ws.geokb.dao.query.base.GeonamesBaseQuery;
import cn.edu.nju.ws.geokb.dao.query.base.IBaseQuery;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Sloriac on 16/3/9.
 */
@Repository
public class ChinaCityDao extends GeonamesBaseQuery {

    private static final String TABLE = "china_city";

    public ChinaCityDao() {
    }

    public ChinaCity getById(int id) {
        String sql = "select * from " + TABLE + " where id = " + id;
        List<ChinaCity> chinaCities = query(sql, null, ChinaCity.class);
        if (chinaCities == null) {
            return null;
        }
        return chinaCities.get(0);
    }

    public List<ChinaCity> getByName(String name) {
        String sql = "select * from " + TABLE + " where name = ?";
        Object[] params = {name};
        return query(sql, params, ChinaCity.class);
    }

    public List<ChinaCity> getChildren(int id) {
        String sql = "select * from " + TABLE + " where parentid = " + id;
        return query(sql, null, ChinaCity.class);
    }

}
