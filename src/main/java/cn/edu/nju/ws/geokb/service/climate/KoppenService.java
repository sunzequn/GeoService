package cn.edu.nju.ws.geokb.service.climate;

import cn.edu.nju.ws.geokb.bean.climate.Koppen;
import cn.edu.nju.ws.geokb.dao.query.climate.KoppenDao;
import cn.edu.nju.ws.geokb.handler.grid.FindGrid;
import cn.edu.nju.ws.geokb.handler.grid.Grid;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzequn on 2016/6/29.
 */
@Service
public class KoppenService implements InitializingBean {

    @Autowired
    private KoppenDao koppenDao;
    @Autowired
    private FindGrid findGrid;
    private List<List<Grid>> koppenGrid;
    private List<List<Grid>> gpcpGrid;

    public KoppenService() {

    }

    /**
     * 根据经纬度获得Koppen气候类型
     *
     * @param lng
     * @param lat
     * @return
     */
    public String getKoppenTypeByLntLat(double lng, double lat) {
        Grid grid = findGrid.find(lng, lat, koppenGrid);
        System.out.println("获得最近的点：" + grid);
        if (grid != null) {
            Koppen koppen = koppenDao.getByLngLat(grid.getLongitude(), grid.getLatitude());
            if (koppen != null) {
                return koppen.getType();
            }
        }
        return null;
    }

    private Grid findGpcpGrid(double lng, double lat) {
        return findGrid.find(lng, lat, gpcpGrid);
    }


    private List<List<Grid>> gpcpGrid() {
        List<List<Grid>> res = new ArrayList<>();
        double lat = 91.25;
        for (int i = 0; i < 72; i++) {
            lat -= 2.5;
            double lng = -181.25;
            List<Grid> row = new ArrayList<>();
            for (int j = 0; j < 144; j++) {
                lng += 2.5;
                row.add(new Grid(lng, lat));
            }
            res.add(row);
        }
        return res;
    }

    private List<List<Grid>> koppenGrid() {
        List<Koppen> koppens = koppenDao.getAll();
        List<List<Grid>> res = new ArrayList<>();
        List<Grid> row = new ArrayList<>();
        double latFlag = -9999;
        for (Koppen koppen : koppens) {
            if (koppen.getLatitude() != latFlag) {
                if (latFlag > -9999) {
                    res.add(row);
                }
                row = new ArrayList<>();
            }
            row.add(new Grid(koppen.getLongitude(), koppen.getLatitude()));
            latFlag = koppen.getLatitude();
        }
        res.add(row);
        return res;
    }

    //实现这个方法，是在初始化实例之后调用，不这样的话，没法调用依赖的koppenDao
    @Override
    public void afterPropertiesSet() throws Exception {
        koppenGrid = koppenGrid();
        gpcpGrid = gpcpGrid();
    }
}
