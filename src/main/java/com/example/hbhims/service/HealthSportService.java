package com.example.hbhims.service;

import com.example.hbhims.entity.HealthSport;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import java.util.List;

/**
 * 运动记录表(HealthSport)表服务接口
 *
 * @author qq1962247851
 */
public interface HealthSportService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Nullable
    HealthSport queryById(@NotNull Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<HealthSport> queryAllByLimit(@NotNull Long offset, @NotNull Long limit);

    /**
     * 查询某个日期的多条数据
     *
     * @param date   日期
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<HealthSport> queryAllByDateAndLimit(@NotNull Long date, @NotNull Long offset, @NotNull Long limit);

    /**
     * 查询某个日期的多条数据
     *
     * @param date 日期
     * @return 对象列表
     */
    List<HealthSport> queryAllByDate(@NotNull Long date);

    /**
     * 新增数据
     *
     * @param healthSport 实例对象
     * @return 实例对象
     */
    HealthSport insert(@NotNull HealthSport healthSport);

    /**
     * 修改数据
     *
     * @param healthSport 实例对象
     * @return 实例对象
     */
    HealthSport update(@NotNull HealthSport healthSport);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(@NotNull Long id);

    /**
     * 根据用户id查询多条数据
     *
     * @param userId 用户id
     * @return 多条数据
     */
    List<HealthSport> queryAllByUserId(@NotNull Long userId);


    /**
     * 根据userId和日期查询单条数据
     *
     * @param userId userId
     * @param date   日期
     * @return 单条数据
     */
    HealthSport queryByUserIdAndDate(Long userId, Long date);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<HealthSport> queryAll();

}