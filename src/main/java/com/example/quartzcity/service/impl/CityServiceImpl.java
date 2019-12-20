package com.example.quartzcity.service.impl;

import com.example.base.Paging;
import com.example.base.ResultInfo;
import com.example.quartzcity.dao.CityRepository;
import com.example.quartzcity.model.City;
import com.example.quartzcity.service.ICityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description：</p>
 *
 * @author mojinpeng
 * @version 1.0
 * @date 2019/12/13 11:18
 */
@Service(value = "cityService")
public class CityServiceImpl implements ICityService {
    @Resource
    protected CityRepository cityRepository;

    @Override
    public int save(City city) {
        City save = cityRepository.save(city);
        return save.getCid();
    }

    @Override
    public int saveOrUpdate(City city) {
        City dataCity = this.getCityBy(city.getName());
        if (dataCity != null) {

            dataCity.setParent(city.getParent());
            dataCity.setLevel(city.getLevel());
            dataCity.setCityCode(city.getCityCode());
            dataCity.setAdCode(city.getAdCode());
            dataCity.setCenter(city.getCenter());
        } else {
            dataCity = city;
        }
        return this.save(dataCity);


    }

    @Override
    public City getCityBy(String name) {
        List<City> citys = cityRepository.getCityBy(name);
        if (citys != null && citys.size() == 1) {
            return citys.get(0);
        }
        return null;
    }

    @Override
    public List<City> findProvince(String name) {
        City city = new City();

        city.setParent(1);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("parent", ExampleMatcher.GenericPropertyMatchers.exact());
        if (StringUtils.isNotBlank(name)) {
            city.setName(name);
            exampleMatcher.withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        }

        Example<City> example = Example.of(city, exampleMatcher);
        return cityRepository.findAll(example);
    }

    @Override
    public List<City> findCitys(String name, Integer parentId) throws Exception {
        if (parentId == null || parentId < 1) {
            throw new Exception("请确认父级单位!");
        }
        City city = new City();
        city.setParent(parentId);
        if (StringUtils.isNotBlank(name)) {
            city.setName(name);
            ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
            Example<City> example = Example.of(city, exampleMatcher);
            return cityRepository.findAll(example);
        }
        Example<City> of = Example.of(city);
        return cityRepository.findAll(of);
    }

    @Override
    public ResultInfo queryCitys(Paging page) {

        Pageable pageable = PageRequest.of(page.getPageNum(),page.getPageSize());
        Page<City> all = cityRepository.findAll(pageable);
        page.setTotalSize((int) all.getTotalElements());
        page.setData(all.getContent());
        return  ResultInfo.success(page);
    }

}
