package com.example.hbhims.dao;

import com.example.hbhims.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SysPermissionDao extends JpaRepository<SysPermission, Long> {

    @Query(value = "select * from sys_permission limit ?#{#limit} offset ?#{#offset}", nativeQuery = true)
    List<SysPermission> queryAllByLimit(@Param("offset") Long offset, @Param("limit") Long limit);

    Optional<SysPermission> findByCode(String code);

}
