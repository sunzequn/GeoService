package cn.edu.nju.ws.geokb.dao.query.base;

import java.sql.Connection;
import java.util.List;

/**
 * Created by sunzequn on 2016/4/24.
 */
public class GeonamesBaseQuery extends BaseQuery implements IBaseQuery {

    @Override
    public <T> List<T> query(String sql, Object[] params, Class clazz) {
        Connection connection = dataSourcePool.getGeonamesConnection();
        List<T> ts = query(connection, sql, params, clazz);
        close(connection);
        return ts;
    }

    @Override
    public int execute(String sql, Object[] params) {
        Connection connection = dataSourcePool.getGeonamesConnection();
        int res = execute(connection, sql, params);
        close(connection);
        return res;
    }
}
