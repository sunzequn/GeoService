package cn.edu.nju.ws.geokb.dao.sparql;

import org.apache.jena.query.ResultSet;

/**
 * Created by sloriac on 16-3-14.
 */
public interface IBaseSparql {

    ResultSet query(String sparql);
}
