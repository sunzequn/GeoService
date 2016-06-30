package cn.edu.nju.ws.geokb.service.climate;

import cn.edu.nju.ws.geokb.bean.climate.Koppen;
import cn.edu.nju.ws.geokb.bean.climate.KoppenMapping;
import cn.edu.nju.ws.geokb.dao.query.climate.KoppenDao;
import cn.edu.nju.ws.geokb.dao.query.climate.KoppenMappingDao;
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
    private KoppenMappingDao koppenMappingDao;
    @Autowired
    private FindGrid findGrid;
    private List<List<Grid>> koppenGrid;

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

    public String getZhongxueTypeByLntLat(double lng, double lat) {
        Grid grid = findGrid.find(lng, lat, koppenGrid);
        System.out.println("获得最近的点：" + grid);
        if (grid != null) {
            Koppen koppen = koppenDao.getByLngLat(grid.getLongitude(), grid.getLatitude());
            if (koppen != null) {
                KoppenMapping koppenMapping = koppenMappingDao.getByKoppenType(koppen.getType());
                return koppenMapping.getZhongxuetype();
            }
        }
        return null;
    }

    public String getDesByLntLat(double lng, double lat) {
        Grid grid = findGrid.find(lng, lat, koppenGrid);
        System.out.println("获得最近的点：" + grid);
        if (grid != null) {
            Koppen koppen = koppenDao.getByLngLat(grid.getLongitude(), grid.getLatitude());
            if (koppen != null) {
                KoppenMapping koppenMapping = koppenMappingDao.getByKoppenType(koppen.getType());
                return koppenMapping.getDescription();
            }
        }
        return null;
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
    }
}
