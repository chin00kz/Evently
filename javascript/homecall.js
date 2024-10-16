// Selecting elements
const hamburger = document.querySelector('.hamburger');
const navLinks = document.querySelector('.nav-links');

// Toggle menu
hamburger.addEventListener('click', () => {
    navLinks.classList.toggle('active');
});
