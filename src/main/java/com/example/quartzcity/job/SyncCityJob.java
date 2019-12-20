package com.example.quartzcity.job;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.quartzcity.model.City;
import com.example.quartzcity.model.CityVO;
import com.example.quartzcity.service.ICityService;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description：同步城市工作</p>
 *
 * @author mojinpeng
 * @version 1.0
 * @date 2019/12/17 15:08
 */
@Slf4j
@Component
public class SyncCityJob extends QuartzJobBean {

    @Resource
    private ICityService cityService;
    public static final String GAODEI_URL = "https://restapi.amap.com/v3/config/district?keywords=%E4%B8%AD%E5%9B%BD&subdistrict=3&key=8d780537348285fdb606f22dd246c249";
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("同步城市开始");
        HttpResponse res = HttpRequest.get(GAODEI_URL).execute();
        String body = res.body();
        JSONObject jsonObject = JSON.parseObject(body);
        // 第一层国家
        JSONArray countryArray = jsonObject.getJSONArray("districts");
        List<CityVO> cityVOS = JSONObject.parseArray(countryArray.toJSONString(), CityVO.class);
        if(cityVOS != null && cityVOS.size()>0){
            // 国家
            cityVOS.forEach((country -> {
                int countryId = cityService.saveOrUpdate(country.convertTO());
                List<CityVO> provinces = country.getDistricts();
                if (provinces != null && provinces.size()>0) {
                    // 省
                    provinces.forEach( (provice -> {
                        City proviceCity = provice.convertTO();
                        proviceCity.setParent(countryId);
                        int provinceId = cityService.saveOrUpdate(proviceCity);
                        // 市
                        List<CityVO> citys = provice.getDistricts();
                        if (citys != null && citys.size()>0) {
                            citys.forEach((city -> {
                                City levelCity = city.convertTO();
                                levelCity.setParent(provinceId);
                                int cityId = cityService.saveOrUpdate(levelCity);
                                // 区
                                List<CityVO> districts = city.getDistricts();
                                if (districts != null && districts.size()>0) {
                                    districts.forEach( (district -> {
                                        City districtCity = district.convertTO();
                                        districtCity.setParent(cityId);
                                        cityService.saveOrUpdate(districtCity);

                                log.info(districtCity.toString());
                                    }));
                                }
                            }));
                        }
                    }));
                }
            }));

        }

        log.info("同步完成");

    }
}
