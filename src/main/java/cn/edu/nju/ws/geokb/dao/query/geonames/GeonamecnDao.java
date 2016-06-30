package cn.edu.nju.ws.geokb.dao.query.geonames;

import cn.edu.nju.ws.geokb.bean.geonames.Geonamecn;
import cn.edu.nju.ws.geokb.dao.query.base.GeonamesBaseQuery;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

/**
 * Created by sunzequn on 2016/6/27.
 */
@Repository
public class GeonamecnDao extends GeonamesBaseQuery {

    private static final String TABLE = "geoname_cn";

    public List<Geonamecn> getByZh(String name) {
        String sql = "select * from " + TABLE + " where zhname like '%" + name + "%'";
        return query(sql, null, Geonamecn.class);
    }
}
