package cn.edu.nju.ws.geokb.utils;

import cn.edu.nju.ws.geokb.bean.SumoClassCore;
import cn.edu.nju.ws.geokb.constant.UriPrefix;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;

/**
 * Created by Sloriac on 16/3/14.
 */
public class ResultSetUtil {

    public static SumoClassCore sumoClassCoreConvertor(ResultSet resultSet) {
        if (resultSet.hasNext()) {
            SumoClassCore sumoClassCore = new SumoClassCore();
            while (resultSet.hasNext()) {
                QuerySolution result = resultSet.nextSolution();
                RDFNode p = result.get("p");
                RDFNode o = result.get("o");
                String pp = p.toString();
                String oo = o.toString();
                switch (pp) {
                    case UriPrefix.P_TYPE:
                        sumoClassCore.addType(oo);
                        break;
                    case UriPrefix.P_LABEL:
                        sumoClassCore.addLabel(oo);
                        break;
                    case UriPrefix.P_COMMENT:
                        sumoClassCore.addComment(oo);
                        break;
                    case UriPrefix.P_SUBCLASS_OF:
                        sumoClassCore.addSuperClass(oo);
                        break;
                    case UriPrefix.SUMO_P_AXIOM:
                        sumoClassCore.addAxiom(oo);
                        break;
                    case UriPrefix.SUMO_P_EQUIVALENCE_RELATION:
                        sumoClassCore.addEquivalenceRelation(oo);
                        break;
                    case UriPrefix.SUMO_P_ANTI_EQUIVALENCE_RELATION:
                        sumoClassCore.addAntiEquivalenceRelation(oo);
                        break;
                    case UriPrefix.SUMO_P_SUBSUMING_RELATION:
                        sumoClassCore.addSubsumingRelation(oo);
                        break;
                    case UriPrefix.SUMO_P_ANTI_SUBSUMING_RELATION:
                        sumoClassCore.addAntiSubsumingRelation(oo);
                        break;
                    case UriPrefix.SUMO_P_INSTANCE_RELATION:
                        sumoClassCore.addInstanceRelation(oo);
                        break;
                    case UriPrefix.SUMO_P_EXTERNAL_IMAGE:
                        sumoClassCore.addExternalImage(oo);
                        break;
                }
            }
            return sumoClassCore;
        }
        return null;
    }
}
