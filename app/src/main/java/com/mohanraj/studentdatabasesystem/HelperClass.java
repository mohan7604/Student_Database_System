package com.mohanraj.studentdatabasesystem;

import java.security.SecureRandom;

public class HelperClass {
    String name;
    String email;
    String username;
    String password;
    String department;
    String section;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public HelperClass(String name, String email, String username, String password, String department, String section) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.department = department;
        this.section = section;
    }

    public HelperClass() {
    }
}

