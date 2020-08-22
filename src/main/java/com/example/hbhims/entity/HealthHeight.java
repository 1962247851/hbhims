package com.example.hbhims.entity;

import com.example.hbhims.TimestampLongConverter;

import javax.persistence.*;

/**
 * 身高表(HealthHeight)实体类
 *
 * @author qq1962247851
 * @date 2020/4/20 10:36
 */
@Entity
public class HealthHeight {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "health_height_seq")
    @TableGenerator(name = "health_height_seq",
            allocationSize = 1,//自动增长，设置为1
            pkColumnName = "sequence_name", //表里用来保存主键名字的字段
            valueColumnName = "sequence_next_hi_value",//表里用来保存主键值的字段
            pkColumnValue = "health_height_id"//表里名字字段对应的值
    )
    private Long id;
    /**
     * 用户id
     **/
    @Column(nullable = false, unique = true)
    private Long userId;
    /**
     * 测量身高值
     */
    @Column(nullable = false, length = 10)
    private Float heightData;
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

    public HealthHeight() {
    }

    public HealthHeight(Long id, Long userId, Float heightData, Long measureTime, String measureDevice) {
        this.id = id;
        this.userId = userId;
        this.heightData = heightData;
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

    public Float getHeightData() {
        return heightData;
    }

    public void setHeightData(Float heightData) {
        this.heightData = heightData;
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
