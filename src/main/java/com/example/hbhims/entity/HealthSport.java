package com.example.hbhims.entity;

import com.example.hbhims.TimestampLongConverter;

import javax.persistence.*;

/**
 * 运动记录表(HealthSport)实体类
 *
 * @author qq1962247851
 * @date 2020/4/20 10:45
 */
@Entity
public class HealthSport {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "health_sport_seq")
    @TableGenerator(name = "health_sport_seq",
            allocationSize = 1,//自动增长，设置为1
            pkColumnName = "sequence_name", //表里用来保存主键名字的字段
            valueColumnName = "sequence_next_hi_value",//表里用来保存主键值的字段
            pkColumnValue = "health_sport_id"//表里名字字段对应的值
    )
    private Long id;
    /**
     * 用户id
     **/
    @Column(nullable = false)
    private Long userId;
    /**
     * 运动日期
     */
    @Convert(converter = TimestampLongConverter.class)
    @Column(nullable = false)
    private Long date;
    /**
     * 步数
     */
    @Column(nullable = false, length = 10)
    private Integer stepValue;
    /**
     * 距离
     */
    @Column(nullable = false, length = 10)
    private Float distance;
    /**
     * 能量消耗
     */
    @Column(nullable = false, length = 10)
    private Float calorie;

    public HealthSport() {
    }

    public HealthSport(Long id, Long userId, Long date, Integer stepValue, Float distance, Float calorie) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.stepValue = stepValue;
        this.distance = distance;
        this.calorie = calorie;
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

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getStepValue() {
        return stepValue;
    }

    public void setStepValue(Integer stepValue) {
        this.stepValue = stepValue;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Float getCalorie() {
        return calorie;
    }

    public void setCalorie(Float calorie) {
        this.calorie = calorie;
    }
}
