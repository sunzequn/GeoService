package cn.edu.nju.ws.geokb.connection.virtuoso;

import virtuoso.jena.driver.VirtGraph;

import java.util.LinkedList;

/**
 * Created by Sloriac on 16/3/11.
 */
public class VirtuosoGraph {

    private LinkedList<VirtGraph> virtGraphs = new LinkedList<>();
    private String serverHost;
    private String serverPort;
    private String userName;
    private String password;
    private int poolSize;

    public VirtuosoGraph(String serverHost, String serverPort, String userName, String password, int poolSize) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        this.userName = userName;
        this.password = password;
        this.poolSize = poolSize;
        initGraphs();
    }

    private void initGraphs() {
        String url = "jdbc:virtuoso://" + serverHost + ":" + serverPort;
        System.out.println(poolSize);
        for (int i = 0; i < poolSize; i++) {
            try {
                virtGraphs.add(new VirtGraph(url, userName, password));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public LinkedList<VirtGraph> getVirtGraphs() {
        if (virtGraphs.size() > 0) {
            return virtGraphs;
        }
        return null;
    }
}
