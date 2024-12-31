package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

import com.wecp.progressive.entity.Cricketer;
import com.wecp.progressive.service.CricketerService;

public class CricketerServiceImplArraylist implements CricketerService {

    private static List<Cricketer> cricketerList = new ArrayList<>();

    @Override
    public List<Cricketer> getAllCricketers() {
        // TODO Auto-generated method stub
        return cricketerList;
    }

    @Override
    public Integer addCricketer(Cricketer cricketer) {
        // TODO Auto-generated method stub
        cricketerList.add(cricketer);
        return cricketerList.size();
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() {
        // TODO Auto-generated method stub
        List<Cricketer> sortedCricketer = cricketerList;
        sortedCricketer.sort(Comparator.comparing(Cricketer::getExperience));
        return sortedCricketer;
    }

    @Override
    public void emptyArrayList(){
        cricketerList = new ArrayList<>();
    }

    
}