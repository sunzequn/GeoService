package cn.edu.nju.ws.geokb.connection.virtuoso;

import virtuoso.jena.driver.VirtGraph;

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
        return getVirtGraph(geonamesVirtGraphs);
    }

    public VirtGraph getDbpediaVirtGraph() {
        return getVirtGraph(dbpediaVirtGraphs);
    }

    public VirtGraph getSumoVirtGraph() {
        return getVirtGraph(sumoVirtGraphs);
    }

    private VirtGraph getVirtGraph(LinkedList<VirtGraph> virtGraphs) {
        if (virtGraphs.size() > 0) {
            return virtGraphs.pop();
        }
        return null;
    }
}