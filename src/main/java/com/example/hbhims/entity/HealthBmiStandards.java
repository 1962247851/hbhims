package com.example.hbhims.entity;

import javax.persistence.*;

/**
 * BMI健康指标表(HealthBMIStandards)实体类
 *
 * @author qq1962247851
 * @date 2020/5/1 18:58
 */
@Entity
public class HealthBmiStandards {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "health_bmi_standards_seq")
    @TableGenerator(name = "health_bmi_standards_seq",
            allocationSize = 1,//自动增长，设置为1
            pkColumnName = "sequence_name", //表里用来保存主键名字的字段
            valueColumnName = "sequence_next_hi_value",//表里用来保存主键值的字段
            pkColumnValue = "health_bmi_standards_id"//表里名字字段对应的值
    )
    private Long id;
    /**
     * 性别（男1，女0）
     */
    @Column(columnDefinition = "bit(1) default 1", nullable = false)
    private Boolean sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * BMI健康范围（mmHg）
     * 18.5,24,27
     */
    private String bmiRange;

    public HealthBmiStandards() {
    }

    public HealthBmiStandards(Long id, Boolean sex, Integer age, String bmiRange) {
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.bmiRange = bmiRange;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBmiRange() {
        return bmiRange;
    }

    public void setBmiRange(String BMIRange) {
        this.bmiRange = BMIRange;
    }
}
