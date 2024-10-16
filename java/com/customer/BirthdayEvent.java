package com.customer;

public class BirthdayEvent {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String location;
    private String eventDate;
    private String participants;
    private String specialRequests;

    // Constructor
    public BirthdayEvent(int id, String name, String email, String phone, String location, String eventDate, String participants, String specialRequests) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.eventDate = eventDate;
        this.participants = participants;
        this.specialRequests = specialRequests;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }
}
