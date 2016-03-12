package cn.edu.nju.ws.geokb.connection.mysql;

import cn.edu.nju.ws.geokb.connection.proxy.ConnectionInvocationHandler;
import cn.edu.nju.ws.geokb.connection.proxy.ProxyFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Sloriac on 15/11/16.
 * <p>
 * The implementation of the interface javax.sql.DataSource.
 * This class is thread safe.
 */
public class DataSourcePool {

    private static Logger log = Logger.getLogger(DataSource.class);

    /**
     * GeoNames data source of MySQL.
     */
    private DataSource geonamesDataSource;

    /**
     * Bilingual Chinese-English WordNet data source of MySQL.
     */
    private DataSource wordnetZhDataSource;

    /**
     * The pool of connections to GeoNames database.
     */
    private LinkedList<Connection> geonamesConnections;

    /**
     * The pool of connections to Chinese-English WordNet database.
     */
    private LinkedList<Connection> wordnetZhConnections;

    public DataSourcePool(DataSource geonamesDataSource, DataSource wordnetZhDataSource) {
        this.geonamesDataSource = geonamesDataSource;
        geonamesConnections = geonamesDataSource.getConnections();

        this.wordnetZhDataSource = wordnetZhDataSource;
        wordnetZhConnections = wordnetZhDataSource.getConnections();

        log.error("log4j");
    }

    /**
     * Get the proxy of a connection to GeoNames database.
     *
     * @return the proxy of a connection if the GeoNames connection pool is not empty otherwise null;
     */
    public Connection getGeonamesConnection() {
        try {
            return getConnection(geonamesConnections);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get the proxy of a connection to Chinese-English WordNet database.
     *
     * @return the proxy of a connection if the Chinese-English WordNet connection pool is not empty otherwise null;
     */
    public Connection getWordnetZhConnection() {
        try {
            return getConnection(wordnetZhConnections);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Take out a connection from the specified connection pool.
     * The connection is a proxy so that it can be put back to the connection pool when closed.
     *
     * @param connections the connection pool from which you want to take out a connection.
     * @return the proxy of a connection if the pool is not empty otherwise null.
     * @throws SQLException
     */
    private Connection getConnection(LinkedList<Connection> connections) throws SQLException {
        if (connections.size() > 0) {
            final Connection connection = connections.pop();
            ConnectionInvocationHandler connHandler = new ConnectionInvocationHandler<>(connection, connections);
            return ProxyFactory.instance().createConnection(connHandler);
        } else {
            throw new SQLException("No connection left.");
        }
    }


}
