package cn.edu.nju.ws.geokb.connection.proxy;

import virtuoso.jena.driver.VirtGraph;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * Created by Sloriac on 16/3/9.
 * <p>
 * Create proxy implementations of JDBC interfaces.
 * This class is thread safe.
 */
public class ProxyFactory {

    /**
     * The Singleton instance of this class.
     */
    private static final ProxyFactory instance = new ProxyFactory();

    /**
     * Returns the Singleton instance of this class.
     *
     * @return singleton instance
     */
    public static ProxyFactory instance() {
        return instance;
    }

    /**
     * Constructor for creating the Singleton instance of this class.
     */
    private ProxyFactory() {
        super();
    }

    /**
     * Convenience method to generate a single-interface proxy using the handler's classloader
     *
     * @param <T>     The type of object to proxy
     * @param type    The type of object to proxy
     * @param handler The handler that intercepts/overrides method calls.
     * @return proxied object
     */
    public <T> T newProxyInstance(Class<T> type, InvocationHandler handler) {
        return type.cast(Proxy.newProxyInstance(handler.getClass().getClassLoader(), new Class<?>[]{type}, handler));
    }

    /**
     * Creates a new proxy <code>Connection</code> object.
     *
     * @param handler The handler that intercepts/overrides method calls.
     * @return proxied Connection
     */
    public Connection createConnection(InvocationHandler handler) {
        return newProxyInstance(Connection.class, handler);
    }

    public VirtGraph createGraph(InvocationHandler handler) {
        return newProxyInstance(VirtGraph.class, handler);
    }
}
