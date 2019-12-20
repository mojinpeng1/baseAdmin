package com.example.quartzcity.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description：</p>
 *
 * @author mojinpeng
 * @version 1.0
 * @date 2019/12/17 15:58
 */
@Data
public class CityVO implements Serializable {
    private String citycode;
    private String adcode;
    private String name;
    private String center;
    private String level;
    private List<CityVO> districts;

    public  City convertTO(){
        City city = new City();
        if( "".equals(this.citycode) || "[]".equals(this.citycode) ){
            city.setCityCode(null);
        }else{
            city.setCityCode(this.citycode);
        }
        city.setAdCode(adcode);
        city.setName(this.name);
        city.setCenter(this.center);
        city.setLevel(this.level);
        return  city;
    }
}
