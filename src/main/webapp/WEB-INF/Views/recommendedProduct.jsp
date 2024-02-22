<%@page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Recommended Product Page</title>
    <style>

          <link rel="stylesheet" href="style.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body{
  font-family: 'Poppins', sans-serif;
}
.navbar{
  display: flex;
  align-items: center;
  padding: 20px;
}
nav{
  position: center;
  flex: 1;
  text-align: right;
}
.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  right: 0;
  background: #F2F2F2;
  opacity: 0.5;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #131313;
  display: block;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #cfcfcf;
}
.menu{
  position: absolute;
  margin-top: 13.5px;
  margin-left: 1200px
}
.sidenav .closebtn{
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

@media screen and (max-height: 450px){
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
a{
  text-decoration: none;
  color: #555;
}
p{
  color: #555;
}
.container{
  max-width: 1300px;
  margin: auto;
  padding-left: 25px;
  padding-right: 25px;
}
.row{
  display: flex;
  align-items: center;
  flex-wrap: wrap;
  justify-content: space-around;
}

.col-2 h1{
  font-size: 50px;
  line-height: 60px;
  margin: 25px 0;
}
.header .row{
  margin-top: 70px;
}
.col-4{
  flex-basis: 25%;
  padding: 10px;
  min-width: 200px;
  margin-bottom: 50px;
  transition: transform 0.5s;
}
.col-4 img{
  width: 100%; 
}
.title{
  text-align: center;
  margin: 0 auto 80px;
  position: relative;
  line-height: 60px;
  color: #555;
}

/*---------products-----*/
  
  .products{
      margin: 70px 0;
      padding: 0;
      box-sizing: border-box;
  }

  h2{
      text-align: center;
      margin: 0 auto 80px;
      position: relative;
      margin-bottom: 5rem;
      font-size: 2rem;
  } 
  .all-products{
      display: flex;
      align-items: center;
      justify-content: center;
      flex-wrap: wrap;
  }
  
.product{
	overflow: hidden;
	background: #ffffff;
	color: #21201e;
	text-align: center;
	width: 240px;
	height: 400px;
	padding: 2rem;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	border-radius: 1.2rem;
	margin: 2rem;
}

.product .product-title, .product .product-price{
	font-size: 15px;
}

.product:hover img{
	scale:  1.1;
}

.product:hover {
	box-shadow: 5px 15px 25px #000;
}

.product img {
	height: 200px;
	margin: 1rem;
	transition: all 0.3s;
}

.product a:link, .product a:visited{
	color: #ececec;
	display: inline-block;
	text-decoration: none;
	background-color: #ff637b;
	padding: 1.2rem 3rem;
	border-radius: 1rem;
	margin-top: 1rem;
	font-size: 14px;
	transition: all 0.2s;
}

.product a:hover{
	transform: scale(1.1);
}

  .nav__logo {
    font-weight: var(--font-semi-bold);
  }
.nav__shop {
  font-size: 2.5rem;
  cursor: pointer;
}

.nav__shop a {
  color: inherit; /* Preserve the default text color */
  text-decoration: none; /* Remove underline from the anchor tag */
}


}
  .bx.bx-cart {
    font-size: 30px; /* Adjust the size as needed */
  }
  .bx.bx-heart {
    font-size: 30px; /* Adjust the size as needed */
  }
    </style>
</head>
<body>

<script src="https://kit.fontawesome.com/8b698e6fcf.js" crossorigin="anonymous"></script>

  </head>
  <body>
 
<div class="header">
  <div class="container">
    <div class="navbar">
      <div class="logo">
        <a href="/" class="nav__logo">Sneaker-Head</a>
      </div>

      <nav class="nav__links"> <div class="nav__shop">
          <a href="/view">
            <i class='bx bx-cart'></i>
          </a>
        </div>
        <div class="nav__shop">
          <a href="/wishlist">
            <i class='bx bx-heart'></i>
          </a>
        </div>
      </nav>

      <span style="font-size:30px;cursor:pointer;" class="menu" onclick="openNav()">&#9776;</span>

      <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="/">Home</a>
        <a href="/products">Products</a>
        <a href="about">About</a>
      </div>
    </div>
  </div>
</div>

<section class="products">
    <h2>Recommended Sneakers</h2>
    <div class="all-products">
        <c:forEach var="recommendedProducts" items="${recommendedProducts}">
        <a href="/products/${recommendedProducts.id}">
            <div class="product">
                <img src="${product.imageUrl}" alt="Product Image">
                <div class="product-info">
                    <h4 class="product-title">${recommendedProducts.name}</h4>
                    <p class="product-price">${recommendedProducts.price}</p>
                </div>
            </div>
            </a>
        </c:forEach>
    </div>
</section>
    <script type="text/javascript">
    function openNav() {
    	  document.getElementById("mySidenav").style.width = "250px";
    	}

    	function closeNav() {
    	  document.getElementById("mySidenav").style.width = "0";
    	}
    </script>
  
    </body>
    </html>
