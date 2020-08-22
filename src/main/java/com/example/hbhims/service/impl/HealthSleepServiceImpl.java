package com.example.hbhims.service.impl;

import com.example.hbhims.dao.HealthSleepDao;
import com.example.hbhims.entity.HealthSleep;
import com.example.hbhims.service.HealthSleepService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 睡眠质量表(HealthSleep)表服务实现类
 *
 * @author qq1962247851
 * @date 2020/4/20 11:42
 */
@Service
public class HealthSleepServiceImpl implements HealthSleepService {

    private final HealthSleepDao healthSleepDao;

    public HealthSleepServiceImpl(HealthSleepDao healthSleepDao) {
        this.healthSleepDao = healthSleepDao;
    }

    @Override
    public HealthSleep queryById(Long id) {
        return healthSleepDao.findById(id).orElse(null);
    }

    @Override
    public List<HealthSleep> queryAllByLimit(Long offset, Long limit) {
        return healthSleepDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<HealthSleep> queryAllByDateAndLimit(Long date, Long offset, Long limit) {
        return healthSleepDao.queryAllByDateAndLimit(date, offset, limit);
    }

    @Override
    public List<HealthSleep> queryAllByDate(Long date) {
        return healthSleepDao.findAllByDate(date);
    }

    @Override
    public HealthSleep insert(HealthSleep healthSleep) {
        return healthSleepDao.save(healthSleep);
    }

    @Override
    public HealthSleep update(HealthSleep healthSleep) {
        return healthSleepDao.saveAndFlush(healthSleep);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            healthSleepDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return healthSleepDao.findById(id).isEmpty();
    }

    @Override
    public List<HealthSleep> queryAllByUserId(Long userId) {
        return healthSleepDao.findAllByUserId(userId);
    }

    @Override
    public HealthSleep queryByUserIdAndDate(Long userId, Long date) {
        return healthSleepDao.findByUserIdAndDate(userId, date).orElse(null);
    }

    @Override
    public List<HealthSleep> queryAll() {
        return healthSleepDao.findAll();
    }
}
