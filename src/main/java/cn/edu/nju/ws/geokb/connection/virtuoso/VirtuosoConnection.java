package cn.edu.nju.ws.geokb.connection.virtuoso;

import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by sunzequn on 2016/6/30.
 */
public class VirtuosoConnection {

    private String prefix;
    private String suffix;

    public VirtuosoConnection(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public ResultSet parser(String sparql) throws Exception {
        ParameterizedSparqlString sparqlstr = new ParameterizedSparqlString(sparql);
        //utf-8
        URL queryURL = new URL(prefix + URLEncoder.encode(sparqlstr.toString(), "UTF-8") + suffix);
        URLConnection connAPI = queryURL.openConnection();
        connAPI.setConnectTimeout(6000);
        connAPI.connect();
        return ResultSetFactory.fromXML(connAPI.getInputStream());
    }
}
