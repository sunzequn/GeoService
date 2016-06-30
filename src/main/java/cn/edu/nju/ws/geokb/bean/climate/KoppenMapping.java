package cn.edu.nju.ws.geokb.bean.climate;

/**
 * Created by sunzequn on 2016/6/30.
 */
public class KoppenMapping {

    private String koppentype;
    private String zhongxuetype;
    private String description;

    public KoppenMapping() {
    }

    public KoppenMapping(String koppentype, String zhongxuetype, String description) {
        this.koppentype = koppentype;
        this.zhongxuetype = zhongxuetype;
        this.description = description;
    }

    public String getKoppentype() {
        return koppentype;
    }

    public void setKoppentype(String koppentype) {
        this.koppentype = koppentype;
    }

    public String getZhongxuetype() {
        return zhongxuetype;
    }

    public void setZhongxuetype(String zhongxuetype) {
        this.zhongxuetype = zhongxuetype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "KoppenMapping{" +
                "koppentype='" + koppentype + '\'' +
                ", zhongxuetype='" + zhongxuetype + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
