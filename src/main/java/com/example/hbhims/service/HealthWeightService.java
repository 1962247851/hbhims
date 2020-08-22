package com.example.hbhims.service;

import com.example.hbhims.entity.HealthWeight;
import com.sun.istack.Nullable;

import java.util.List;

/**
 * 体重表(HealthWeight)表服务接口
 *
 * @author qq1962247851
 */
public interface HealthWeightService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Nullable
    HealthWeight queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<HealthWeight> queryAllByLimit(Long offset, Long limit);

    /**
     * 新增数据
     *
     * @param healthWeight 实例对象
     * @return 实例对象
     */
    HealthWeight insert(HealthWeight healthWeight);

    /**
     * 修改数据
     *
     * @param healthWeight 实例对象
     * @return 实例对象
     */
    HealthWeight update(HealthWeight healthWeight);

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
    List<HealthWeight> queryAllByUserId(Long userId);

    /**
     * 查询多条数据
     *
     * @return 多条数据
     */
    List<HealthWeight> queryAll();
}