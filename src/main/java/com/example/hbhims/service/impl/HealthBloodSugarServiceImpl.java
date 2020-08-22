package com.example.hbhims.service.impl;

import com.example.hbhims.dao.HealthBloodSugarDao;
import com.example.hbhims.entity.HealthBloodSugar;
import com.example.hbhims.service.HealthBloodSugarService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 血糖表(HealthBloodSugar)表服务实现类
 *
 * @author qq1962247851
 * @date 2020/4/20 11:42
 */
@Service
public class HealthBloodSugarServiceImpl implements HealthBloodSugarService {

    private final HealthBloodSugarDao healthBloodSugarDao;

    public HealthBloodSugarServiceImpl(HealthBloodSugarDao healthBloodSugarDao) {
        this.healthBloodSugarDao = healthBloodSugarDao;
    }

    @Override
    public HealthBloodSugar queryById(Long id) {
        return healthBloodSugarDao.findById(id).orElse(null);
    }

    @Override
    public List<HealthBloodSugar> queryAllByLimit(Long offset, Long limit) {
        return healthBloodSugarDao.queryAllByLimit(offset, limit);
    }

    @Override
    public HealthBloodSugar insert(HealthBloodSugar healthBloodSugar) {
        return healthBloodSugarDao.save(healthBloodSugar);
    }

    @Override
    public HealthBloodSugar update(HealthBloodSugar healthBloodSugar) {
        return healthBloodSugarDao.saveAndFlush(healthBloodSugar);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            healthBloodSugarDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return healthBloodSugarDao.findById(id).isEmpty();
    }

    @Override
    public List<HealthBloodSugar> queryAllByUserId(Long userId) {
        return healthBloodSugarDao.findAllByUserId(userId);
    }

    @Override
    public List<HealthBloodSugar> queryAll() {
        return healthBloodSugarDao.findAll();
    }
}
