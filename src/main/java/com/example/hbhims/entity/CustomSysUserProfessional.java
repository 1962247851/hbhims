package com.example.hbhims.entity;

/**
 * 用于查询所有专业人员
 *
 * @author qq1962247851
 * @date 2020/5/10 14:24
 */
public class CustomSysUserProfessional {
    private Long id;
    private String username;
    private Double meanEvaluationScore;
    private Number totalSuggestionCount;

    public CustomSysUserProfessional() {
    }

    public CustomSysUserProfessional(Long id, String username, Double meanEvaluationScore, Number totalSuggestionCount) {
        this.id = id;
        this.username = username;
        this.meanEvaluationScore = meanEvaluationScore;
        this.totalSuggestionCount = totalSuggestionCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getMeanEvaluationScore() {
        return meanEvaluationScore;
    }

    public void setMeanEvaluationScore(Double meanEvaluationScore) {
        this.meanEvaluationScore = meanEvaluationScore;
    }

    public Number getTotalSuggestionCount() {
        return totalSuggestionCount;
    }

    public void setTotalSuggestionCount(Number totalSuggestionCount) {
        this.totalSuggestionCount = totalSuggestionCount;
    }
}
