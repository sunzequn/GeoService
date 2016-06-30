package cn.edu.nju.ws.geokb.dao.query.climate;

import cn.edu.nju.ws.geokb.bean.climate.Koppen;
import cn.edu.nju.ws.geokb.bean.climate.KoppenMapping;
import cn.edu.nju.ws.geokb.dao.query.base.ClimateBaseQuery;
import cn.edu.nju.ws.geokb.dao.query.base.GeonamesBaseQuery;
import cn.edu.nju.ws.geokb.utils.ListUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunzequn on 2016/6/30.
 */
@Repository
public class KoppenMappingDao extends ClimateBaseQuery {

    private static final String TABLE = "koppen_mapping";

    public KoppenMapping getByKoppenType(String koppenType) {
        String sql = "select * from " + TABLE + " where koppentype = ?";
        Object[] params = {koppenType};
        List<KoppenMapping> koppenMappings = query(sql, params, KoppenMapping.class);
        if (ListUtil.isEmpty(koppenMappings)) {
            return null;
        }
        return koppenMappings.get(0);
    }
}
