<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--DOCTYPE html-->
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <!-- ===== CSS ===== -->
  <link rel="stylesheet" type="text/css" href="assets/css/style.css" />

  <!-- ===== BOX ICONS ===== -->
  <link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet" />

  <title>Sneaker-Head</title>
  <style type="text/css">
  /*===== GOOGLE FONTS =====*/
@import url("https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap");
/*===== VARIABLES CSS =====*/
:root {
  --header-height: 3rem;

  /*===== Font weight =====*/
  --font-medium: 500;
  --font-semi-bold: 600;
  --font-bold: 700;

  /*===== Colores =====*/
  --dark-color: #141414;
  --dark-color-light: #8a8a8a;
  --dark-color-lighten: #f2f2f2;
  --white-color: #fff;

  /*===== Font and typography =====*/
  --body-font: "Poppins", sans-serif;
  --big-font-size: 1.25rem;
  --bigger-font-size: 1.5rem;
  --biggest-font-size: 2rem;
  --h2-font-size: 1.25rem;
  --normal-font-size: 0.938rem;
  --smaller-font-size: 0.813rem;

  /*===== Margenes =====*/
  --mb-1: 0.5rem;
  --mb-2: 1rem;
  --mb-3: 1.5rem;
  --mb-4: 2rem;
  --mb-5: 2.5rem;
  --mb-6: 3rem;

  /*===== z index =====*/
  --z-fixed: 100;

  /*===== Rotate img =====*/
  --rotate-img: rotate(-30deg);
}

@media screen and (min-width: 768px) {
  :root {
    --big-font-size: 1.5rem;
    --bigger-font-size: 2rem;
    --biggest-font-size: 3rem;
    --normal-font-size: 1rem;
    --smaller-font-size: 0.875rem;
  }
}

/*===== BASE =====*/
*,
::before,
::after {
  box-sizing: border-box;
}

html {
  scroll-behavior: smooth;
}

body {
  margin: var(--header-height) 0 0 0;
  font-family: var(--body-font);
  font-size: var(--normal-font-size);
  font-weight: var(--font-medium);
  color: var(--dark-color);
  line-height: 1.6;
}

h1,
h2,
h3,
p,
ul {
  margin: 0;
}

ul {
  padding: 0;
  list-style: none;
}

a {
  text-decoration: none;
  color: var(--dark-color);
}

img {
  max-width: 100%;
  height: auto;
  display: block;
}

/*===== CLASS CSS ===== */
.section {
  padding: 5rem 0 2rem;
}

.section-title {
  position: relative;
  font-size: var(--big-font-size);
  margin-bottom: var(--mb-4);
  text-align: center;
  letter-spacing: 0.1rem;
}

.section-title::after {
  content: "";
  position: absolute;
  width: 56px;
  height: 0.18rem;
  top: -1rem;
  left: 0;
  right: 0;
  margin: auto;
  background-color: var(--dark-color);
}

/*===== LAYOUT =====*/
.bd-grid {
  max-width: 1024px;
  display: grid;
  grid-template-columns: 100%;
  column-gap: 2rem;
  width: calc(100% - 2rem);
  margin-left: var(--mb-2);
  margin-right: var(--mb-2);
}

.header-1 {
  width: 100%;
  position: fixed;
  top: 0;
  left: 0;
  z-index: var(--z-fixed);
  background-color: var(--dark-color-lighten);
}

/*===== NAV =====*/
.nav {
  height: var(--header-height);
  display: flex;
  justify-content: space-between;
  align-items: center;
}

@media screen and (max-width: 768px) {
  .nav__menu {
    position: fixed;
    top: var(--header-height);
    left: -100%;
    width: 70%;
    height: 100vh;
    padding: 2rem;
    background-color: var(--white-color);
    transition: 0.5s;
  }

  .nav__item {
    margin-bottom: var(--mb-4);
  }

  .nav__logo {
    font-weight: var(--font-semi-bold);
  }

nav__toggle,
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
/*Show menu*/
.show {
  left: 0;
}
/*Active link*/
.active {
  position: relative;
}

.active::before {
  content: "";
  position: absolute;
  bottom: -0.5rem;
  left: 45%;
  width: 4px;
  height: 4px;
  background-color: var(--dark-color);
  border-radius: 50%;
}

/*Change color header*/

.scroll-header {
  background-color: var(--white-color);
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

/*===== HOME =====*/
.home {
  background-color: var(--dark-color-lighten);
  overflow: hidden;
}

.home__container {
  height: calc(100vh - var(--header-height));
}

.home__sneaker {
  position: relative;
  display: flex;
  justify-content: center;
  align-self: center;
}

.home__shape {
  width: 220px;
  height: 220px;
  background-color: var(--dark-color);
  border-radius: 50%;
}

.home__img {
  position: absolute;
  top: 1.5rem;
  max-width: initial;
  width: 275px;
  transform: var(--rotate-img);
}

.home__new {
  display: block;
  font-size: var(--smaller-font-size);
  font-weight: var(--font-semi-bold);
  margin-bottom: var(--mb-2);
}

.home__title {
  font-size: var(--bigger-font-size);
  margin-bottom: var(--mb-1);
}

.home__description {
  margin-bottom: var(--mb-6);
}

/*BUTTONS*/
.button {
  display: inline-block;
  background-color: var(--dark-color);
  color: var(--white-color);
  padding: 1.125rem 2rem;
  border-radius: 0.5rem;
  transition: 0.3s;
}

.button:hover {
  transform: translateY(-0.25rem);
}

.button-light {
  display: inline-flex;
  color: var(--dark-color);
  font-weight: var(--font-bold);
  align-items: center;
}

.button-icon {
  font-size: 1.25rem;
  margin-left: var(--mb-1);
  transition: 0.3s;
}

.button-light:hover .button-icon {
  transform: translateX(0.25rem);
}

/*===== FEATURED =====*/
.featured__container {
  row-gap: 2rem;
  grid-template-columns: repeat(auto-fit, minmax(220px), 1fr);
}

.sneaker {
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 2rem;
  background-color: var(--dark-color-lighten);
  border-radius: 0.5rem;
  transition: 0.3s;
}

.sneaker__sale {
  position: absolute;
  left: 0.5rem;
  background-color: var(--dark-color);
  color: var(--white-color);
  padding: 0.25rem 0.5rem;
  border-radius: 0.25rem;
  font-size: var(--h2-font-size);
  transform: rotate(-90deg);
  letter-spacing: 0.1rem;
}

.sneaker__img {
  width: 220px;
  margin-top: var(--mb-3);
  margin-bottom: var(--mb-6);
  transform: var(--rotate-img);
  filter: drop-shadow(0 12px 8px rgba(0, 0, 0, 0.2));
}

.sneaker__name,
.sneaker__preci {
  font-size: var(--h2-font-size);
  letter-spacing: 0.1rem;
  font-weight: var(--font-bold);
}

.sneaker__name {
  margin-bottom: var(--mb-1);
}

.sneaker__preci {
  margin-bottom: var(--mb-4);
}

.sneaker:hover {
  transform: translateY(-0.5rem);
}

.sneaker__pages {
  margin-top: var(--mb-6);
}

.sneaker__pag {
  padding: 0.5rem 1rem;
  border: 1px solid var(--dark-color);
  transition: 0.5s;
}

.sneaker__pag:hover {
  background-color: var(--dark-color);
  color: var(--white-color);
}

/*===== COLLECTION =====*/

.collection__container {
  row-gap: 2rem;
  justify-content: center;
}

.collection__card {
  position: relative;
  display: flex;
  height: 328px;
  background-color: var(--dark-color-lighten);
  padding: 2rem;
  border-radius: 0.5rem;
  transition: 0.3s;
}

.collection__data {
  align-self: flex-end;
}

.collection__name {
  font-size: var(--bigger-font-size);
  margin-bottom: 0.25rem;
}

.collection_description {
  margin-bottom: var(--mb-2);
}

.collection__card:hover {
  transform: translateY(-0.5rem);
}

/*===== WOMEN SNEAKERS =====*/
.women__container {
  row-gap: 2rem;
  grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
}

/*===== OFFER =====*/
.offer__container {
  grid-template-columns: 55% 45%;
  column-gap: 0;
  background-color: var(--dark-color-lighten);
  border-radius: 0.5rem;
  justify-content: center;
}

.offer__data {
  padding: 4rem 0 4rem 1.5rem;
}

.offer__title {
  font-size: var(--biggest-font-size);
  margin-bottom: 0.25rem;
}

.offer__description {
  margin-bottom: var(--mb-3);
}

.offer__img {
  width: 153px;
}

/*===== NEW COLLECTION  =====*/
.new__container {
  row-gap: 2rem;
}

.new__mens {
  display: flex;
  flex-direction: column;
  justify-content: center;
  background-color: var(--dark-color-lighten);
  border-radius: 0.5rem;
  padding: 2rem;
}

.new__mens-img {
  width: 276px;
  margin-bottom: var(--mb-3);
}

.new__title {
  font-size: var(--bigger-font-size);
  margin-bottom: 0.25rem;
}

.new__preci {
  display: block;
  margin-bottom: var(--mb-3);
}

.new__sneaker {
  display: grid;
  gap: 1.5rem;
  grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
}

.new__sneaker-card {
  position: relative;
  padding: 3.5rem 1.5rem;
  background-color: var(--dark-color-lighten);
  border-radius: 0.5rem;
  overflow: hidden;
  display: flex;
  justify-content: center;
}

.new__sneaker-img {
  width: 220px;
}

.new__sneaker-overlay {
  position: absolute;
  left: 0;
  bottom: -100%;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgba(138, 138, 138, 0.3);
  transition: 0.3s;
}

.new__sneaker-card:hover .new__sneaker-overlay {
  bottom: 0;
}

/*===== NEWSLETTER =====*/
.newsletter__container {
  background-color: var(--dark-color);
  color: var(--white-color);
  padding: 2rem 0.5rem;
  border-radius: 0.5rem;
  text-align: center;
}

.newsletter__title {
  font-size: var(--bigger-font-size);
  margin-bottom: mb2;
}

.newsletter__description {
  margin-bottom: var(--mb-5);
}

.newsletter__subscribe {
  display: flex;
  column-gap: 0.5rem;
  background-color: var(--white-color);
  padding: 0.5rem;
  border-radius: 0.5rem;
}

.newsletter__input {
  outline: none;
  border: none;
  width: 90%;
  font-size: var(--normal-font-size);
}

.newsletter__input::placeholder {
  color: var(--dark-color);
  font-family: body-font;
  font-size: var(--normal-font-size);
  font-weight: var(--font-semi-bold);
}

/*===== FOOTER =====*/
.footer__container {
  grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
}

.footer__box {
  margin-bottom: var(--mb-4);
}

.footer__title {
  font-size: var(--big-font-size);
}

.footer__link {
  display: block;
  width: max-content;
  margin-bottom: var(--mb-1);
}

.footer__social {
  font-size: 1.5rem;
  margin-right: 1.25rem;
}

.footer__copy {
  padding-top: 3rem;
  font-size: var(--smaller-font-size);
  color: var(--dark-color-light);
  text-align: center;
}

/* ===== MEDIA QUERIES=====*/
@media screen and (min-width: 768px) {
  body {
    margin: 0;
  }

  .section {
    padding: 7rem 0;
  }

  .section-title::after {
    width: 76px;
  }

  .nav {
    height: calc(var(--header-height) + 1.5rem);
  }

  .nav__menu {
    margin-left: auto;
  }

  .nav__list {
    display: flex;
  }

  .nav__item {
    margin-left: var(--mb-6);
    margin-bottom: 0;
  }

  .nav__toggle {
    display: none;
  }

  .home__container {
    height: 100vh;
    grid-template-columns: max-content max-content;
    justify-content: center;
    align-items: center;
  }
  .home__sneaker {
    order: 1;
  }
  .home__shape {
    width: 376px;
    height: 376px;
  }
  .home__img {
    width: 470px;
    top: 3.5rem;
    right: 0;
    left: -3rem;
  }
.search-container {
  position: relative;
}

.search-container input[type="text"] {
  padding: 10px;
  border: none;
  border-radius: 5px;
  margin-right: 10px;
}

#search-icon {
  position: absolute;
  top: 50%;
  right: 0;
  transform: translateY(-50%);
  width: 30px; /* Adjust icon size as needed */
  height: auto;
  cursor: pointer;
}

/* Add hover effect to the icon */
#search-icon:hover {
  opacity: 0.8;
}


/* Add more CSS styles as needed */
  
}
  </style>
</head>

<body>
  <!--===== HEADER =====-->
  <header class="header-1" id="header">
    <nav class="nav bd-grid">
      <div class="nav__toggle" id="nav-toggle">
        <i class="bx bxs-grid"></i>
      </div>

      <a href="/" class="nav__logo">Sneaker-Head</a>

      <div class="nav__menu" id="nav-menu">
        <ul class="nav__list">
          <li class="nav__item"><a href="/" class="nav__link active">Home</a></li>
          <li class="nav__item"><a href="profile" class="nav__link">Profile</a></li>
          <li class="nav__item"><a href="#women" class="nav__link">Women</a></li>
          <li class="nav__item"><a href="#new" class="nav__link">Men</a></li>
          <li class="nav__item"><a href="signup" class="nav__link">SignUp/Login</a></li>
        </ul>
      </div>
<div class="search-container">
  <input type="text" placeholder="Find Your Shoe">
  <img src="https://cdn-icons-png.freepik.com/256/751/751463.png" alt="Search" id="search-icon">
</div>

      
		<div class="nav__shop">
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
  </header>

  <main class="l-main">
    <!--===== HOME =====-->
    <section class="home" id="home">
      <div class="home__container bd-grid">
        <div class="home__sneaker">
          <div class="home__shape"></div>
          <img src="https://freepngimg.com/thumb/shoes/28530-3-nike-shoes-transparent.png" alt="" class="home__img">
        </div>

          <div class="home__data">
            <span class="home__new">New in</span>
            <h1 class="home__title">OVO Nike Air  <br> Jordan 10</h1>
              <p class="home__description">Explore the new collections of sneekers</p>
              <a href="products" class="button">Explore Now</a>
          </div>
        </div>
    </section>

    <!--===== FEATURED =====-->
    <section class="featured section" id="featured">
      <h2 class="section-title">FEATURED</h2>
      <div class="featured__container bd-grid">
        <article class="sneaker">
          <div class="sneaker__sale">Sale</div>
          <img src= "${firstProduct.imageUrl}"alt="" class="sneaker__img">
          <span class="sneaker__name">${firstProduct.name}</span>
          <span class="sneaker__preci">${firstProduct.price}</span>
          <a href="/add" class="button-light">Add to Cart <i class='bx bx-right-arrow-alt button-icon'></i></a>
          <a href="/add" class="button-light">Wishlist <i class='bx bx-right-arrow-alt button-icon'></i></a>
        </article>

        <article class="sneaker">
          <div class="sneaker__sale">Sale</div>
          <img src="${secondProduct.imageUrl}" alt="" class="sneaker__img">
          <span class="sneaker__name">${secondProduct.name}</span>
          <span class="sneaker__preci">${secondProduct.price}</span>
          <a href="" class="button-light">Add to Cart <i class='bx bx-right-arrow-alt button-icon'></i></a>
          <a href="/add" class="button-light">Wishlist <i class='bx bx-right-arrow-alt button-icon'></i></a>
        </article>

        <article class="sneaker">
          <div class="sneaker__sale">Sale</div>
          <img src="${thirdProduct.imageUrl}" alt="" class="sneaker__img">
          <span class="sneaker__name">${thirdProduct.name }</span>
          <span class="sneaker__preci">${thirdProduct.price}</span>
          <a href="" class="button-light">Add to Cart <i class='bx bx-right-arrow-alt button-icon'></i></a>
          <a href="/add" class="button-light">Wishlist <i class='bx bx-right-arrow-alt button-icon'></i></a>
        </article>
      </div>
    </section>

    <!--===== COLLECTION =====-->
    <section class="collection section">
      <div class="collection__container bd-grid">
        <div class="collection__card">
          <div class="collection__data">
            <h3 class="collection__name">Nike</h3>
            <p class="collection__description">New collection 2021</p>
            <a href="#" class="button-light">Buy now <i class='bx bx-right-arrow-alt button-icon'></i></a>
          </div>

          <img src="https://github.com/bedimcode/responsive-ecommerce-website-sneakers/blob/master/assets/img/collection1.png?raw=true" alt="" class="collection__img">
        </div>

          <div class="collection__card">
            <div class="collection__data">
              <h3 class="collection__name">Adidas</h3>
              <p class="collection__description">New collection 2021</p>
              <a href="#" class="button-light">Buy now
                <i class='bx bx-right-arrow-alt button-icon'></i></a>
            </div>

            <img src="https://github.com/bedimcode/responsive-ecommerce-website-sneakers/blob/master/assets/img/collection2.png?raw=true" alt="" class="collection__img">
        </div>
          </div>
    </section>

    <!--===== WOMEN SNEAKERS =====-->
    <section class="women section" id="women">
      <h2 class="section-title">WOMEN SNEAKERS</h2>

      <div class="women__container bd-grid">
        <article class="sneaker">
          <img src="${fourthProduct.imageUrl}" alt="" class="sneaker__img">
          <span class="sneaker__name">${fourthProduct.name}</span>
          <span class="sneaker__preci">${fourthProduct.price}</span>
          <a href="" class="button-light">Add to Cart <i class='bx bx-right-arrow-alt button-icon'></i></a>
          <a href="" class="button-light">Wishlist <i class='bx bx-right-arrow-alt button-icon'></i></a>
        </article>

        <article class="sneaker">
          <img src="${fifthProduct.imageUrl}" alt="" class="sneaker__img">
          <span class="sneaker__name">${fifthProduct.name}</span>
          <span class="sneaker__preci">${fifthProduct.price}</span>
          <a href="" class="button-light">Add to Cart <i class='bx bx-right-arrow-alt button-icon'></i></a>
          <a href="" class="button-light">Wishlist <i class='bx bx-right-arrow-alt button-icon'></i></a>
        </article>

        <article class="sneaker">
          <img src="${sixthProduct.imageUrl}" alt="" class="sneaker__img">
          <span class="sneaker__name">${sixthProduct.name}</span>
          <span class="sneaker__preci">${sixthProduct.price}</span>
          <a href="" class="button-light">Add to Cart <i class='bx bx-right-arrow-alt button-icon'></i></a>
          <a href="" class="button-light">Wishlist <i class='bx bx-right-arrow-alt button-icon'></i></a>
        </article>

        <article class="sneaker">
          <img src="${seventhProduct.imageUrl}" alt="" class="sneaker__img">
          <span class="sneaker__name">${seventhProduct.name}</span>
          <span class="sneaker__preci">${seventhProduct.price}</span>
          <a href="" class="button-light">Add to Cart <i class='bx bx-right-arrow-alt button-icon'></i></a>
          <a href="" class="button-light">Wishlist <i class='bx bx-right-arrow-alt button-icon'></i></a>
        </article>
      </div>
    </section>

    <!--===== OFFER =====-->
    <section class="offer section">
      <div class="offer__container bd-grid">
        <div class="offer__data">
          <h3 class="offer__title">50% OFF</h3>
          <p class="offer__description">In Adidas Superstar Sneakers</p>
          <a href="#" class="button">Shop Now</a>
        </div>

        <img src="https://freepngimg.com/thumb/shoes/55565-3-sneakers-picture-free-hd-image.png" alt="" class="offer__img">
      </div>
    </section>

    <!--===== NEW COLLECTION =====-->
    <section class="new section" id="new">
      <h2 class="section-title">MENS SNEAKERS</h2>

      <div class="new__container bd-grid">
        <div class="new__mens">
          <img src="${firstProduct.imageUrl}" alt="" class="new__mens-img">
          <h3 class="new__title">Mens Shoes</h3>
          <span class="new__preci">From Rs.2500</span>
          <a href="#" class="button-light">View Collection
            <i class='bx bx-right-arrow-alt button-icon'></i></a>
        </div>

        <div class="new__sneaker">
          <div class="new__sneaker-card">
            <img src="${eighthProduct.imageUrl}" alt="" class="new__sneaker-img">
            <div class="new__sneaker-overlay">
              <a href="#" class="button">Add to Cart</a>
            </div>
          </div>

          <div class="new__sneaker-card">
            <img src="${ninthProduct.imageUrl}" alt="" class="new__sneaker-img">
            <div class="new__sneaker-overlay">
              <a href="#" class="button">Add to Cart</a>
            </div>
          </div>

          <div class="new__sneaker-card">
            <img src="${tenthProduct.imageUrl}" alt="" class="new__sneaker-img">
            <div class="new__sneaker-overlay">
              <a href="#" class="button">Add to Cart</a>
            </div>
          </div>

          <div class="new__sneaker-card">
            <img src="${eleventhProduct.imageUrl}" alt="" class="new__sneaker-img">
            <div class="new__sneaker-overlay">
              <a href="#" class="button">Add to Cart</a>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!--===== NEWSLETTER =====-->

<!--     <section class="newsletter section">
      <div class="newsletter__container bd-grid">
        <div>
          <h3 class="newsletter__title">Subscribe and Get <br> 10% OFF</h3>
            <p class="newsletter__description">Get 10% discount for all products</p>
        </div>

        <form action="" class="newsletter__subscribe">
          <input type="text" placeholder="@email.com" class="newsletter__input">
          <a href="#" class="button">Subscribe</a>
        </form>
      </div>
    </section> -->
  </main>

  <!--===== FOOTER =====-->
<!--   <footer class="footer section">
    <div class="footer__container bd-grid">
      <div class="footer__box">
        <h3 class="footer__title">Ivy</h3>
        <p class="footer__description">New collection of shoes 2021.</p>
      </div> -->

<!--       <div class="footer__box">
        <h3 class="footer__title">EXPLORE</h3>
        <ul>
          <li><a href="#home" class="footer__link">Home</a></li>
          <li><a href="#featured" class="footer__link">Featured</a></li>
          <li><a href="#women" class="footer__link">Women</a></li>
          <li><a href="#new" class="footer__link">New</a></li>
        </ul>
      </div> -->

<!--       <div class="footer__box">
        <h3 class="footer__title">SUPPORT</h3>
        <ul>
          <li><a href="#" class="footer__link">Product Help</a></li>
          <li><a href="#" class="footer__link">Customer Care</a></li>
          <li><a href="#" class="footer__link">Authorized Service</a></li>
        </ul>
      </div> -->

 <!--      <div class="footer__box">
        <a href="#" class="footer__social"><i class='bx bxl-facebook'></i></a>
        <a href="#" class="footer__social"><i class='bx bxl-instagram'></i></a>
        <a href="#" class="footer__social"><i class='bx bxl-twitter'></i></a>
        <a href="#" class="footer__social"><i class='bx bxl-youtube'></i></a>
      </div>
    </div> -->

<!--     <p class="footer__copy"> &#169;2021 praiseShalom. All rights reserved </p> -->
<!--   </footer> -->

  <!--===== MAIN JS =====-->
  <script type="script" src="assets/js/main.js"></script>
  <script type="text/javascript">
  /*===== MENU SHOW =====*/
  const showMenu = (toggleId, navId) => {
    const toggle = document.getElementById(toggleId),
      nav = document.getElementById(navId);

    if (toggle && nav) {
      toggle.addEventListener("click", () => {
        nav.classList.toggle("show");
      });
    }
  };

  showMenu("nav-toggle", "nav-menu");

  /*===== REMOVE MENU =====*/
  const navLink = document.querySelectorAll(".nav__link"),
    navMenu = document.getElementById("nav-menu");

  function linkAction() {
    navMenu.classList.remove("show");
  }

  navLink.forEach(n => n.addEventListener("click", linkAction));

  /*===== SCROLL SECTIONS ACTIVE LINK =====*/
  const sections = document.querySelectorAll("section[id]");

  window.addEventListener("scroll", scrollActive);

  function scrollActive() {
    const scrollY = window.pageYOffset;

    sections.forEach(current => {
      const sectionHeight = current.offsetHeight;
      const sectionTop = current.offsetTop - 50;
      sectionId = current.getAttribute("id");

      if (scrollY > sectionTop && scrollY <= sectionTop + sectionHeight) {
        document
          .querySelector(".nav__menu a[href*=" + sectionId + "]")
          .classList.add("active");
      } else {
        document
          .querySelector(".nav__menu a[href*=" + sectionId + "]")
          .classList.remove("active");
      }
    });
  }

  /*===== CHANGE COLOR HEADER =====*/
  window.onscroll = () => {
    const nav = document.getElementById("header");
    if (this.scrollY >= 200) nav.classList.add("scroll-header");
    else nav.classList.remove("scroll-header");
  };
  </script>
</body>

</html>

