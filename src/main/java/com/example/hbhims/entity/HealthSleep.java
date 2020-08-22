package com.example.hbhims.entity;

import com.example.hbhims.DateLongConverter;
import com.example.hbhims.TimestampLongConverter;

import javax.persistence.*;

/**
 * 睡眠质量表(HealthSleep)实体类
 *
 * @author qq1962247851
 * @date 2020/4/20 10:48
 */
@Entity
public class HealthSleep {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "health_sleep_seq")
    @TableGenerator(name = "health_sleep_seq",
            allocationSize = 1,//自动增长，设置为1
            pkColumnName = "sequence_name", //表里用来保存主键名字的字段
            valueColumnName = "sequence_next_hi_value",//表里用来保存主键值的字段
            pkColumnValue = "health_sleep_id"//表里名字字段对应的值
    )
    private Long id;
    /**
     * 用户id
     **/
    @Column(nullable = false)
    private Long userId;
    /**
     * 上床时间
     */
    @Convert(converter = TimestampLongConverter.class)
    @Column(nullable = false)
    private Long startTime;
    /**
     * 起床时间
     */
    @Convert(converter = TimestampLongConverter.class)
    @Column(nullable = false)
    private Long endTime;
    /**
     * 总时间
     */
    @Column(nullable = false)
    private Long totalTime;
    /**
     * 日期
     */
    @Convert(converter = DateLongConverter.class)
    @Column(nullable = false, unique = true)
    private Long date;
    /**
     * 测量设备
     */
    @Column(length = 50)
    private String measureDevice;

    public HealthSleep() {
    }

    public HealthSleep(Long id, Long userId, Long startTime, Long endTime, Long totalTime, Long date, String measureDevice) {
        this.id = id;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalTime = totalTime;
        this.date = date;
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

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getMeasureDevice() {
        return measureDevice;
    }

    public void setMeasureDevice(String measureDevice) {
        this.measureDevice = measureDevice;
    }
}
