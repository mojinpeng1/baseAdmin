package com.example.quartzcity.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.base.Paging;
import com.example.base.ResultInfo;
import com.example.quartzcity.model.City;
import com.example.quartzcity.service.ICityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description：城市选择</p>
 *
 * @author mojinpeng
 * @version 1.0
 * @date 2019/12/18 9:06
 */
@RestController
@RequestMapping(value = "/city")
@Slf4j
public class CityController {
    @Resource
    private ICityService cityService;

    @GetMapping(value = "/findProvince")
    public ResultInfo findProvince(@RequestParam(required = false) String name){
        List<City> province = cityService.findProvince(name);
        return  ResultInfo.success(province);
    }
    @GetMapping(value = "findCitys")
    public  ResultInfo findCitys(@RequestParam(required = false)String name,@RequestParam Integer parentId){
        try {
            List<City> citys = cityService.findCitys(name, parentId);
            return  ResultInfo.success(citys);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultInfo.error(e.getMessage());
        }
    }

    @PostMapping(value = "queryCitys")
    public ResultInfo queryCitys(@RequestBody JSONObject data){
        Integer pageNum = data.getInteger("pageNum");
        Integer pageSize = data.getInteger("pageSize");
        Paging page = new Paging();
        page.setPageSize(pageSize);
        page.setPageNum(pageNum);
        ResultInfo resultInfo = cityService.queryCitys(page);
        return resultInfo;
    }
}
