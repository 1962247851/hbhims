package com.example.hbhims.entity;

import com.example.hbhims.TimestampLongConverter;

import javax.persistence.*;

/**
 * 体重表(HealthWeight)实体类
 *
 * @author qq1962247851
 * @date 2020/4/20 10:43
 */
@Entity
public class HealthWeight {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "health_weight_seq")
    @TableGenerator(name = "health_weight_seq",
            allocationSize = 1,//自动增长，设置为1
            pkColumnName = "sequence_name", //表里用来保存主键名字的字段
            valueColumnName = "sequence_next_hi_value",//表里用来保存主键值的字段
            pkColumnValue = "health_weight_id"//表里名字字段对应的值
    )
    private Long id;
    /**
     * 用户id
     **/
    @Column(nullable = false)
    private Long userId;
    /**
     * 测量体重值
     */
    @Column(nullable = false, length = 10)
    private Float weightData;
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

    public HealthWeight() {
    }

    public HealthWeight(Long id, Long userId, Float weightData, Long measureTime, String measureDevice) {
        this.id = id;
        this.userId = userId;
        this.weightData = weightData;
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

    public Float getWeightData() {
        return weightData;
    }

    public void setWeightData(Float heightData) {
        this.weightData = heightData;
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
