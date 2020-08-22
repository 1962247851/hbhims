package com.example.hbhims.service;

import com.example.hbhims.entity.CustomMedicalSuggestionRequest;
import com.example.hbhims.entity.MedicalSuggestionRequest;
import com.sun.istack.Nullable;

import java.util.List;

/**
 * 医疗意见和建议请求表(MedicalSuggestionRequest)表服务接口
 *
 * @author qq1962247851
 */
public interface MedicalSuggestionRequestService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Nullable
    MedicalSuggestionRequest queryById(Long id);

    /**
     * 新增数据
     *
     * @param medicalSuggestionRequest 实例对象
     * @return 实例对象
     */
    MedicalSuggestionRequest insert(MedicalSuggestionRequest medicalSuggestionRequest);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 修改数据
     *
     * @param medicalSuggestionRequest 实例对象
     * @return 实例对象
     */
    MedicalSuggestionRequest update(MedicalSuggestionRequest medicalSuggestionRequest);

    /**
     * 根据用户id查询多条数据
     *
     * @param userId 用户id
     * @param page   page
     * @param size   size
     * @return 多条数据
     */
    List<CustomMedicalSuggestionRequest> queryAllByUserIdAndPage(Long userId, Integer page, Integer size);

    /**
     * 根据专业人员id查询多条数据
     *
     * @param professionalId professionalId
     * @param page           page
     * @param size           size
     * @return 多条数据
     */
    List<CustomMedicalSuggestionRequest> queryAllByProfessionalIdAndPage(Long professionalId, Integer page, Integer size);

    /**
     * 根据用户id查询多条数据
     *
     * @param userId 用户id
     * @return 多条数据
     */
    List<CustomMedicalSuggestionRequest> queryAllByUserId(Long userId);

    /**
     * 根据专业人员id查询多条数据
     *
     * @param professionalId professionalId
     * @return 多条数据
     */
    List<CustomMedicalSuggestionRequest> queryAllByProfessionalId(Long professionalId);

}