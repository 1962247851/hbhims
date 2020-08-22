package com.example.hbhims.entity;


public class CustomMedicalSuggestionRequest {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 请求者的id
     */
    private Long userId;
    /**
     * 请求者的用户名
     */
    private String userUsername;
    /**
     * 被被请求者的id
     */
    private Long professionalId;
    /**
     * 请求者的用户名
     */
    private String professionalUsername;
    /**
     * 图片url
     */
    private String healthDataImageUrl;
    /**
     * 时间
     */
    private Long time;

    public CustomMedicalSuggestionRequest() {
    }

    public CustomMedicalSuggestionRequest(Long id, Long userId, String userUsername, Long professionalId, String professionalUsername, String healthDataImageUrl, Long time) {
        this.id = id;
        this.userId = userId;
        this.userUsername = userUsername;
        this.professionalId = professionalId;
        this.professionalUsername = professionalUsername;
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

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getProfessionalUsername() {
        return professionalUsername;
    }

    public void setProfessionalUsername(String professionalUsername) {
        this.professionalUsername = professionalUsername;
    }

    public String getHealthDataImageUrl() {
        return healthDataImageUrl;
    }

    public void setHealthDataImageUrl(String healthDataImageUrl) {
        this.healthDataImageUrl = healthDataImageUrl;
    }
}
