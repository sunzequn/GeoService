package cn.edu.nju.ws.geokb.dao.sparql;

import cn.edu.nju.ws.geokb.constant.UriPrefix;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;
import org.springframework.stereotype.Repository;
import virtuoso.jena.driver.VirtGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sloriac on 16/3/13.
 */
@Repository
public class SumoDao extends BaseSparql implements IBaseSparql {

    public ResultSet getSumoByLocalName(String localName) {
        String uri = UriPrefix.SUMO_S_PREFIX + localName;
        String sparql = "select * from <sumo> where {<" + uri + "> ?p ?o}";
        return query(sparql);
    }

    public List<String> getAllSumoRelations() {
        String sparql = "select * from <sumo> where {?s ?p ?o}";
        ResultSet resultSet = query(sparql);
        if (!resultSet.hasNext()) {
            return null;
        }
        Set<String> relations = new HashSet<>();
        while (resultSet.hasNext()) {
            QuerySolution result = resultSet.nextSolution();
            RDFNode p = result.get("p");
            if (p.toString().contains("Relation")) {
                relations.add(p.toString());
            }
        }
        return new ArrayList<>(relations);
    }

    @Override
    public ResultSet query(String sparql) {
        VirtGraph virtGraph = virtuosoGraphPool.getSumoVirtGraph();
        ResultSet resultSet = queryVirtGraph(sparql, virtGraph);
        putBack(virtGraph, virtuosoGraphPool.getSumoVirtGraphs());
        return resultSet;
    }
}
