package com.example.hbhims.service.impl;

import com.example.hbhims.dao.HealthSportDao;
import com.example.hbhims.entity.HealthSport;
import com.example.hbhims.service.HealthSportService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 运动记录表(HealthSport)表服务实现类
 *
 * @author qq1962247851
 * @date 2020/4/20 11:42
 */
@Service
public class HealthSportServiceImpl implements HealthSportService {

    private final HealthSportDao healthSportDao;

    public HealthSportServiceImpl(HealthSportDao healthSportDao) {
        this.healthSportDao = healthSportDao;
    }

    @Override
    public HealthSport queryById(Long id) {
        return healthSportDao.findById(id).orElse(null);
    }

    @Override
    public List<HealthSport> queryAllByLimit(Long offset, Long limit) {
        return healthSportDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<HealthSport> queryAllByDateAndLimit(Long date, Long offset, Long limit) {
        return healthSportDao.queryAllByDateAndLimit(date, offset, limit);
    }

    @Override
    public List<HealthSport> queryAllByDate(Long date) {
        return healthSportDao.findAllByDate(date);
    }

    @Override
    public List<HealthSport> queryAll() {
        return healthSportDao.findAll();
    }

    @Override
    public HealthSport insert(HealthSport healthSport) {
        return healthSportDao.save(healthSport);
    }

    @Override
    public HealthSport update(HealthSport healthSport) {
        return healthSportDao.saveAndFlush(healthSport);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            healthSportDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return healthSportDao.findById(id).isEmpty();
    }

    @Override
    public List<HealthSport> queryAllByUserId(Long userId) {
        return healthSportDao.findAllByUserId(userId);
    }

    @Override
    public HealthSport queryByUserIdAndDate(Long userId, Long date) {
        return healthSportDao.findByUserIdAndDate(userId, date);
    }

}
