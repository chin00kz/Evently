<!DOCTYPE html> 
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us - Evently</title>
    
    <!-- Link to the external CSS file -->
    <link rel="stylesheet" href="css/contactcall.css">
</head>
<body>

    <!-- Include the shared header -->
    <jsp:include page="header.jsp" />

    <!-- Contact form section -->
    <section class="contact-form-section">
        <h2>Drop Us A Message (24x7 Support)</h2>
        <p>We are committed to providing exceptional service and support for your events.</p>

        <form id="contact-form">
            <div class="form-group">
                <input type="text" name="full-name" placeholder="Full Name" required>
                <input type="email" name="email" placeholder="Email Address" required>
            </div>
            <div class="form-group">
                <input type="text" name="phone-number" placeholder="Phone Number" required>
                <input type="text" name="event-type" placeholder="Type of Event" required>
            </div>
            <div class="form-group">
                <textarea name="message" rows="6" placeholder="Write Message" required></textarea>
            </div>
            <button type="submit" class="btn-submit">Send Message</button>
        </form>
    </section>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 Evently. All Rights Reserved.</p>
    </footer>

    <!-- Link to the external JS file -->
    <script src="contact.js"></script>

</body>
</html>
