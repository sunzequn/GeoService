package cn.edu.nju.ws.geokb.bean;

import java.math.BigDecimal;

/**
 * Created by Sloriac on 16/3/12.
 */
public class Synset {

    private BigDecimal synset_id;
    private BigDecimal w_num;
    private String word;
    private String ss_type;
    private BigDecimal sense_number;
    private BigDecimal tag_count;
    private BigDecimal word_count;
    private String word_chs;

    public Synset() {
    }

    public Synset(BigDecimal synset_id, BigDecimal w_num, String word, String ss_type, BigDecimal sense_number, BigDecimal tag_count, BigDecimal word_count, String word_chs) {
        this.synset_id = synset_id;
        this.w_num = w_num;
        this.word = word;
        this.ss_type = ss_type;
        this.sense_number = sense_number;
        this.tag_count = tag_count;
        this.word_count = word_count;
        this.word_chs = word_chs;
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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSs_type() {
        return ss_type;
    }

    public void setSs_type(String ss_type) {
        this.ss_type = ss_type;
    }

    public BigDecimal getSense_number() {
        return sense_number;
    }

    public void setSense_number(BigDecimal sense_number) {
        this.sense_number = sense_number;
    }

    public BigDecimal getTag_count() {
        return tag_count;
    }

    public void setTag_count(BigDecimal tag_count) {
        this.tag_count = tag_count;
    }

    public BigDecimal getWord_count() {
        return word_count;
    }

    public void setWord_count(BigDecimal word_count) {
        this.word_count = word_count;
    }

    public String getWord_chs() {
        return word_chs;
    }

    public void setWord_chs(String word_chs) {
        this.word_chs = word_chs;
    }


    @Override
    public String toString() {
        return "Synset{" +
                "synset_id=" + synset_id +
                ", w_num=" + w_num +
                ", word='" + word + '\'' +
                ", ss_type='" + ss_type + '\'' +
                ", sense_number=" + sense_number +
                ", tag_count=" + tag_count +
                ", word_count=" + word_count +
                ", word_chs='" + word_chs + '\'' +
                '}';
    }
}
