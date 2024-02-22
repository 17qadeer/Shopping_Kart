<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
        <!DOCTYPE html>
        <html lang="en">
 
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Product Page</title>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
            <style>
                body {
                    font-family: Arial, sans-serif;
                    margin: 0;
                    padding: 0;
                    background-color: #f8f8f8;
                }
 
                .container {
                    max-width: 1200px;
                    margin: 0 auto;
                    padding: 20px;
                }
 
                .product {
                    background-color: #fff;
                    border-radius: 8px;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                    margin-bottom: 20px;
                    overflow: hidden;
                    transition: transform 0.3s ease;
                }
 
                .product:hover {
                    transform: translateY(-5px);
                }
 
 
                .product img {
                    width: 200px;
                    /* Adjust the width as needed */
                    height: auto;
                    border-top-left-radius: 8px;
                    border-top-right-radius: 8px;
                }
 
 
                .product-details {
                    padding: 20px;
                }
 
                .product-title {
                    font-size: 20px;
                    font-weight: bold;
                    margin-bottom: 10px;
                }
 
                .product-type {
                    color: #666;
                    margin-bottom: 10px;
                }
 
                .product-price {
                    font-size: 18px;
                    color: #333;
                    margin-bottom: 10px;
                }
 
                .product-description {
                    color: #777;
                }
            </style>
        </head>
 
        <body>
            <div class="container">
                <h2>Product Details:</h2>
                <div class="products">
                    <c:forEach var="views" items="${view}">
                        <div class="product">
                            <img src="${views.imageUrl}" alt="Product Image">
                            <div class="product-details">
                                <div class="product-title">${views.name}</div>
                                <div class="product-type">Type: ${views.type}</div>
                                <div class="product-price">Price: ${views.price}</div>
                                <div class="product-description">${views.description}</div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </body>
 
        </html>