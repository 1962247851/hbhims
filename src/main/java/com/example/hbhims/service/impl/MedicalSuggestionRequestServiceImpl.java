package com.example.hbhims.service.impl;

import com.example.hbhims.dao.MedicalSuggestionRequestDao;
import com.example.hbhims.entity.CustomMedicalSuggestionRequest;
import com.example.hbhims.entity.MedicalSuggestionRequest;
import com.example.hbhims.service.MedicalSuggestionRequestService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qq1962247851
 * @date 2020/5/10 13:11
 */
@Service
public class MedicalSuggestionRequestServiceImpl implements MedicalSuggestionRequestService {
    private final MedicalSuggestionRequestDao medicalSuggestionRequestDao;

    public MedicalSuggestionRequestServiceImpl(MedicalSuggestionRequestDao medicalSuggestionRequestDao) {
        this.medicalSuggestionRequestDao = medicalSuggestionRequestDao;
    }

    @Override
    public MedicalSuggestionRequest queryById(Long id) {
        return medicalSuggestionRequestDao.findById(id).orElse(null);
    }

    @Override
    public MedicalSuggestionRequest insert(MedicalSuggestionRequest medicalSuggestionRequest) {
        return medicalSuggestionRequestDao.save(medicalSuggestionRequest);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            medicalSuggestionRequestDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return medicalSuggestionRequestDao.findById(id).isEmpty();
    }

    @Override
    public MedicalSuggestionRequest update(MedicalSuggestionRequest medicalSuggestionRequest) {
        return medicalSuggestionRequestDao.saveAndFlush(medicalSuggestionRequest);
    }

    @Override
    public List<CustomMedicalSuggestionRequest> queryAllByUserIdAndPage(Long userId, Integer page, Integer size) {
        return medicalSuggestionRequestDao.findAllByUserId(userId, PageRequest.of(page, size)).toList();
    }

    @Override
    public List<CustomMedicalSuggestionRequest> queryAllByProfessionalIdAndPage(Long professionalId, Integer page, Integer size) {
        return medicalSuggestionRequestDao.findAllByProfessionalId(professionalId, PageRequest.of(page, size)).toList();
    }

    @Override
    public List<CustomMedicalSuggestionRequest> queryAllByUserId(Long userId) {
        return medicalSuggestionRequestDao.findAllByUserId(userId);
    }

    @Override
    public List<CustomMedicalSuggestionRequest> queryAllByProfessionalId(Long professionalId) {
        return medicalSuggestionRequestDao.findAllByProfessionalId(professionalId);
    }
}
