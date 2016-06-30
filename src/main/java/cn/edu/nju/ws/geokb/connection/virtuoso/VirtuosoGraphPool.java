package cn.edu.nju.ws.geokb.connection.virtuoso;

import cn.edu.nju.ws.geokb.connection.proxy.ConnectionInvocationHandler;
import cn.edu.nju.ws.geokb.connection.proxy.ProxyFactory;
import virtuoso.jena.driver.VirtGraph;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Sloriac on 16/2/14.
 * <p>
 * Load <code>VirtGraph</code> according to configuration.
 */
public class VirtuosoGraphPool {

    private VirtuosoGraph geonamesVirtuosoGraph;
    private VirtuosoGraph dbpediaVirtuosoGraph;

    private LinkedList<VirtGraph> geonamesVirtGraphs;
    private LinkedList<VirtGraph> dbpediaVirtGraphs;

    public VirtuosoGraphPool(VirtuosoGraph geonamesVirtuosoGraph) {
        this.geonamesVirtuosoGraph = geonamesVirtuosoGraph;
    }

    public VirtuosoGraphPool(VirtuosoGraph geonamesVirtuosoGraph, VirtuosoGraph dbpediaVirtuosoGraph) {
        this.geonamesVirtuosoGraph = geonamesVirtuosoGraph;
        this.dbpediaVirtuosoGraph = dbpediaVirtuosoGraph;

        geonamesVirtGraphs = geonamesVirtuosoGraph.getVirtGraphs();
        dbpediaVirtGraphs = dbpediaVirtuosoGraph.getVirtGraphs();

    }

    public VirtGraph getGeonamesVirtGraph() {
        try {
            return getVirtGraph(geonamesVirtGraphs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public VirtGraph getDbpediaVirtGraph() {
        try {
            return getVirtGraph(dbpediaVirtGraphs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void putBack(VirtGraph virtGraph, LinkedList<VirtGraph> virtGraphs) {
        virtGraphs.push(virtGraph);
    }

    private VirtGraph getVirtGraph(LinkedList<VirtGraph> virtGraphs) throws SQLException {
        if (virtGraphs.size() > 0) {
            return virtGraphs.pop();
        } else {
            throw new SQLException("No connection left.");
        }
    }

    public LinkedList<VirtGraph> getGeonamesVirtGraphs() {
        return geonamesVirtGraphs;
    }

    public LinkedList<VirtGraph> getDbpediaVirtGraphs() {
        return dbpediaVirtGraphs;
    }

}