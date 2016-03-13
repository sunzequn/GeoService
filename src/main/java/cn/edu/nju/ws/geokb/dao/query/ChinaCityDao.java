package cn.edu.nju.ws.geokb.dao.query;

import cn.edu.nju.ws.geokb.bean.ChinaCity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Sloriac on 16/3/9.
 */
@Repository
public class ChinaCityDao extends BaseQuery {

    private static final String TABLE = "china_city";

    public ChinaCityDao() {
    }

    public ChinaCity getById(int id) {
        Connection connection = dataSourcePool.getGeonamesConnection();
        String sql = "select * from " + TABLE + " where id = " + id;
        List<ChinaCity> chinaCities = query(connection, sql, null, ChinaCity.class);
        if (chinaCities == null) {
            return null;
        }
        close(connection);
        return chinaCities.get(0);
    }

    public List<ChinaCity> getByName(String name) {
        Connection connection = dataSourcePool.getGeonamesConnection();
        String sql = "select * from " + TABLE + " where name = ?";
        Object[] params = {name};
        List<ChinaCity> chinaCities = query(connection, sql, params, ChinaCity.class);
        close(connection);
        return chinaCities;
    }

    public List<ChinaCity> getChildren(int id) {
        Connection connection = dataSourcePool.getGeonamesConnection();
        String sql = "select * from " + TABLE + " where parentid = " + id;
        List<ChinaCity> chinaCities = query(connection, sql, null, ChinaCity.class);
        close(connection);
        return chinaCities;
    }

}
