package com.example.quartzcity.service;

import com.example.base.Paging;
import com.example.base.ResultInfo;
import com.example.quartzcity.model.City;

import java.util.List;

/**
 * <p>Description：</p>
 *
 * @author mojinpeng
 * @version 1.0
 * @date 2019/12/13 11:17
 */
public interface ICityService {

    int save(City city);



    int saveOrUpdate(City city);
    
    /**
     * <p>方法名:getCityBy</p>
     * <p>描述: 通过城市名称查询</p>
     * <p>创建时间: 2019/12/17 17:16</p>
     * @param name
     * @return City
     * @author mojinpeng
     */
    City getCityBy(String name);

    /**
     * <p>查询省份</p>
     * @param name 身份的名称
     * @return List
     */
    List<City> findProvince(String name);

/**
 * <p>方法名:findCitys</p>
 * <p>描述: 查询下级单位</p>
 * <p>创建时间: 2019/12/18 10:55</p>
 * @param name 模糊查询名称
 * @param parentId  父级id
 * @return List
 * @author mojinpeng
 */
    List<City> findCitys(String name,Integer parentId) throws Exception;

    /**
     * <p>方法名:queryCitys</p>
     * <p>描述: 分页查询</p>
     * <p>创建时间: 2019/12/19 18:28</p>
     * @param   page  分页信息
     * @return  ResultInfo
     * @author mojinpeng
     */
    ResultInfo queryCitys(Paging page);
}