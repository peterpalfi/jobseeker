package com.pp.jobseeker.models.dtos;

import com.pp.jobseeker.models.Client;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.UUID;

@Data
public class RegisterClientDto {

    @NotEmpty(message = "Invalid Name: Should not be empty")
    @Size(max = 100, message = "Invalid Name: Length exceeds 100 characters")
    private String name;

    @NotEmpty(message = "Invalid Email: Should not be empty")
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
             message = "Invalid Email: Incorrect format")
//    @Email(message = "Invalid Email: Incorrect format", flags = { Flag.CASE_INSENSITIVE })
    private String email;

    public Client toClient() {
        return new Client()
                .setName(name)
                .setEmail(email)
                .setApiKey(UUID.randomUUID());
    }
}
