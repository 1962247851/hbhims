package com.example.hbhims.service.impl;

import com.example.hbhims.dao.HealthWeightDao;
import com.example.hbhims.entity.HealthWeight;
import com.example.hbhims.service.HealthWeightService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 体重表(HealthWeight)表服务实现类
 *
 * @author qq1962247851
 * @date 2020/4/20 11:42
 */
@Service
public class HealthWeightServiceImpl implements HealthWeightService {

    private final HealthWeightDao healthWeightDao;

    public HealthWeightServiceImpl(HealthWeightDao healthWeightDao) {
        this.healthWeightDao = healthWeightDao;
    }

    @Override
    public HealthWeight queryById(Long id) {
        return healthWeightDao.findById(id).orElse(null);
    }

    @Override
    public List<HealthWeight> queryAllByLimit(Long offset, Long limit) {
        return healthWeightDao.queryAllByLimit(offset, limit);
    }

    @Override
    public HealthWeight insert(HealthWeight healthWeight) {
        return healthWeightDao.save(healthWeight);
    }

    @Override
    public HealthWeight update(HealthWeight healthWeight) {
        return healthWeightDao.saveAndFlush(healthWeight);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            healthWeightDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return healthWeightDao.findById(id).isEmpty();
    }

    @Override
    public List<HealthWeight> queryAllByUserId(Long userId) {
        return healthWeightDao.findAllByUserId(userId);
    }

    @Override
    public List<HealthWeight> queryAll() {
        return healthWeightDao.findAll();
    }
}
