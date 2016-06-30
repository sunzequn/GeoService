package cn.edu.nju.ws.geokb.dao.query.climate;

import cn.edu.nju.ws.geokb.bean.climate.Koppen;
import cn.edu.nju.ws.geokb.dao.query.base.ClimateBaseQuery;
import cn.edu.nju.ws.geokb.utils.ListUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunzequn on 2016/4/24.
 */
@Repository
public class KoppenDao extends ClimateBaseQuery {

    private static final String TABLE = "koppen";

    public KoppenDao() {
    }

    public List<Koppen> getAll() {
        String sql = "SELECT * FROM " + TABLE + " ORDER BY latitude DESC, longitude";
        return query(sql, null, Koppen.class);
    }

    public Koppen getByLngLat(double lng, double lat) {
        String sql = "SELECT * FROM " + TABLE + " where longitude = ? and latitude = ?";
        Object[] params = {lng, lat};
        List<Koppen> koppens = query(sql, params, Koppen.class);
        if (ListUtil.isEmpty(koppens)) {
            return null;
        } else {
            return koppens.get(0);
        }
    }


}
