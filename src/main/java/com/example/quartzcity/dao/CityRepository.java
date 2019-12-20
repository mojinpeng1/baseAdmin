package com.example.quartzcity.dao;


import com.example.quartzcity.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description：</p>
 *
 * @author mojinpeng
 * @version 1.0
 * @date 2019/12/13 11:45
 */
@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    @Query(value = " from City where name = :name ")
    List<City> getCityBy(String name);

    /**
     * <p>方法名:queryCitys</p>
     * <p>描述: 分页查询</p>
     * <p>创建时间: 2019/12/19 18:39</p>
     * @param pageNum 开始页面
     * @param pageSize  查询条数
     * @return  List
     * @author mojinpeng
     */

}