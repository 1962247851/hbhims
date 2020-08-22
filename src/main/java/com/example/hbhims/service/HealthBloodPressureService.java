package com.example.hbhims.service;

import com.example.hbhims.entity.HealthBloodPressure;
import com.sun.istack.Nullable;

import java.util.List;

/**
 * 血压表(HealthBloodPressure)表服务接口
 *
 * @author qq1962247851
 */
public interface HealthBloodPressureService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Nullable
    HealthBloodPressure queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<HealthBloodPressure> queryAllByLimit(Long offset, Long limit);

    /**
     * 新增数据
     *
     * @param healthBloodPressure 实例对象
     * @return 实例对象
     */
    HealthBloodPressure insert(HealthBloodPressure healthBloodPressure);

    /**
     * 修改数据
     *
     * @param healthBloodPressure 实例对象
     * @return 实例对象
     */
    HealthBloodPressure update(HealthBloodPressure healthBloodPressure);

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
    List<HealthBloodPressure> queryAllByUserId(Long userId);

    /**
     * 查询多条数据
     *
     * @return 多条数据
     */
    List<HealthBloodPressure> queryAll();
}