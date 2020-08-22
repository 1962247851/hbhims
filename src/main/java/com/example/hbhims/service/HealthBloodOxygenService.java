package com.example.hbhims.service;

import com.example.hbhims.entity.HealthBloodOxygen;
import com.sun.istack.Nullable;

import java.util.List;

/**
 * 血氧表(HealthBloodOxygen)表服务接口
 *
 * @author qq1962247851
 */
public interface HealthBloodOxygenService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Nullable
    HealthBloodOxygen queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<HealthBloodOxygen> queryAllByLimit(Long offset, Long limit);

    /**
     * 新增数据
     *
     * @param healthBloodOxygen 实例对象
     * @return 实例对象
     */
    HealthBloodOxygen insert(HealthBloodOxygen healthBloodOxygen);

    /**
     * 修改数据
     *
     * @param healthBloodOxygen 实例对象
     * @return 实例对象
     */
    HealthBloodOxygen update(HealthBloodOxygen healthBloodOxygen);

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
    List<HealthBloodOxygen> queryAllByUserId(Long userId);

    /**
     * 查询多条数据
     *
     * @return 多条数据
     */
    List<HealthBloodOxygen> queryAll();
}