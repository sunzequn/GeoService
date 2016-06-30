package cn.edu.nju.ws.geokb.dao.query.geonames;

import cn.edu.nju.ws.geokb.bean.geonames.Geoname;
import cn.edu.nju.ws.geokb.dao.query.base.GeonamesBaseQuery;
import cn.edu.nju.ws.geokb.utils.ListUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sloriac on 16-2-14.
 */
@Repository
public class GeonameDao extends GeonamesBaseQuery {

    private static final String TABLE = "geoname";

    public Geoname getById(int geonameId) {
        String sql = "select * from " + TABLE + " where geonameid = " + geonameId;
        List<Geoname> geonames = query(sql, null, Geoname.class);
        if (ListUtil.isEmpty(geonames))
            return null;
        return geonames.get(0);
    }
}
