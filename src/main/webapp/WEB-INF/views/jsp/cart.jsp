<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
                  rel="stylesheet">
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

          <ul class="navbar-nav">
                <td>
                       <button type="button" class="btn btn-success" onclick="location.href='cart/orderList'">OderList</button>
                </td>
           </ul>

    </nav>
<c:if test="${not empty allCart}">
    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">Description</th>

                <th scope="col">Quantity (*)</th>
                <th scope="col">Amount (*)</th>
                <th scope="col">Active</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach var="allCart" items="${allCart}">
                <tr>
                    <td>${allCart.productEntity.id}</td>
                    <td>${allCart.productEntity.name}</td>
                    <td>${allCart.productEntity.price}</td>
                    <td>${allCart.productEntity.productDescription}</td>
                    <td>${allCart.quantity}</td>
                    <td>${allCart.productEntity.price * allCart.quantity}</td>
                    <td>
                        <button type="button" class="btn btn-success" onclick="location.href='cart/remove/${allCart.productEntity.id}'">Delete</button>
                        <button type="button" class="btn btn-success" onclick="location.href='cart/checkout'">CheckOut</button>
                    </td>

                </tr>
            </c:forEach>
            <td>${cartAmount}</td>
        </tbody>
    </table>
</c:if>
        <c:if test="${allCart.size() ==0}">
            <br>
            <div class="alert alert-primary" role="alert">
               there is no data
              </div>
        </c:if>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>

</html>