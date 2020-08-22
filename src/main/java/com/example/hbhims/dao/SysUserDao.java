package com.example.hbhims.dao;

import com.example.hbhims.entity.CustomSysUserProfessional;
import com.example.hbhims.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SysUserDao extends JpaRepository<SysUser, Long> {

    Optional<SysUser> findByUserName(String userName);

    @Query(value = "select * from sys_user limit ?#{#limit} offset ?#{#offset}", nativeQuery = true)
    List<SysUser> queryAllByLimit(@Param("offset") Long offset, @Param("limit") Long limit);

    @Query("select new com.example.hbhims.entity.CustomSysUserProfessional(su.id,su.userName,avg (mse.evaluationScore),count (ms)) " +
            "from SysUserRoleRelation as syrr " +
            "inner join SysUser as su on su.id = syrr.userId " +
            "left join MedicalSuggestion as ms on ms.professionalId = su.id " +
            "left join MedicalSuggestionEvaluation as mse on mse.suggestionId = ms.id " +
            "where syrr.roleId = 2 " +
            "group by syrr.userId"
    )
    List<CustomSysUserProfessional> queryAllProfessional();

    @Query("select new com.example.hbhims.entity.CustomSysUserProfessional(su.id,su.userName,avg (mse.evaluationScore),count (ms)) " +
            "from SysUserRoleRelation as syrr " +
            "inner join SysUser as su on su.id = syrr.userId " +
            "left join MedicalSuggestion as ms on ms.professionalId = su.id " +
            "left join MedicalSuggestionEvaluation as mse on mse.suggestionId = ms.id " +
            "where syrr.roleId = 2 " +
            "group by syrr.userId"
    )
    Page<CustomSysUserProfessional> queryAllProfessional(Pageable pageable);
}
