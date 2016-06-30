package cn.edu.nju.ws.geokb.dao.sparql.geonames;

import cn.edu.nju.ws.geokb.connection.virtuoso.VirtuosoConnection;
import org.apache.jena.query.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunzequn on 2016/6/30.
 */
@Repository
public class GeonameSparql {
    @Autowired
    private VirtuosoConnection geonamesConnection;

    public ResultSet getByChineseName(String name) throws Exception {
        String sparql = "select * where {?s <http://www.geonames.org/ontology#alternateName> '" + name + "'@zh}";
        ResultSet resultSet = geonamesConnection.parser(sparql);
        return resultSet;
    }
}
