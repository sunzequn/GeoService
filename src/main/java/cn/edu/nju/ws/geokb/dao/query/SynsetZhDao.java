package cn.edu.nju.ws.geokb.dao.query;

import cn.edu.nju.ws.geokb.bean.SynsetZh;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sloriac on 16/3/12.
 */
@Repository
public class SynsetZhDao extends BaseQuery {

    private static final String TABLE_DEFAULT = "wn_chinese";
    private static final String TABLE_ARTIFACT = "wn_artifact_synset_chs";

    public List<SynsetZh> getByZh(String zh) {
        List<SynsetZh> synsetZhs = getByZhFromDefault(zh);
        if (synsetZhs == null) {
            synsetZhs = getByZhFromArtifact(zh);
        }
        return synsetZhs;
    }

    public List<SynsetZh> getByZhFromDefault(String zh) {
        return getByZhFromTable(TABLE_DEFAULT, zh);
    }

    public List<SynsetZh> getByZhFromArtifact(String zh) {
        return getByZhFromTable(TABLE_ARTIFACT, zh);
    }

    public List<SynsetZh> getAllFromDefault() {
        return getAllFromTable(TABLE_DEFAULT);
    }

    public List<SynsetZh> getAllFromArtifact() {
        return getAllFromTable(TABLE_ARTIFACT);
    }

    public void countNum() {
        List<SynsetZh> defaults = getAllFromDefault();
        List<SynsetZh> artifacts = getAllFromArtifact();
        Set<BigDecimal> synsetIdSet = new HashSet<>();
        for (SynsetZh synsetZh : defaults) {
            synsetIdSet.add(synsetZh.getSynset_id());
        }
        for (SynsetZh synsetZh : artifacts) {
            synsetIdSet.add(synsetZh.getSynset_id());
        }
        System.out.println("the num of Synset is " + synsetIdSet.size());
    }

    public List<SynsetZh> getAllFromTable(String table) {
        Connection connection = dataSourcePool.getWordnetZhConnection();
        String sql = "select * from " + table;
        List<SynsetZh> synsetZhs = query(connection, sql, null, SynsetZh.class);
        close(connection);
        return synsetZhs;
    }

    private List<SynsetZh> getByZhFromTable(String table, String zh) {
        Connection connection = dataSourcePool.getWordnetZhConnection();
        String sql = "select * from " + table + " where chinese = ?";
        Object[] params = {zh};
        List<SynsetZh> synsetZhs = query(connection, sql, params, SynsetZh.class);
        close(connection);
        return synsetZhs;
    }

}
