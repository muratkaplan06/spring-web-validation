package com.yteintern.springweb.data;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Date;

public record User(
        @NotEmpty(message = "Name is required")
        String Name,
        @NotEmpty(message = "Surname is required")
        String Surname,
        @NotEmpty(message = "Email is required")
        @Email(message = "Email should be valid")
        String Email,
        @Min(value = 12, message = "Age must be greater than 12")
        @Max(value = 100, message = "Age must be less than 100")
        int Age,
        String TcNo,
        @PastOrPresent(message = "Birthday date must be past or present")
        LocalDate BirthdayDate,
        @Size(max=250, message = "Address must be less than 250 characters")
        String Address,
        @NotBlank(message = "Username is required")
        String Username
) {
    @AssertTrue(message = "Username must be different from admin")
    public boolean isUsernameValid() {
        return !Username.equals("admin");
    }

}
