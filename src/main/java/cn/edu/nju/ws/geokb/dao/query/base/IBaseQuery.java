package cn.edu.nju.ws.geokb.dao.query.base;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Sloriac on 16/3/14.
 */
public interface IBaseQuery {

    <T> List<T> query(String sql, Object[] params, Class clazz);

    int execute(String sql, Object[] params);
}
