package cn.edu.nju.ws.geokb.dao.sparql;

import cn.edu.nju.ws.geokb.connection.virtuoso.VirtuosoGraphPool;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;

/**
 * Created by Sloriac on 16/3/13.
 */
public abstract class BaseSparql {

    @Autowired(required = true)
    protected VirtuosoGraphPool virtuosoGraphPool;

    protected ResultSet queryVirtGraph(String sparql, VirtGraph virtGraph) {
        Query query = QueryFactory.create(sparql);
        VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create(query, virtGraph);
        ResultSet results = vqe.execSelect();
        if (results.hasNext()) {
            return results;
        }
        return null;
    }
}
