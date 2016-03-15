package cn.edu.nju.ws.geokb.bean.sumo;

import java.math.BigDecimal;

/**
 * Created by Sloriac on 16/3/12.
 * <p>
 * The chinese translation of synset in WordNet.
 */
public class SynsetZh {

    private BigDecimal synset_id;
    private BigDecimal w_num;
    private String chinese;

    public SynsetZh() {
    }

    public SynsetZh(BigDecimal synset_id, BigDecimal w_num, String chinese) {
        this.synset_id = synset_id;
        this.w_num = w_num;
        this.chinese = chinese;
    }

    public BigDecimal getSynset_id() {
        return synset_id;
    }

    public void setSynset_id(BigDecimal synset_id) {
        this.synset_id = synset_id;
    }

    public BigDecimal getW_num() {
        return w_num;
    }

    public void setW_num(BigDecimal w_num) {
        this.w_num = w_num;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }


    @Override
    public String toString() {
        return "SynsetZh{" +
                "synset_id=" + synset_id +
                ", w_num=" + w_num +
                ", chinese='" + chinese + '\'' +
                '}';
    }
}
