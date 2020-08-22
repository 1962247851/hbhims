package com.example.hbhims.service;

import com.example.hbhims.entity.CustomMedicalSuggestion;
import com.example.hbhims.entity.MedicalSuggestion;
import com.sun.istack.Nullable;

import java.util.List;

/**
 * 医疗意见和建议表(MedicalSuggestion)表服务接口
 *
 * @author qq1962247851
 */
public interface MedicalSuggestionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Nullable
    MedicalSuggestion queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param page 页数
     * @param size 大小
     * @return 对象列表
     */
    List<CustomMedicalSuggestion> queryAllByPage(Integer page, Integer size);

    /**
     * 新增数据
     *
     * @param medicalSuggestion 实例对象
     * @return 实例对象
     */
    MedicalSuggestion insert(MedicalSuggestion medicalSuggestion);

    /**
     * 修改数据
     *
     * @param medicalSuggestion 实例对象
     * @return 实例对象
     */
    MedicalSuggestion update(MedicalSuggestion medicalSuggestion);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据用户id查询多条数据
     *
     * @param userId 用户id
     * @return 多条数据
     */
    List<CustomMedicalSuggestion> queryAllByUserId(Long userId);

    /**
     * 根据用户id查询多条数据
     *
     * @param userId 用户id
     * @param page   page
     * @param size   size
     * @return 多条数据
     */
    List<CustomMedicalSuggestion> queryAllByUserIdAndPage(Long userId, Integer page, Integer size);

    /**
     * 根据专业人员id查询多条数据
     *
     * @param professionalId professionalId
     * @return 多条数据
     */
    List<CustomMedicalSuggestion> queryAllByProfessionalId(Long professionalId);

    /**
     * 根据专业人员id查询多条数据
     *
     * @param professionalId professionalId
     * @param page           page
     * @param size           size
     * @return 多条数据
     */
    List<CustomMedicalSuggestion> queryAllByProfessionalIdAndPage(Long professionalId, Integer page, Integer size);

}