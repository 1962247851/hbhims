package com.example.hbhims.entity;

import com.example.hbhims.TimestampLongConverter;

import javax.persistence.*;

/**
 * 医疗意见和建议评价表(MedicalSuggestionEvaluation)实体类
 *
 * @author qq1962247851
 * @date 2020/4/25 17:20
 */
@Entity
public class MedicalSuggestionEvaluation {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "medical_suggestion_evaluation_seq")
    @TableGenerator(name = "medical_suggestion_evaluation_seq",
            allocationSize = 1,//自动增长，设置为1
            pkColumnName = "sequence_name", //表里用来保存主键名字的字段
            valueColumnName = "sequence_next_hi_value",//表里用来保存主键值的字段
            pkColumnValue = "medical_suggestion_evaluation_id"//表里名字字段对应的值
    )
    private Long id;
    /**
     * 建议id
     **/
    @Column(nullable = false)
    private Long suggestionId;
    /**
     * 评价分数0-5
     **/
    @Column(nullable = false, columnDefinition = "tinyint(1)")
    private Integer evaluationScore;
    /**
     * 时间
     */
    @Convert(converter = TimestampLongConverter.class)
    @Column(nullable = false)
    private Long time;

    public MedicalSuggestionEvaluation() {
    }

    public MedicalSuggestionEvaluation(Long id, Long suggestionId, Integer evaluationScore, Long time) {
        this.id = id;
        this.suggestionId = suggestionId;
        this.evaluationScore = evaluationScore;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSuggestionId() {
        return suggestionId;
    }

    public void setSuggestionId(Long suggestionId) {
        this.suggestionId = suggestionId;
    }

    public Integer getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(Integer evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

}
