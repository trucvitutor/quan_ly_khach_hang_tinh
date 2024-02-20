package com.example.quan_ly_khach_hang.service;

import com.example.quan_ly_khach_hang.model.Province;

import java.sql.SQLException;
import java.util.List;

public interface IProvinceService {
    List<Province> findAll() throws SQLException;

}
