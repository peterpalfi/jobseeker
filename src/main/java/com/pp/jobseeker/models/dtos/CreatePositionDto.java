package com.pp.jobseeker.models.dtos;

import com.pp.jobseeker.models.Position;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CreatePositionDto {

    @NotEmpty(message = "Invalid Name: Should not be empty")
    @Size(max = 50, message = "Invalid Name: Length exceeds 50 characters")
    private String name;

    @NotEmpty(message = "Invalid Location: Should not be empty")
    @Size(max = 50, message = "Invalid Location: Length exceeds 50 characters")
    private String location;

    @NotEmpty(message = "Invalid API Key: Should not be empty")
    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$",
             message = "Invalid API Key: Incorrect format")
    private String apiKey;

    public Position toPosition() {
        return new Position()
                .setName(name)
                .setLocation(location);
    }
}
