package cn.edu.nju.ws.geokb.connection.virtuoso;

import cn.edu.nju.ws.geokb.exception.ConfigException;
import cn.edu.nju.ws.geokb.utils.PropertiesUtil;
import virtuoso.jena.driver.VirtGraph;

/**
 * Created by Sloriac o+n 16/2/14.
 * <p>
 * 根据配置文件连接Virtuoso数据库,加载VirtGraph.
 */
public class VirtGraphPool {

    /**
     * 单例模式
     */
    private static final VirtGraphPool ourInstance = new VirtGraphPool();

    /**
     * 配置文件地址
     */
    private static final String VIRTUOSO_GEONAMES_CONF_FILE = "Data/src/main/resources/conf/virtuoso_geonames.properties";
    private static final String VIRTUOSO_DBPEIDA_CONF_FILE = "Data/src/main/resources/conf/virtuoso_dbpedia.properties";

    /**
     * Virtuoso图
     */
    private VirtGraph geonamesVirtGraph = null;
    private VirtGraph dbpediaVirtGraph = null;

    public static VirtGraphPool getInstance() {
        return ourInstance;
    }

    private VirtGraphPool() {
//        geonamesVirtGraph = loader(VIRTUOSO_GEONAMES_CONF_FILE);
        dbpediaVirtGraph = loader(VIRTUOSO_DBPEIDA_CONF_FILE);
    }

    private VirtGraph loader(String confFile) {
        try {
            PropertiesUtil properties = new PropertiesUtil(confFile);
            String serverHost = properties.getValue("ServerHost");
            String serverPort = properties.getValue("ServerPort");
            String userName = properties.getValue("UserName");
            String password = properties.getValue("Password");
            if (serverHost != null && serverPort != null && userName != null && password != null) {
                String url = "jdbc:virtuoso://" + serverHost + ":" + serverPort;
                return new VirtGraph(url, userName, password);
            } else {
                throw new ConfigException("Virtuoso配置文件出错!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public VirtGraph getGeonamesVirtGraph() {
        return geonamesVirtGraph;
    }

    public VirtGraph getDbpediaVirtGraph() {
        return dbpediaVirtGraph;
    }
}
