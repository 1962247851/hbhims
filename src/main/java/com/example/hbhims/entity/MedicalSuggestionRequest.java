package com.example.hbhims.entity;

import com.example.hbhims.DateLongConverter;

import javax.persistence.*;

/**
 * 医疗意见和建议请求表(MedicalSuggestionRequest)实体类
 *
 * @author qq1962247851
 * @date 2020/5/10 12:53
 */
@Entity
public class MedicalSuggestionRequest {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "medical_suggestion_request_seq")
    @TableGenerator(name = "medical_suggestion_request_seq",
            allocationSize = 1,//自动增长，设置为1
            pkColumnName = "sequence_name", //表里用来保存主键名字的字段
            valueColumnName = "sequence_next_hi_value",//表里用来保存主键值的字段
            pkColumnValue = "medical_suggestion_request_id"//表里名字字段对应的值
    )
    private Long id;
    /**
     * 请求者的id
     */
    @Column(nullable = false)
    private Long userId;
    /**
     * 被请求者的id
     */
    @Column(nullable = false)
    private Long professionalId;
    /**
     * 图片url
     */
    @Column(nullable = false, length = 1000)
    private String healthDataImageUrl;
    /**
     * 时间
     */
    @Column(nullable = false)
    @Convert(converter = DateLongConverter.class)
    private Long time;

    public MedicalSuggestionRequest() {
    }

    public MedicalSuggestionRequest(Long id, Long userId, Long professionalId, String healthDataImageUrl, Long time) {
        this.id = id;
        this.userId = userId;
        this.professionalId = professionalId;
        this.healthDataImageUrl = healthDataImageUrl;
        this.time = time;
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

    public Long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getHealthDataImageUrl() {
        return healthDataImageUrl;
    }

    public void setHealthDataImageUrl(String healthDataImageUrl) {
        this.healthDataImageUrl = healthDataImageUrl;
    }
}
