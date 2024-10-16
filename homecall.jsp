<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Evently - Your Perfect Event</title>
    <link rel="stylesheet" href="css/homecall.css">
</head>
<body>

    <!-- Include Header -->
    <%@ include file="header.jsp" %>

    <!-- Main Content -->
    <div class="main-content">
        <section class="hero">
            <div class="overlay"></div>
            <h1>Welcome to Evently</h1>
            <p>Your Perfect Event Begins with Us</p>
        </section>

        <section id="about" class="section">
            <h2>About Us</h2>
            <p> At Evently, we specialize in organizing weddings, parties, reunions, and shows. Our team brings your vision to life with creativity and care, making your special day unforgettable!</p>
        </section>

        <%@ include file="services.jsp" %>

        <section id="portfolio" class="section">
            <h2>Portfolio</h2>
            <p>Take a look at some of our past events!</p>
        </section>
    </div>

    <!-- Counter Section with Description -->
    <section class="counters">
        <div class="description">
            <h3>Your Trusted Event Partner</h3>
            <p>Our team has successfully completed numerous events, transforming your dreams into reality with our expertise and dedication. We are here to create unforgettable experiences, one event at a time.</p>
        </div>
        <div class="counter-items">
            <div class="counter-item">
                <h3>Completed Projects</h3>
                <p class="counter">150</p>
            </div>
            <div class="counter-item">
                <h3>Satisfied Clients</h3>
                <p class="counter">200+</p>
            </div>
            <div class="counter-item">
                <h3>Years of Experience</h3>
                <p class="counter">5</p>
            </div>
        </div>
    </section>

    <!-- Footer Section -->
    <footer>
        <div class="footer-container">
            <div class="footer-logo">
                <img src="css/images/logo2.png" alt="Evently Logo">
                <p>We aim to lift the burden off your shoulders by offering you the promise of professionalism, outstanding quality, and dedication in delivering an ultimate impeccable experience.</p>
            </div>
            <div class="footer-contact">
                <h3>Contact</h3>
                <p>Kengolla, Kandy 20186</p>
                <p><i class="fas fa-phone"></i> +94 70 225 2661</p>
                <p><i class="fas fa-phone"></i> +94 76 005 6232</p>
                <p><i class="fas fa-envelope"></i> info@evently.lk</p>
            </div>
            <div class="footer-social">
                <h3>Social</h3>
                <ul>
                    <li><a href="#"><i class="fab fa-facebook"></i> Facebook</a></li>
                    <li><a href="#"><i class="fab fa-instagram"></i> Instagram</a></li>
                    <li><a href="#"><i class="fab fa-linkedin"></i> LinkedIn</a></li>
                </ul>
            </div>
        </div>
        <div class="footer-bottom">
            <p>Copyright 2024 by Evently Crew</p>
        </div>
    </footer>

    <script src="JavaScript/homecall.js"></script>
</body>
</html>
