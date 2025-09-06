package com.example.service;

import com.example.dao.ReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private ReportDao reportDao;

    public ReportService() {
        System.out.println("ReportService :: 0 Param - Constructor");
    }

    @Autowired
    public ReportService(ReportDao reportDao) {
        System.out.println("ReportService :: Parametrized Constructor");
    }

    @Autowired
    public void setReportDao(ReportDao reportDao) {
        System.out.println("setReportDao() method called!");
        this.reportDao = reportDao;
    }

    public void printName(Integer userId) {
        String nameById = reportDao.getNameById(userId);
        System.out.println(nameById);
    }
}
