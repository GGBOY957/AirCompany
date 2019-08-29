package com.test.springboot01.service;

import com.test.springboot01.bean.Limits;
import com.test.springboot01.mapper.LimitsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LimitsService {
    @Autowired
    LimitsMapper limitsMapper;

    public Limits getById(Integer id){
        return limitsMapper.getLimitsById(id);
    }

    public int insert(Limits limits){
        return  limitsMapper.insertLimits(limits);
    }

    public int delete(Integer id){
        return limitsMapper.delLimitsById(id);
    }

    public int update(Limits limits){
        return limitsMapper.updateLimits(limits);
    }
}
