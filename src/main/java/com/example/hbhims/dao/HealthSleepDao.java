package com.example.hbhims.dao;

import com.example.hbhims.entity.HealthSleep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author qq1962247851
 * @date 2020/4/20 11:28
 */
@Repository
public interface HealthSleepDao extends JpaRepository<HealthSleep, Long> {
    /**
     * 分页查询
     *
     * @param offset 偏移
     * @param limit  个数
     * @return 多条数据
     */
    @Query(value = "select * from health_sleep limit ?#{#limit} offset ?#{#offset}", nativeQuery = true)
    List<HealthSleep> queryAllByLimit(@Param("offset") Long offset, @Param("limit") Long limit);

    /**
     * 分页查询
     *
     * @param date   日期
     * @param offset 偏移
     * @param limit  个数
     * @return 多条数据
     */
    @Query(value = "select * from health_sleep where `date` = ?#{#date} limit ?#{#limit} offset ?#{#offset}", nativeQuery = true)
    List<HealthSleep> queryAllByDateAndLimit(@Param("date") Long date, @Param("offset") Long offset, @Param("limit") Long limit);

    /**
     * 根据userId查询多条数据
     *
     * @param userId userId
     * @return 多条数据
     */
    List<HealthSleep> findAllByUserId(Long userId);

    /**
     * 根据userId和日期查询单条数据
     *
     * @param userId userId
     * @param date   日期
     * @return 单条数据
     */
    Optional<HealthSleep> findByUserIdAndDate(Long userId, Long date);

    /**
     * 根据日期查询多条数据
     *
     * @param date 日期
     * @return 多条数据
     */
    List<HealthSleep> findAllByDate(Long date);

}
