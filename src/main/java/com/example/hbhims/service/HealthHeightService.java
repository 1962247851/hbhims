package com.example.hbhims.service;

import com.example.hbhims.entity.HealthHeight;
import com.sun.istack.Nullable;

import java.util.List;

/**
 * 身高表(HealthHeight)表服务接口
 *
 * @author qq1962247851
 */
public interface HealthHeightService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Nullable
    HealthHeight queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<HealthHeight> queryAllByLimit(Long offset, Long limit);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<HealthHeight> queryAll();


    /**
     * 新增数据
     *
     * @param healthHeight 实例对象
     * @return 实例对象
     */
    HealthHeight insert(HealthHeight healthHeight);

    /**
     * 修改数据
     *
     * @param healthHeight 实例对象
     * @return 实例对象
     */
    HealthHeight update(HealthHeight healthHeight);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据用户id查询单条数据
     *
     * @param userId 用户id
     * @return 多条数据
     */
    @Nullable
    HealthHeight queryByUserId(Long userId);

}