package cn.edu.nju.ws.geokb.dao.query;

import cn.edu.nju.ws.geokb.bean.Synset;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

/**
 * Created by Sloriac on 16/3/12.
 */
@Repository
public class SynsetDao extends BaseQuery implements IBaseQuery {

    private static final String TABLE = "wn_synset";

    public List<Synset> getWordsOfSynset(BigDecimal synsetId) {
        String sql = "select * from " + TABLE + " where synset_id = ?";
        Object[] params = {synsetId};
        return query(sql, params, Synset.class);
    }

    @Override
    public <T> List<T> query(String sql, Object[] params, Class clazz) {
        Connection connection = dataSourcePool.getWordnetZhConnection();
        List<T> ts = query(connection, sql, null, clazz);
        close(connection);
        return ts;
    }

    @Override
    public int execute(String sql, Object[] params) {
        Connection connection = dataSourcePool.getWordnetZhConnection();
        int res = execute(connection, sql, null);
        close(connection);
        return res;
    }
}
