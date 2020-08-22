package com.example.hbhims.service.impl;

import com.example.hbhims.dao.MedicalSuggestionDao;
import com.example.hbhims.entity.CustomMedicalSuggestion;
import com.example.hbhims.entity.MedicalSuggestion;
import com.example.hbhims.service.MedicalSuggestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 医疗意见和建议表(MedicalSuggestion)表服务实现类
 *
 * @author qq1962247851
 * @date 2020/4/25 17:31
 */
@Service
public class MedicalSuggestionServiceImpl implements MedicalSuggestionService {

    private final MedicalSuggestionDao medicalSuggestionDao;

    public MedicalSuggestionServiceImpl(MedicalSuggestionDao medicalSuggestionDao) {
        this.medicalSuggestionDao = medicalSuggestionDao;
    }

    @Override
    public MedicalSuggestion queryById(Long id) {
        return medicalSuggestionDao.findById(id).orElse(null);
    }

    @Override
    public List<CustomMedicalSuggestion> queryAllByPage(Integer page, Integer size) {
        return medicalSuggestionDao.queryAllByPage(PageRequest.of(page, size)).toList();
    }

    @Override
    public MedicalSuggestion insert(MedicalSuggestion medicalSuggestion) {
        return medicalSuggestionDao.save(medicalSuggestion);
    }

    @Override
    public MedicalSuggestion update(MedicalSuggestion medicalSuggestion) {
        return medicalSuggestionDao.saveAndFlush(medicalSuggestion);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            medicalSuggestionDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return medicalSuggestionDao.findById(id).isEmpty();
    }

    @Override
    public List<CustomMedicalSuggestion> queryAllByUserId(Long userId) {
        return medicalSuggestionDao.queryAllByUserId(userId);
    }

    @Override
    public List<CustomMedicalSuggestion> queryAllByUserIdAndPage(Long userId, Integer page, Integer size) {
        Page<CustomMedicalSuggestion> customMedicalSuggestions = medicalSuggestionDao.queryAllByUserIdAndPage(userId, PageRequest.of(page, size));
        return customMedicalSuggestions.toList();
    }

    @Override
    public List<CustomMedicalSuggestion> queryAllByProfessionalId(Long professionalId) {
        return medicalSuggestionDao.queryAllByProfessionId(professionalId);
    }

    @Override
    public List<CustomMedicalSuggestion> queryAllByProfessionalIdAndPage(Long professionalId, Integer page, Integer size) {
        return medicalSuggestionDao.queryAllByProfessionalIdAndPage(professionalId, PageRequest.of(page, size)).toList();
    }
}
