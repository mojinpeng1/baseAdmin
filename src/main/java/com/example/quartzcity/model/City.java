package com.example.quartzcity.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>Description：城市</p>
 *
 * @author mojinpeng
 * @version 1.0
 * @date 2019/12/13 10:55
 */

@Data
@Table(name = "city")
@Entity
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private Integer cid;

    /**
     * 区域编码
     */
    @Column(name = "adcode")
    private String adCode;

    /**
     * 行政区名称
     */
    @Column(name = "name")
    private  String name;

    /**
     * 城市编码
     */
    @Column(name = "citycode")
    private  String cityCode;

    /**
     * 行政区划级别
     *  country:国家
     *     province:省份（直辖市会在province和city显示）
     *     city:市（直辖市会在province和city显示）
     *     district:区县
     *     street:街道（暂时不用）
     */
    @Column(name = "level")
    private String level;

    /**
     * 坐标点
     */
    @Column(name = "center")
    private String center;

    @Column(name = "parent")
    private  Integer parent;

    /**
     *<p>省份</p>
     */
    public static final String LEVEL_PROVINCE = "province";
    /**
     *<p>市</p>
     */
    public static final String LEVEL_CITY = "city";
    /**
     *<p>区县</p>
     */
    public static final String LEVEL_DISTRICT = "district";

    public City(String adCode, String name, String cityCode, String level, String center) {
        this.adCode = adCode;
        this.name = name;
        this.cityCode = cityCode;
        this.level = level;
        this.center = center;
    }

    public City() {
    }
}
