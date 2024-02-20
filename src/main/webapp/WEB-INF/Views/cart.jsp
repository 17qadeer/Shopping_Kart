<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import "compass/css3";
@import url("https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&family=Chango&family=Roboto&display=swap");

* {
  box-sizing: border-box;
}
img {
  width: 100%;
  height: auto;
  vertical-align: sub;
}

.left {
  float: left;
}
.right {
  float: right;
}
.clr {
  clr: both;
}

.align-left {
  text-align: left;
}
.align-right {
  text-align: right;
}
.align-center {
  text-align: center;
}

html {
  background: #f5f5f5;
  font-family: "Roboto", sans-serif;
}

.icon {
  background: url(https://s.cdpn.io/6035/glyphicons-halflings-white.png)
    no-repeat;
  display: inline-block;
  display: inline-block;
  width: 14px;
  height: 14px;
  margin-top: 1px;
  line-height: 14px;
  vertical-align: text-top;
  background-position: 14px 14px;
}

.icon-plus {
  background-position: -408px -96px;
}
.icon-minus {
  background-position: -433px -96px;
}
.icon-remove {
  background-position: -312px 0;
}

.btn-quantity {
  transition: background-color 0.3s ease;
  font-size: 0.8em;
  box-shadow: 0 0 5px #0003;
  border-radius: 20px;
  padding: 10px 15px;
  &.plus {
    color: #478298;
    &:hover {
      color: darken(green, 10%);
    }
  }
  &.minus {
    color: #478298;
    &:hover {
      color: darken(red, 10%);
    }
  }
}

.btn-remove {
  position: absolute;
  bottom: 20px;
  right: 20px;
  z-index: 10;
  text-align: center;
  display: inline-block;
  color: #e94343;
  font-size: 1.4em;
  &:hover {
    color: darken(#1d1e22, 10%);
  }
  .icon {
    margin-top: 2px;
  }
}

.btn-checkout {
  color: #fff;
  text-decoration: none;
  margin: 20px 0 0;
  padding: 10px 0;
  border-radius: 5px;
  text-align: center;
  display: block;
  line-height: 25px;
  box-shadow: inset 0 -2px 0 rgba(0, 0, 0, 0.3);
  transition: background-color 0.3s ease;
  background: #478298;
  width: 40%;
  font-size: 2em;
  &:hover {
    background: darken(#2ecc71, 10%);
  }
}

.items {
  margin: 0;
  padding: 0;
  list-style: none;
}

.item {
  background: #fff;
  border-radius: 10px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
  margin-bottom: 20px;
  position: relative;
  display: flex;
  .inner_container {
    width: 40%;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  img {
    border-radius: 10px 0 0 10px;
  }
  .preview {
    width: 20%;
    ul {
      margin: 0;
      padding: 0;
      list-style: none;
      position: relative;
      height: 100%;
    }
    li {
      position: absolute;
      top: 0;
      opacity: 0;
      &.active {
        opacity: 1;
      }
    }
  }
  .details {
    padding: 0px 30px;
    position: relative;
    overflow: hidden;
    width: 40%;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;

    h3 {
      margin: 0;
      position: relative;
      z-index: 1;
      font-size: 2.6em;
      font-family: "Amatic SC", cursive;
    }
    p {
      font-size: 1em;
    }
    input[type="number"] {
      width: 50px;
      height: 30px;
      padding: 2px;
      outline: none;
      border-radius: 5px;
      border: none;
      border: 1px solid #ccc;
    }
  }
}

.summary {
  padding: 20px;
  background: #fff;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  margin-bottom: 80px;
  .meta-data {
    border-right: 1px solid #eee;
    padding-right: 10%;
  }
  .total {
    font-size: 2em;
    text-align: center;
    line-height: 65px;
  }
}
.container {
  max-width: 1140px;
  margin: 0 auto;
  padding: 0 50px;
  margin-top: 200px;
}
.picker {
  display: flex;
  flex-direction: row-reverse;
  align-items: center;
}
.quantity-text {
  margin: 0 20px;
  font-size: 1.2em;
}
.sub-total,
.taxes {
  font-size: 1.5em;
  margin: 10px 0;
}
.btn-summary {
  display: flex;
  justify-content: space-around;
  font-family: "Amatic SC", cursive;
}
.btn-reverse {
  background-color: #fff;
  color: #478298;
  border: 1px solid #478298;
}
.delivery-payment {
  display: flex;
  justify-content: space-between;
  margin-top: 100px;
}
.delivery-address,
.payment-details {
  width: 49%;
  border-radius: 10px;
  box-shadow: 0 0 5px #00000030;
  background-color: #fff;
  padding: 0px 30px 30px 30px;
  margin-bottom: 20px;
}
h3 {
  font-family: "Amatic SC", cursive;
  font-size: 2em;
}
.coupon {
  display: flex;
  border-radius: 10px;
  box-shadow: 0 0 5px #00000030;
  background-color: #fff;
  padding: 5px 30px;
  align-items: center;
  margin-bottom: 20px;
  & h3 {
    margin-right: 30px;
    font-family: "Amatic SC", cursive;
    font-size: 2em;
  }
}
input {
  border-radius: 10px;
  height: 40px;
}
.header {
    display: flex;
    justify-content: space-around;
    align-items: center;
    padding: 30px;
    background-color: #e6e1dd;
    height: 150px;
    margin-bottom: 80px;
    position: fixed;
    width: 100%;
    margin-top: -200px;
    z-index: 99999;
}
.login a {
  text-decoration: none;
  color: #575756;
}
.logo {
  padding: 0 20px;
}
h1 {
  font-family: "Amatic SC", cursive;
  font-size: 4em;
}
.summary-content {
    display: flex;
    justify-content: space-around;
    align-items: flex-end;
}


@media only screen and (max-width: 900px) {
  h1 {
    font-size: 3em;
  }
  .item .details h3 {
    font-size: 1.6em;
  }
  .quantity-text {
    font-size: 1em;
  }
  .btn-remove {
    right: 15px;
    font-size: 1.4em;
  }
  .item .details p {
    font-size: 0.8em;
  }
  .picker {
    margin-right: 10px;
  }
  .btn-quantity {
    font-size: 0.6em;
  }
}

@media only screen and (max-width: 768px) {

  .item {
    flex-direction: column;
    margin: auto;
    margin-bottom: 30px;
  }
  .item .preview {
    width: 100%;
  }
  .item .details {
    padding: 15px 30px;
    width: 100%;
  }
  .item img {
    border-radius: 10px 10px 0 0;
  }
  .item .details h3 {
    font-size: 2.6em;
    text-align: center;
  }
  h1 {
    font-size: 4em;
  }
  .header {
    margin-bottom: 50px;
    height: 80px;
    margin-top:-120px;
  }
  .item .details p {
    font-size: 1em;
    text-align: center;
  }
  .item .inner_container {
    width: 100%;
    margin-bottom: 20px;
  }
  .grid_12.summary {
    position: fixed;
    bottom: 0;
    left: 0;
    z-index: 99999;
    width: 100%;
    margin-bottom: 0;
  }
  .container {
    margin-bottom: 230px;
    margin-top:120px;
  }
  .sub-total,
  .taxes {
    font-size: 1em;
  }
  .summary .total {
    font-size: 1.6em;
    line-height: 1em;
    margin:10px 0;
  }
  .delivery-payment {
    margin-top: 60px;
}
  .coupon {
    flex-direction: column;
    padding: 30px 0px;
}
  .coupon h3 {
    margin: 0;
}
  .btn-checkout {
    font-size: 1.6em;
}
  .logo {
    width: 50%;
}
}

@media only screen and (max-width: 480px) {
  .btn-checkout {
    font-size: 1.2em;
}
  .container {
  padding: 0 30px;
}
  .btn-remove {
    font-size: 1.2em;
  }
  
}


</style>
</head>
<body>
<div class="grid_12 header">
  <div class="login">
    <a href="#">Login</a>
  </div>
  <div class="logo">
    <img src="https://www.cookfood.net/Content/images/Logo-full-black.png" />
  </div>
  <div class="basket">
    <a href="#"><img src="https://www.cookfood.net/Content/images/basket2.png" /></a>
  </div>
</div>
<div>
  <img src="https://assets.cookfood.net/product_916_2793.jpg" />
</div>
<div class="cart">
  <div class="container">
    <div class="grid_12">
      <h1>Your Cart</h1>
    </div>
    <ul class="items">
      <li class="grid_4 item">
        <a href="#" class="btn-remove">
          <i class="far fa-trash-alt"></i>
        </a>
        <div class="preview">
          <img src="https://assets.cookfood.net/product_916_2793.jpg" />
        </div>
        <div class="details" data-price="15.50">
          <h3>Lasagne Al Forno</h3>
          <p>Serves 4 (1480g)</p>
        </div>
        <div class="inner_container">
          <div class="col_1of2 align-center picker">
            <p>
              <a href="#" class="btn-quantity plus">
                <i class="fas fa-plus"></i>
              </a>
              <div class="col_1of2 quantity-text">
                <p><span class="current_quantity">1</span> @ £15.50</p>
              </div>
              <a href="#" class="btn-quantity minus">
                <i class="fas fa-minus"></i>
              </a>
            </p>
            <input type="hidden" class="quantity_field" name="quantity" data-price="15.50" value="1" />
          </div>
        </div>
      </li>
      <li class="grid_4 item">
        <!-- Second item content -->
      </li>
      <li class="grid_4 item">
        <!-- Third item content -->
      </li>
    </ul>
    <div class="grid_12 delivery-payment">
      <div class="grid_6 delivery-address">
        <h3>Delivery Address</h3>
        <p>46 Vale Road<br> Ramsgate</p>
      </div>
      <div class="grid_6 payment-details">
        <h3>Payment Card</h3>
        <p> **** **** **** 8678</p>
      </div>
    </div>
    <div class="grid_12 coupon">
      <h3>Apply Coupon</h3>
      <input class="coupon-input" type="text">
    </div>
    <div class="grid_12 summary">
      <div class="inner_container">
        <div class="summary-content">
          <div class="col_1of2 meta-data">
            <div class="sub-total">
              <em>Sub Total: </em><span class="amount"></span>
            </div>
            <div class="taxes">
              <em>Plus VAT: </em><span class="amount">@ 20%</span>
            </div>
          </div>
          <div class="col_1of2">
            <div class="total">
              <span class="amount"></span>
            </div>
          </div>
        </div>
        <div class="btn-summary">
          <a href="#" class="btn-checkout btn-reverse">Continue Shopping</a>
          <a href="#" class="btn-checkout">Checkout</a>
        </div>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
var $addQuantity = $(".btn-quantity.plus"),
$minusQuantity = $(".btn-quantity.minus"),
$removeItem = $(".btn-remove");

$addQuantity.on("click", function (e) {
e.preventDefault();
var $item = $(this).parents(".item"),
  $quantityField = $item.find(".quantity_field"),
  currentQuantity = $quantityField.val(),
  nextQuantity = parseFloat(currentQuantity) + 1;

$item.find(".current_quantity").html(nextQuantity);
$quantityField.val(nextQuantity);

calculateTotal();
});

$minusQuantity.on("click", function (e) {
e.preventDefault();
var $item = $(this).parents(".item"),
  $quantityField = $item.find(".quantity_field"),
  currentQuantity = $quantityField.val();
var prevQuantity = currentQuantity <= 1 ? 0 : parseFloat(currentQuantity) - 1;

$item.find(".current_quantity").html(prevQuantity);
$quantityField.val(prevQuantity);

calculateTotal();
});

$removeItem.on("click", function () {
var $item = $(this).parents(".item");
$item.remove();

calculateTotal();
});

var calculateTotal = function () {
var newSubTotal = 0;
$(".quantity_field").each(function () {
  var quantity = $(this).val(),
    price = $(this).data("price");

  newSubTotal += parseFloat(quantity * price);
});

$(".sub-total .amount").html("£" + newSubTotal.toFixed(2));

var withTax = newSubTotal * 1.2;

var newTotal = withTax + 0;

$(".total .amount").html("Total" + " " + "£" + newTotal.toFixed(2));
};

calculateTotal();
</script>
</body>
</html>