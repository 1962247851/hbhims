package com.example.hbhims.service.impl;

import com.example.hbhims.dao.HealthBloodPressureDao;
import com.example.hbhims.entity.HealthBloodPressure;
import com.example.hbhims.service.HealthBloodPressureService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 血压表(HealthBloodPressure)表服务实现类
 *
 * @author qq1962247851
 * @date 2020/4/20 11:42
 */
@Service
public class HealthBloodPressureServiceImpl implements HealthBloodPressureService {

    private final HealthBloodPressureDao healthBloodPressureDao;

    public HealthBloodPressureServiceImpl(HealthBloodPressureDao healthBloodPressureDao) {
        this.healthBloodPressureDao = healthBloodPressureDao;
    }

    @Override
    public HealthBloodPressure queryById(Long id) {
        return healthBloodPressureDao.findById(id).orElse(null);
    }

    @Override
    public List<HealthBloodPressure> queryAllByLimit(Long offset, Long limit) {
        return healthBloodPressureDao.queryAllByLimit(offset, limit);
    }

    @Override
    public HealthBloodPressure insert(HealthBloodPressure healthBloodPressure) {
        return healthBloodPressureDao.save(healthBloodPressure);
    }

    @Override
    public HealthBloodPressure update(HealthBloodPressure healthBloodPressure) {
        return healthBloodPressureDao.saveAndFlush(healthBloodPressure);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            healthBloodPressureDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return healthBloodPressureDao.findById(id).isEmpty();
    }

    @Override
    public List<HealthBloodPressure> queryAllByUserId(Long userId) {
        return healthBloodPressureDao.findAllByUserId(userId);
    }

    @Override
    public List<HealthBloodPressure> queryAll() {
        return healthBloodPressureDao.findAll();
    }
}
