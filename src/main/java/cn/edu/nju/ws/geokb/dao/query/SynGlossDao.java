package cn.edu.nju.ws.geokb.dao.query;

import cn.edu.nju.ws.geokb.bean.SynGloss;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

/**
 * Created by Sloriac on 16/3/12.
 */
@Repository
public class SynGlossDao extends BaseDao {

    private static final String TABLE = "wn_gloss";

    public List<SynGloss> getGlossOfSynset(BigDecimal synsetId) {
        Connection connection = dataSourcePool.getWordnetZhConnection();
        String sql = "select * from " + TABLE + " where synset_id = ?";
        Object[] params = {synsetId};
        List<SynGloss> synGlosses = query(connection, sql, params, SynGloss.class);
        close(connection);
        return synGlosses;
    }
}
