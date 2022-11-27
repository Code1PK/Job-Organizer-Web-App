package com.LiftOff.Job_Organizer.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

@Entity
public class Customer {

   @Id
   @GeneratedValue
    private int id;

    @NotBlank(message = "First name is required")
    @Size (min = 1, max = 100, message = "First Name must be between 1 to 100 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size (min = 1, max = 100, message = "Last Name must be between 1 to 100 characters")
    private String lastName;

    @NotBlank
    @Email (message = "Invalid Email")
    private String email;

    @NotBlank (message = "Password cannot be empty")
    @Size (min = 8, max = 20, message = "Password must be between 8 to 20 characters")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
