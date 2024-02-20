package com.example.quan_ly_khach_hang.service;

import com.example.quan_ly_khach_hang.model.Province;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceService implements IProvinceService {
    private static final String SELECT_FROM_PROVINCE="select*from province";
    @Override
    public List<Province> findAll() throws SQLException {
        List<Province> provinceList=new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement=connection.prepareStatement(SELECT_FROM_PROVINCE);
        return null;
    }
}
