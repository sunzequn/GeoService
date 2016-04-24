package cn.edu.nju.ws.geokb.dao.query.geonames;

import cn.edu.nju.ws.geokb.bean.geonames.Koppen;
import cn.edu.nju.ws.geokb.dao.query.base.GeonamesBaseQuery;

import java.util.List;

/**
 * Created by sunzequn on 2016/4/24.
 */
public class KoppenDao extends GeonamesBaseQuery {

    private static final String TABLE = "koppen";

    private List<Koppen> getAll() {
        String sql = "select * from " + TABLE;
        return query(sql, null, Koppen.class);
    }
}
