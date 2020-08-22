package com.example.hbhims.dao;

import com.example.hbhims.entity.CustomMedicalSuggestionRequest;
import com.example.hbhims.entity.MedicalSuggestionRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qq1962247851
 * @date 2020/5/10 13:05
 */
@Repository
public interface MedicalSuggestionRequestDao extends JpaRepository<MedicalSuggestionRequest, Long> {

    /**
     * 根据userId查询多条数据
     *
     * @param userId userId
     * @return 多条数据
     */
    @Query(value = "select new com.example.hbhims.entity.CustomMedicalSuggestionRequest(msr.id,msr.userId,sysUserUser.userName,msr.professionalId,sysUserProfessional.userName,msr.healthDataImageUrl,msr.time) " +
            "from MedicalSuggestionRequest as msr " +
            "join SysUser as sysUserUser on sysUserUser.id = msr.userId " +
            "join SysUser as sysUserProfessional on sysUserProfessional.id = msr.professionalId " +
            "where msr.userId = ?1")
    List<CustomMedicalSuggestionRequest> findAllByUserId(Long userId);

    /**
     * 根据professionalId查询多条数据
     *
     * @param professionalId professionalId
     * @return 多条数据
     */
    @Query(value = "select new com.example.hbhims.entity.CustomMedicalSuggestionRequest(msr.id,msr.userId,sysUserUser.userName,msr.professionalId,sysUserProfessional.userName,msr.healthDataImageUrl,msr.time) " +
            "from MedicalSuggestionRequest as msr " +
            "join SysUser as sysUserUser on sysUserUser.id = msr.userId " +
            "join SysUser as sysUserProfessional on sysUserProfessional.id = msr.professionalId " +
            "where msr.professionalId = ?1")
    List<CustomMedicalSuggestionRequest> findAllByProfessionalId(Long professionalId);

    /**
     * 根据userId查询多条数据
     *
     * @param userId   userId
     * @param pageable pageable
     * @return 多条数据
     */
    @Query(value = "select new com.example.hbhims.entity.CustomMedicalSuggestionRequest(msq.id,msq.userId,sysUserUser.userName,msq.professionalId,sysUserProfessional.userName,msq.healthDataImageUrl,msq.time) " +
            "from MedicalSuggestionRequest as msq " +
            "join SysUser as sysUserUser on sysUserUser.id = msq.userId " +
            "join SysUser as sysUserProfessional on sysUserProfessional.id = msq.professionalId " +
            "where msq.userId = ?1")
    Page<CustomMedicalSuggestionRequest> findAllByUserId(Long userId, Pageable pageable);

    /**
     * 根据professionalId查询多条数据
     *
     * @param professionalId professionalId
     * @param pageable       pageable
     * @return 多条数据
     */
    @Query(value = "select new com.example.hbhims.entity.CustomMedicalSuggestionRequest(msq.id,msq.userId,sysUserUser.userName,msq.professionalId,sysUserProfessional.userName,msq.healthDataImageUrl,msq.time) " +
            "from MedicalSuggestionRequest as msq " +
            "join SysUser as sysUserUser on sysUserUser.id = msq.userId " +
            "join SysUser as sysUserProfessional on sysUserProfessional.id = msq.professionalId " +
            "where msq.professionalId = ?1")
    Page<CustomMedicalSuggestionRequest> findAllByProfessionalId(Long professionalId, Pageable pageable);
}
