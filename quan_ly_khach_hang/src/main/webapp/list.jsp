<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 19/02/2024
  Time: 4:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Information</title>
    <!-- Link CSS Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
    .custom-btn {
    background-color: #007bff; /* Màu nền */
    color: #ffffff; /* Màu chữ */
    border: none; /* Loại bỏ đường viền */
    padding: 10px 20px; /* Kích thước lề */
    border-radius: 5px; /* Bo góc */
    cursor: pointer; /* Con trỏ chuột thành dấu tay */
    transition: background-color 0.3s ease; /* Hiệu ứng chuyển đổi màu nền */
    }
    .custom-btn:hover {
        background-color: firebrick; /* Màu nền hover */
    }
    </style>
</head>
<body>

<div class="container">
    <h1>Customer Information</h1>
    <form method="get">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>address</th>
                <th>email</th>
                <th>phone</th>
                <th>province</th>
                <th>edit</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody>
            <!-- Dữ liệu của khách hàng sẽ được hiển thị ở đây -->
            <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.getId()}</td>
                <td>${customer.getName()}</td>
                <td>${customer.getAddress()}</td>
                <td>${customer.getEmail()}</td>
                <td>${customer.getPhone()}</td>
                <td>${customer.province.name}</td>
                <td>
                    <a class="btn btn-warning" href="#" role="button">Chỉnh
                        sửa</a>
                </td>
                <td>
                    <a class="btn btn-warning" href="#" role="button">Xoá</a>
                </td>
            </tr>

                <!-- Kết thúc dữ liệu của khách hàng -->
                </c:forEach>
<tr>
    <td>
        <a class="custom-btn" href="#" role="button">thêm</a>
    </td>
    <td>
        <a class="custom-btn" href="#" role="button">search </a>
    </td>
</tr>
            </tbody>
        </table>
    </form>
</div>

<!-- Script Bootstrap -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

