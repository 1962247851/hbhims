package com.example.hbhims.service.impl;

import com.example.hbhims.dao.MedicalSuggestionEvaluationDao;
import com.example.hbhims.entity.MedicalSuggestionEvaluation;
import com.example.hbhims.service.MedicalSuggestionEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 医疗意见和建议评分表(MedicalSuggestionEvaluationEvaluation)表服务实现类
 *
 * @author qq1962247851
 * @date 2020/4/25 17:31
 */
@Service
public class MedicalSuggestionEvaluationServiceImpl implements MedicalSuggestionEvaluationService {

    private final MedicalSuggestionEvaluationDao medicalSuggestionEvaluationDao;

    public MedicalSuggestionEvaluationServiceImpl(MedicalSuggestionEvaluationDao medicalSuggestionEvaluationDao) {
        this.medicalSuggestionEvaluationDao = medicalSuggestionEvaluationDao;
    }

    @Override
    public MedicalSuggestionEvaluation queryById(Long id) {
        return medicalSuggestionEvaluationDao.findById(id).orElse(null);
    }

    @Override
    public List<MedicalSuggestionEvaluation> queryAllByLimit(Long offset, Long limit) {
        return medicalSuggestionEvaluationDao.queryAllByLimit(offset, limit);
    }

    @Override
    public MedicalSuggestionEvaluation insert(MedicalSuggestionEvaluation medicalSuggestionEvaluation) {
        return medicalSuggestionEvaluationDao.save(medicalSuggestionEvaluation);
    }

    @Override
    public MedicalSuggestionEvaluation update(MedicalSuggestionEvaluation medicalSuggestionEvaluation) {
        return medicalSuggestionEvaluationDao.saveAndFlush(medicalSuggestionEvaluation);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            medicalSuggestionEvaluationDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return medicalSuggestionEvaluationDao.findById(id).isEmpty();
    }

    @Override
    public MedicalSuggestionEvaluation queryBySuggestionId(Long suggestionId) {
        return medicalSuggestionEvaluationDao.findBySuggestionId(suggestionId).orElse(null);
    }
}
