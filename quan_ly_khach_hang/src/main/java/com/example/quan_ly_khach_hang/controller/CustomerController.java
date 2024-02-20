package com.example.quan_ly_khach_hang.controller;

import com.example.quan_ly_khach_hang.model.Customer;
import com.example.quan_ly_khach_hang.model.Province;
import com.example.quan_ly_khach_hang.service.CustomerService;
import com.example.quan_ly_khach_hang.service.ICustomerService;
import com.example.quan_ly_khach_hang.service.IProvinceService;
import com.example.quan_ly_khach_hang.service.ProvinceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet(name = "CustomerService", urlPatterns = "/customer")
public class CustomerController extends HttpServlet {
    private static ICustomerService iCustomerService = new CustomerService();
    private static IProvinceService iProvinceService = new ProvinceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ahihi");
        String action = req.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "create":
                showCreate(req, resp);
                break;
            default:
                listCustomer(req, resp);

        }
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void listCustomer(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        List<Customer> customers = iCustomerService.findAll();
        req.setAttribute("customers", customers);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "create":
                createCustomer(req, resp);
                break;
        }
    }

    private void createCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        Integer provinceId = Integer.valueOf(req.getParameter("province_id"));
        String provinceName = req.getParameter("nameProvince");
        Province province=new Province(provinceId,provinceName);
        Customer customer=new Customer(id,name,address,email,phone,province);
        iCustomerService.addCustomer(customer);
        resp.sendRedirect("/student");
    }
}
