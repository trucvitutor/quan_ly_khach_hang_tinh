package com.example.quan_ly_khach_hang.service;

import com.example.quan_ly_khach_hang.model.Customer;
import com.example.quan_ly_khach_hang.model.Province;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService{
private static final String SELECT_CUSTOMER="select customer.*,province.name as nameProvince from customer join province on province.id=customer.province_id;";
    @Override
    public List<Customer> findAll() {
        List<Customer> customers=new ArrayList<>();
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet rs= null;
        try {
            statement = connection.prepareStatement(SELECT_CUSTOMER);
            rs = statement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Integer provinceId = rs.getInt("province_id");
                String provinceName = rs.getString("nameProvince");
                Province province = new Province(provinceId, provinceName);
                customers.add(new Customer(id, name, address, email, phone, province));

            }
            } catch(SQLException e){
                throw new RuntimeException(e);
            }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        
    }
}
