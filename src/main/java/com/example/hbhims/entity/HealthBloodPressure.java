package com.example.hbhims.entity;

import com.example.hbhims.TimestampLongConverter;

import javax.persistence.*;

/**
 * 血压表(HealthBloodPressure)实体类
 *
 * @author qq1962247851
 * @date 2020/4/20 10:54
 */
@Entity
public class HealthBloodPressure {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "health_blood_pressure_seq")
    @TableGenerator(name = "health_blood_pressure_seq",
            allocationSize = 1,//自动增长，设置为1
            pkColumnName = "sequence_name", //表里用来保存主键名字的字段
            valueColumnName = "sequence_next_hi_value",//表里用来保存主键值的字段
            pkColumnValue = "health_blood_pressure_id"//表里名字字段对应的值
    )
    private Long id;
    /**
     * 用户id
     **/
    @Column(nullable = false)
    private Long userId;
    /**
     * 高压
     */
    @Column(nullable = false, columnDefinition = "tinyint(3)", length = 3)
    private Integer highPressure;
    /**
     * 低压
     */
    @Column(nullable = false, columnDefinition = "tinyint(3)", length = 3)
    private Integer lowPressure;
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

    public HealthBloodPressure() {
    }

    public HealthBloodPressure(Long id, Long userId, Integer highPressure, Integer lowPressure, Long measureTime, String measureDevice) {
        this.id = id;
        this.userId = userId;
        this.highPressure = highPressure;
        this.lowPressure = lowPressure;
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

    public Integer getHighPressure() {
        return highPressure;
    }

    public void setHighPressure(Integer highPressure) {
        this.highPressure = highPressure;
    }

    public Integer getLowPressure() {
        return lowPressure;
    }

    public void setLowPressure(Integer lowPressure) {
        this.lowPressure = lowPressure;
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
