package com.example.hbhims.entity;

import com.example.hbhims.TimestampLongConverter;

import javax.persistence.*;

/**
 * 血氧表(HealthBloodOxygen)实体类
 *
 * @author qq1962247851
 * @date 2020/4/20 11:10
 */
@Entity
public class HealthBloodOxygen {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "health_blood_oxygen_seq")
    @TableGenerator(name = "health_blood_oxygen_seq",
            allocationSize = 1,//自动增长，设置为1
            pkColumnName = "sequence_name", //表里用来保存主键名字的字段
            valueColumnName = "sequence_next_hi_value",//表里用来保存主键值的字段
            pkColumnValue = "health_blood_oxygen_id"//表里名字字段对应的值
    )
    private Long id;
    /**
     * 用户id
     **/
    @Column(nullable = false)
    private Long userId;
    /**
     * 测量数据
     */
    @Column(nullable = false, columnDefinition = "tinyint(3)", length = 3)
    private Integer measureData;
    /**
     * 测量时间
     */
    @Convert(converter = TimestampLongConverter.class)
    @Column(nullable = false)
    private Long measureTime;
    /**
     * 测量设备
     */
    @Column(length = 50)
    private String measureDevice;

    public HealthBloodOxygen() {
    }

    public HealthBloodOxygen(Long id, Long userId, Integer measureData, Long measureTime, String measureDevice) {
        this.id = id;
        this.userId = userId;
        this.measureData = measureData;
        this.measureTime = measureTime;
        this.measureDevice = measureDevice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getMeasureData() {
        return measureData;
    }

    public void setMeasureData(Integer measureData) {
        this.measureData = measureData;
    }

    public Long getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(Long measureTime) {
        this.measureTime = measureTime;
    }

    public String getMeasureDevice() {
        return measureDevice;
    }

    public void setMeasureDevice(String measureDevice) {
        this.measureDevice = measureDevice;
    }
}
