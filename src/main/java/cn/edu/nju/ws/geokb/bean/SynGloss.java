package cn.edu.nju.ws.geokb.bean;

import java.math.BigDecimal;

/**
 * Created by Sloriac on 16/3/12.
 */
public class SynGloss {

    private BigDecimal synset_id;
    private String gloss;

    public SynGloss() {
    }

    public SynGloss(BigDecimal synset_id, String gloss) {
        this.synset_id = synset_id;
        this.gloss = gloss;
    }

    public BigDecimal getSynset_id() {
        return synset_id;
    }

    public void setSynset_id(BigDecimal synset_id) {
        this.synset_id = synset_id;
    }

    public String getGloss() {
        return gloss;
    }

    public void setGloss(String gloss) {
        this.gloss = gloss;
    }

    @Override
    public String toString() {
        return "Synset{" +
                "synset_id=" + synset_id +
                ", gloss='" + gloss + '\'' +
                '}';
    }
}
