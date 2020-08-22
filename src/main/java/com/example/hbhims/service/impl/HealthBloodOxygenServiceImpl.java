package com.example.hbhims.service.impl;

import com.example.hbhims.dao.HealthBloodOxygenDao;
import com.example.hbhims.entity.HealthBloodOxygen;
import com.example.hbhims.service.HealthBloodOxygenService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 血氧表(HealthBloodOxygen)表服务实现类
 *
 * @author qq1962247851
 * @date 2020/4/20 11:42
 */
@Service
public class HealthBloodOxygenServiceImpl implements HealthBloodOxygenService {

    private final HealthBloodOxygenDao healthBloodOxygenDao;

    public HealthBloodOxygenServiceImpl(HealthBloodOxygenDao healthBloodOxygenDao) {
        this.healthBloodOxygenDao = healthBloodOxygenDao;
    }

    @Override
    public HealthBloodOxygen queryById(Long id) {
        return healthBloodOxygenDao.findById(id).orElse(null);
    }

    @Override
    public List<HealthBloodOxygen> queryAllByLimit(Long offset, Long limit) {
        return healthBloodOxygenDao.queryAllByLimit(offset, limit);
    }

    @Override
    public HealthBloodOxygen insert(HealthBloodOxygen healthBloodOxygen) {
        return healthBloodOxygenDao.save(healthBloodOxygen);
    }

    @Override
    public HealthBloodOxygen update(HealthBloodOxygen healthBloodOxygen) {
        return healthBloodOxygenDao.saveAndFlush(healthBloodOxygen);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            healthBloodOxygenDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return healthBloodOxygenDao.findById(id).isEmpty();
    }

    @Override
    public List<HealthBloodOxygen> queryAllByUserId(Long userId) {
        return healthBloodOxygenDao.findAllByUserId(userId);
    }

    @Override
    public List<HealthBloodOxygen> queryAll() {
        return healthBloodOxygenDao.findAll();
    }
}
