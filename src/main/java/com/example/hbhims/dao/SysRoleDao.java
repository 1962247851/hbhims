package com.example.hbhims.dao;

import com.example.hbhims.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SysRoleDao extends JpaRepository<SysRole, Long> {

    @Query(value = "select * from sys_role limit ?#{#limit} offset ?#{#offset}", nativeQuery = true)
    List<SysRole> queryAllByLimit(@Param("offset") Long offset, @Param("limit") Long limit);

    Optional<SysRole> findByName(String name);

    Optional<SysRole> findByCode(String code);

}
