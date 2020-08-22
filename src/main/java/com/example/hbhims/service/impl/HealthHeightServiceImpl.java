package com.example.hbhims.service.impl;

import com.example.hbhims.dao.HealthHeightDao;
import com.example.hbhims.entity.HealthHeight;
import com.example.hbhims.service.HealthHeightService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 身高表(HealthHeight)表服务实现类
 *
 * @author qq1962247851
 * @date 2020/4/20 11:42
 */
@Service
public class HealthHeightServiceImpl implements HealthHeightService {

    private final HealthHeightDao healthHeightDao;

    public HealthHeightServiceImpl(HealthHeightDao healthHeightDao) {
        this.healthHeightDao = healthHeightDao;
    }

    @Override
    public HealthHeight queryById(Long id) {
        return healthHeightDao.findById(id).orElse(null);
    }

    @Override
    public List<HealthHeight> queryAllByLimit(Long offset, Long limit) {
        return healthHeightDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<HealthHeight> queryAll() {
        return healthHeightDao.findAll();
    }

    @Override
    public HealthHeight insert(HealthHeight healthHeight) {
        return healthHeightDao.save(healthHeight);
    }

    @Override
    public HealthHeight update(HealthHeight healthHeight) {
        return healthHeightDao.saveAndFlush(healthHeight);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            healthHeightDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return healthHeightDao.findById(id).isEmpty();
    }

    @Override
    public HealthHeight queryByUserId(Long userId) {
        return healthHeightDao.findByUserId(userId).orElse(null);
    }
}
