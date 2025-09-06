package com.example.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ReportDao {
    public String getNameById(Integer userId) {
        if (userId == 100) {
            return "Himanshu";
        } else {
            return "Gayatri";
        }
    }
}
