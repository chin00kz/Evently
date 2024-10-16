<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Supplier Service</title>
    <link rel="stylesheet" href="css/addservice-style.css">
</head>
<body>
    <div class="container">
        <h2>Add Supplier Service</h2>
        <form action="addsupservice" method="post" >
            <div class="form-group">
                <label for="supplierName">Supplier Name:</label>
                <input type="text" id="supplier_name" name="supplier_name" required>
            </div>

            <div class="form-group">
                <label for="companyName">Company Name:</label>
                <input type="text" id="company_name" name="company_name" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label for="phoneNumber">Phone Number:</label>
                <input type="tel" id="phone_number" name="phone_number" required>
            </div>

            <div class="form-group">
                <label for="country">Country:</label>
                <input type="text" id="country" name="country" required>
            </div>

            <div class="form-group">
                <label for="serviceType">Service Type:</label>
                <select id="service_type" name="service_type" required>
                    <option value="">Select a service type</option>
                    <option value="Florists">Florists</option>
                    <option value="DJ/Music">DJ/Music</option>
                    <option value="Catering">Catering</option>
                    <option value="Photographers/Videographers">Photographers/Videographers</option>
                    <option value="Event Decorators">Event Decorators</option>
                    <option value="Lighting and Sound">Lighting and Sound</option>
                    <option value="Stage Setup">Stage Setup</option>
                    <option value="Event Planners">Event Planners</option>
                    <option value="Transportation Services">Transportation Services</option>
                    <option value="Venue Providers">Venue Providers</option>
                    <option value="Security Services">Security Services</option>
                    <option value="Furniture/Seating">Furniture/Seating</option>
                    <option value="Entertainment">Entertainment</option>
                </select>
            </div>

            <div class="form-group">
                <label for="serviceDescription">Service Description:</label>
                <textarea id="service_description" name="service_description");" rows="4" required></textarea>
            </div>

            <div class="form-group">
                <input type="submit" value="Add Service" class="submit-btn">
            </div>
        </form>
    </div>
</body>
</html>