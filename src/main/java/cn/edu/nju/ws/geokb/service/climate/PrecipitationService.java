package cn.edu.nju.ws.geokb.service.climate;

import cn.edu.nju.ws.geokb.bean.climate.Precipitation;
import cn.edu.nju.ws.geokb.dao.query.climate.PrecipitationDao;
import cn.edu.nju.ws.geokb.handler.grid.FindGrid;
import cn.edu.nju.ws.geokb.handler.grid.Grid;
import cn.edu.nju.ws.geokb.utils.MonthUtil;
import cn.edu.nju.ws.geokb.utils.YearUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzequn on 2016/6/30.
 */
@Service
public class PrecipitationService implements InitializingBean {

    @Autowired
    private PrecipitationDao precipitationDao;
    @Autowired
    private FindGrid findGrid;
    private List<List<Grid>> gpcpGrid;

    /**
     * 获得地点的某年某月的日均降水量
     *
     * @param lng
     * @param lat
     * @param year
     * @param month
     * @return
     */
    public double getDailyPrecipitation(double lng, double lat, int year, int month) {
        Grid grid = findGpcpGrid(lng, lat);
        Precipitation precipitation = precipitationDao.getByKey(grid.getLongitude(), grid.getLatitude(), year, month);
        return precipitation.getPrecipitation();
    }

    /**
     * 获得地点的某年某月的总降水量
     *
     * @param lng
     * @param lat
     * @param year
     * @param month
     * @return
     */
    public double getMonthlyPrecipitation(double lng, double lat, int year, int month) {
        Grid grid = findGpcpGrid(lng, lat);
        Precipitation precipitation = precipitationDao.getByKey(grid.getLongitude(), grid.getLatitude(), year, month);
        return precipitation.getPrecipitation() * MonthUtil.daysOfMonth(year, month);
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

    @Override
    public void afterPropertiesSet() throws Exception {
        this.gpcpGrid = gpcpGrid();
    }
}
