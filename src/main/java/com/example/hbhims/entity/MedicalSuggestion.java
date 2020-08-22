package com.example.hbhims.entity;

import com.example.hbhims.TimestampLongConverter;

import javax.persistence.*;

/**
 * 医疗意见和建议表(MedicalSuggestion)实体类
 *
 * @author qq1962247851
 * @date 2020/4/25 17:20
 */
@Entity
public class MedicalSuggestion {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "medical_suggestion_seq")
    @TableGenerator(name = "medical_suggestion_seq",
            allocationSize = 1,//自动增长，设置为1
            pkColumnName = "sequence_name", //表里用来保存主键名字的字段
            valueColumnName = "sequence_next_hi_value",//表里用来保存主键值的字段
            pkColumnValue = "medical_suggestion_id"//表里名字字段对应的值
    )
    private Long id;
    /**
     * 专业人员id
     **/
    @Column(nullable = false)
    private Long professionalId;
    /**
     * 用户id
     **/
    @Column(nullable = false)
    private Long userId;
    /**
     * 时间
     */
    @Convert(converter = TimestampLongConverter.class)
    @Column(nullable = false)
    private Long time;
    /**
     * 建议内容
     */
    @Column(length = 1000)
    private String content;

    public MedicalSuggestion() {
    }

    public MedicalSuggestion(Long id, Long professionalId, Long userId, Long time, String content) {
        this.id = id;
        this.professionalId = professionalId;
        this.userId = userId;
        this.time = time;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
