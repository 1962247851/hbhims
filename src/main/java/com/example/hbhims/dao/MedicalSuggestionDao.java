package com.example.hbhims.dao;

import com.example.hbhims.entity.CustomMedicalSuggestion;
import com.example.hbhims.entity.MedicalSuggestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qq1962247851
 * @date 2020/4/20 11:28
 */
@Repository
public interface MedicalSuggestionDao extends JpaRepository<MedicalSuggestion, Long> {

    /**
     * 根据userId查询多条数据
     *
     * @param userId userId
     * @return 多条数据
     */
    @Query(value = "select new com.example.hbhims.entity.CustomMedicalSuggestion(ms.id,ms.professionalId,ms.userId,ms.time,ms.content,mse.evaluationScore,mse.time) " +
            "from MedicalSuggestion as ms " +
            "left join MedicalSuggestionEvaluation as mse on mse.suggestionId = ms.id " +
            "where ms.userId = ?1")
    List<CustomMedicalSuggestion> queryAllByUserId(Long userId);

    /**
     * 根据professionalId查询多条数据
     *
     * @param professionalId professionalId
     * @return 多条数据
     */
    @Query(value = "select new com.example.hbhims.entity.CustomMedicalSuggestion(ms.id,ms.professionalId,ms.userId,ms.time,ms.content,mse.evaluationScore,mse.time) " +
            "from MedicalSuggestion as ms " +
            "left join MedicalSuggestionEvaluation as mse on mse.suggestionId = ms.id " +
            "where ms.professionalId = ?1")
    List<CustomMedicalSuggestion> queryAllByProfessionId(Long professionalId);

    /**
     * 查询多条数据
     *
     * @param pageable pageable
     * @return 多条数据
     */
    @Query(value = "select new com.example.hbhims.entity.CustomMedicalSuggestion(ms.id,ms.professionalId,ms.userId,ms.time,ms.content,mse.evaluationScore,mse.time) " +
            "from MedicalSuggestion ms " +
            "left join MedicalSuggestionEvaluation mse on mse.suggestionId = ms.id")
    Page<CustomMedicalSuggestion> queryAllByPage(Pageable pageable);

    /**
     * 根据userId查询多条数据
     *
     * @param userId   userId
     * @param pageable pageable
     * @return 多条数据
     */
    @Query(value = "select new com.example.hbhims.entity.CustomMedicalSuggestion(ms.id,ms.professionalId,ms.userId,ms.time,ms.content,mse.evaluationScore,mse.time) " +
            "from MedicalSuggestion as ms " +
            "left join MedicalSuggestionEvaluation as mse on mse.suggestionId = ms.id " +
            "where ms.userId = ?1")
    Page<CustomMedicalSuggestion> queryAllByUserIdAndPage(Long userId, Pageable pageable);

    /**
     * 根据professionalId查询多条数据
     *
     * @param professionalId professionalId
     * @param pageable       pageable
     * @return 多条数据
     */
    @Query(value = "select new com.example.hbhims.entity.CustomMedicalSuggestion(ms.id,ms.professionalId,ms.userId,ms.time,ms.content,mse.evaluationScore,mse.time) " +
            "from MedicalSuggestion as ms " +
            "left join MedicalSuggestionEvaluation as mse on mse.suggestionId = ms.id " +
            "where ms.professionalId = ?1")
    Page<CustomMedicalSuggestion> queryAllByProfessionalIdAndPage(Long professionalId, Pageable pageable);
}
