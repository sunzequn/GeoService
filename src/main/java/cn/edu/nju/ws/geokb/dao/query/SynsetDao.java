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
public class SynsetDao extends BaseQuery {

    private static final String TABLE = "wn_synset";

    public List<Synset> getWordsOfSynset(BigDecimal synsetId) {
        Connection connection = dataSourcePool.getWordnetZhConnection();
        String sql = "select * from " + TABLE + " where synset_id = ?";
        Object[] params = {synsetId};
        List<Synset> synsets = query(connection, sql, params, Synset.class);
        close(connection);
        return synsets;
    }
}
