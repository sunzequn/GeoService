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
    private VirtuosoGraph sumoVirtuosoGraph;

    private LinkedList<VirtGraph> geonamesVirtGraphs;
    private LinkedList<VirtGraph> dbpediaVirtGraphs;
    private LinkedList<VirtGraph> sumoVirtGraphs;

    public VirtuosoGraphPool(VirtuosoGraph sumoVirtuosoGraph) {
        this.sumoVirtuosoGraph = sumoVirtuosoGraph;
        sumoVirtGraphs = sumoVirtuosoGraph.getVirtGraphs();
    }

    public VirtuosoGraphPool(VirtuosoGraph geonamesVirtuosoGraph, VirtuosoGraph dbpediaVirtuosoGraph, VirtuosoGraph sumoVirtuosoGraph) {
        this.geonamesVirtuosoGraph = geonamesVirtuosoGraph;
        this.dbpediaVirtuosoGraph = dbpediaVirtuosoGraph;
        this.sumoVirtuosoGraph = sumoVirtuosoGraph;

        geonamesVirtGraphs = geonamesVirtuosoGraph.getVirtGraphs();
        dbpediaVirtGraphs = dbpediaVirtuosoGraph.getVirtGraphs();
        sumoVirtGraphs = sumoVirtuosoGraph.getVirtGraphs();

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

    public VirtGraph getSumoVirtGraph() {
        try {
            return getVirtGraph(sumoVirtGraphs);
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

    public LinkedList<VirtGraph> getSumoVirtGraphs() {
        return sumoVirtGraphs;
    }
}