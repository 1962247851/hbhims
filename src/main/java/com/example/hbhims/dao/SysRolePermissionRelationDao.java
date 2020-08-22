package com.example.hbhims.dao;

import com.example.hbhims.entity.SysRolePermissionRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SysRolePermissionRelationDao extends JpaRepository<SysRolePermissionRelation, Long> {

    @Query(value = "select * from sys_role_permission_relation limit ?#{#limit} offset ?#{#offset}", nativeQuery = true)
    List<SysRolePermissionRelation> queryAllByLimit(@Param("offset") Long offset, @Param("limit") Long limit);

    List<SysRolePermissionRelation> findAllByPermissionId(Long permissionId);

    List<SysRolePermissionRelation> findAllByRoleId(Long roleId);

    Optional<SysRolePermissionRelation> findByRoleIdAndPermissionId(Long roleId, Long permissionId);
}
