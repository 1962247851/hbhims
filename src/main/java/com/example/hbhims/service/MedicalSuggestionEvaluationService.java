package com.example.hbhims.service;

import com.example.hbhims.entity.MedicalSuggestionEvaluation;
import com.sun.istack.Nullable;

import java.util.List;

/**
 * 医疗意见和建议评分表(MedicalSuggestionEvaluationEvaluation)表服务接口
 *
 * @author qq1962247851
 */
public interface MedicalSuggestionEvaluationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Nullable
    MedicalSuggestionEvaluation queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MedicalSuggestionEvaluation> queryAllByLimit(Long offset, Long limit);

    /**
     * 新增数据
     *
     * @param medicalSuggestionEvaluation 实例对象
     * @return 实例对象
     */
    MedicalSuggestionEvaluation insert(MedicalSuggestionEvaluation medicalSuggestionEvaluation);

    /**
     * 修改数据
     *
     * @param medicalSuggestionEvaluation 实例对象
     * @return 实例对象
     */
    MedicalSuggestionEvaluation update(MedicalSuggestionEvaluation medicalSuggestionEvaluation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据suggestionId查询单条数据
     *
     * @param suggestionId 医疗意见和建议id
     * @return 多条数据
     */
    @Nullable
    MedicalSuggestionEvaluation queryBySuggestionId(Long suggestionId);

}