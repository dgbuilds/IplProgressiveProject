package com.wecp.progressive.service.impl;

import java.sql.SQLException;
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
    public List<Cricketer> getAllCricketers() throws SQLException {
        // TODO Auto-generated method stub
        return cricketerDAO.getAllCricketers();
      
    }

    @Override
    public Integer addCricketer(Cricketer cricketer) throws SQLException {
        // TODO Auto-generated method stub
        System.out.println("service impl jdbc add cricketer");
        return cricketerDAO.addCricketer(cricketer);
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() {
        // TODO Auto-generated method stub
        return List.of();
    }

    @Override
    public void updateCricketer(Cricketer cricketer) throws SQLException {
        cricketerDAO.updateCricketer(cricketer);
    }

    @Override
    public void deleteCricketer(int cricketerId) throws SQLException {
        cricketerDAO.deleteCricketer(cricketerId);
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) throws SQLException {
        return cricketerDAO.getCricketerById(cricketerId);
    }

}