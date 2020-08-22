package com.example.hbhims.dao;

import com.example.hbhims.entity.HealthHeight;
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
public interface HealthHeightDao extends JpaRepository<HealthHeight, Long> {

    /**
     * 分页查询
     *
     * @param offset 偏移
     * @param limit  个数
     * @return 多条数据
     */
    @Query(value = "select * from health_height limit ?#{#limit} offset ?#{#offset}", nativeQuery = true)
    List<HealthHeight> queryAllByLimit(@Param("offset") Long offset, @Param("limit") Long limit);

    /**
     * 根据userId查询多条数据
     *
     * @param userId userId
     * @return 多条数据
     */
    Optional<HealthHeight> findByUserId(Long userId);

}
