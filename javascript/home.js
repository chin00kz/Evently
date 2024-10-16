// Mobile Navigation Toggle
const hamburger = document.querySelector(".hamburger");
const navLinks = document.querySelector(".nav-links");

hamburger.addEventListener("click", () => {
    navLinks.classList.toggle("open");
});

// Background Image Carousel for Hero Section
const heroSection = document.querySelector('.hero');
const images = ['images/event1.jpg', 'images/event2.jpg', 'images/event3.jpg'];
let currentIndex = 0;

function changeBackground() {
    currentIndex = (currentIndex + 1) % images.length;
    heroSection.style.backgroundImage = `url(${images[currentIndex]})`;
}

// Change the background image every 5 seconds
setInterval(changeBackground, 5000);

// Counter Animation
const counters = document.querySelectorAll('.counter');

counters.forEach(counter => {
    counter.innerText = '0';

    const updateCounter = () => {
        const target = +counter.getAttribute('data-target');
        const current = +counter.innerText;
        const increment = target / 200;

        if (current < target) {
            counter.innerText = `${Math.ceil(current + increment)}`;
            setTimeout(updateCounter, 10);
        } else {
            counter.innerText = target;
        }
    };

    updateCounter();
});

document.addEventListener('DOMContentLoaded', function() {
    const hamburger = document.querySelector('.hamburger');
    const navLinks = document.querySelector('.nav-links');

    hamburger.addEventListener('click', function() {
        navLinks.classList.toggle('active');
    });
});