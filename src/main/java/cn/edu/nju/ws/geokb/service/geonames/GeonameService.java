package cn.edu.nju.ws.geokb.service.geonames;

import cn.edu.nju.ws.geokb.bean.geonames.Geoname;
import cn.edu.nju.ws.geokb.dao.query.geonames.GeonameDao;
import cn.edu.nju.ws.geokb.dao.sparql.geonames.GeonameSparql;
import cn.edu.nju.ws.geokb.utils.GeoNameUtil;
import cn.edu.nju.ws.geokb.utils.ListUtil;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzequn on 2016/6/30.
 */
@Service
public class GeonameService {
    @Autowired
    private GeonameSparql geonameSparql;
    @Autowired
    private GeonameDao geonameDao;

    public List<Geoname> getByChineseName(String zhName) throws Exception {
        ResultSet resultSet = geonameSparql.getByChineseName(zhName);
        List<Geoname> geonames = new ArrayList<>();
        while (resultSet.hasNext()) {
            QuerySolution querySolution = resultSet.next();
            RDFNode uri = querySolution.get("s");
            int id = GeoNameUtil.parseId(uri.toString());
            Geoname geoname = geonameDao.getById(id);
            if (geoname != null) {
                geonames.add(geoname);
            }
        }
        if (ListUtil.isEmpty(geonames)) {
            return null;
        }
        return geonames;
    }
}
