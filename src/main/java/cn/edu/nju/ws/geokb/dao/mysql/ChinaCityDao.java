package cn.edu.nju.ws.geokb.dao.mysql;

import cn.edu.nju.ws.geokb.bean.ChinaCity;
import cn.edu.nju.ws.geokb.connection.mysql.DataSourcePool;
import cn.edu.nju.ws.geokb.dao.mysql.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Sloriac on 16/3/9.
 */
@Repository
public class ChinaCityDao extends BaseDao {

    @Autowired(required = true)
    private DataSourcePool dataSourcePool;

    public ChinaCityDao() {
    }

    public ChinaCity getById(int id) {
        Connection connection = dataSourcePool.getGeonamesConnection();
        String sql = "select * from china_city where id = " + id;
        List<ChinaCity> chinaCities = query(connection, sql, null, ChinaCity.class);
        if (chinaCities == null) {
            return null;
        }
        close(connection);
        return chinaCities.get(0);
    }

    public List<ChinaCity> getByName(String name) {
        Connection connection = dataSourcePool.getGeonamesConnection();
        String sql = "select * from china_city where name = ?";
        Object[] params = {name};
        List<ChinaCity> chinaCities = query(connection, sql, params, ChinaCity.class);
        close(connection);
        return chinaCities;
    }

    public List<ChinaCity> getChildren(int id){
        Connection connection = dataSourcePool.getGeonamesConnection();
        String sql = "select * from china_city where parentid = " + id;
        List<ChinaCity> chinaCities = query(connection, sql, null, ChinaCity.class);
        close(connection);
        return chinaCities;
    }

}
