package cn.edu.nju.ws.geokb.connection.mysql;

import cn.edu.nju.ws.geokb.connection.mysql.DataSource;
import cn.edu.nju.ws.geokb.connection.proxy.ConnectionInvocationHandler;
import cn.edu.nju.ws.geokb.connection.proxy.ProxyFactory;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by Sloriac on 15/11/16.
 * <p>
 * The implementation of the interface javax.sql.DataSource.
 * This class is thread safe.
 */
public class DataSourcePool {

    /**
     * The data source of MySQL.
     */
    private DataSource geonamesDataSource;
    /**
     * The pool of connections.
     */
    private LinkedList<Connection> geonamesConnections;

    public DataSourcePool(DataSource geonamesDataSource) {
        this.geonamesDataSource = geonamesDataSource;
    }

    /**
     * Get the proxy of a connection to geonames.
     *
     * @return the proxy of a connection if the geonames connection pool is not empty otherwise null;
     * @throws SQLException
     */
    public Connection getGeonamesConnection() throws SQLException {
        return getConnetcion(geonamesConnections);
    }

    private Connection getConnetcion(LinkedList<Connection> connections) throws SQLException {
        if (connections.size() > 0) {
            final Connection connection = connections.pop();
            ConnectionInvocationHandler connHandler = new ConnectionInvocationHandler(connection, connections);
            return ProxyFactory.instance().createConnection(connHandler);
        } else {
            throw new SQLException("No connection left.");
        }
    }


}