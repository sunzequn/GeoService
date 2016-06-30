package cn.edu.nju.ws.geokb.dao.query.geonames;

import cn.edu.nju.ws.geokb.bean.geonames.ChinaCity;
import cn.edu.nju.ws.geokb.dao.query.base.GeonamesBaseQuery;
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

    public List<ChinaCity> getAll() {
        String sql = "select * from " + TABLE;
        return query(sql, null, ChinaCity.class);
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

    public List<ChinaCity> getByShortName(String shortName) {
        String sql = "select * from " + TABLE + " where shortname = ?";
        Object[] params = {shortName};
        return query(sql, params, ChinaCity.class);
    }

    public List<ChinaCity> getChildren(int id) {
        String sql = "select * from " + TABLE + " where parentid = " + id;
        return query(sql, null, ChinaCity.class);
    }

}
