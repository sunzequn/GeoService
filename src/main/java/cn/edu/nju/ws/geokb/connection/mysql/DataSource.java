package cn.edu.nju.ws.geokb.connection.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Sloriac on 16/3/9.
 *
 * Datasource of MySQL.
 */
public class DataSource {

    /**
     * The pool of connections.
     */
    private LinkedList<Connection> connections = new LinkedList<>();

    private String mysqlDriver;

    private String jdbcUrl;

    private String user;

    private String password;

    private int poolSize;

    public DataSource(String mysqlDriver, String jdbcUrl, String user, String password, int poolSize) throws SQLException, ClassNotFoundException {
        this.mysqlDriver = mysqlDriver;
        this.jdbcUrl = jdbcUrl;
        this.user = user;
        this.password = password;
        this.poolSize = poolSize;
        initConnections();
    }

    private void initConnections() throws ClassNotFoundException, SQLException {
        Class.forName(mysqlDriver);
        for (int i = 0; i < poolSize; i++) {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            connections.add(connection);
            System.out.println(connection);
        }
    }

    public LinkedList<Connection> getConnections() {
        if (connections.size() > 0) {
            return connections;
        }
        return null;
    }
}
