package com.wecp.progressive.service.impl;

import java.util.List;

import com.wecp.progressive.dao.CricketerDAO;
import com.wecp.progressive.entity.Cricketer;
import com.wecp.progressive.service.CricketerService;

public class CricketerServiceImplJdbc implements CricketerService {

    private CricketerDAO cricketerDAO;

    public CricketerServiceImplJdbc(){}

    public CricketerServiceImplJdbc(CricketerDAO cricketerDAO)
    {
        this.cricketerDAO = cricketerDAO;
    }

    @Override
    public List<Cricketer> getAllCricketers() {
        // TODO Auto-generated method stub
        return List.of();
    }

    @Override
    public Integer addCricketer(Cricketer cricketer) {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() {
        // TODO Auto-generated method stub
        return List.of();
    }

    @Override
    public void updateCricketer(Cricketer cricketer) {

    }

    @Override
    public void deleteCricketer(int cricketerId) {

    }

    @Override
    public Cricketer getCricketerById(int cricketerId) {
        return null;
    }

}