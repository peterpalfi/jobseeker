package com.pp.jobseeker.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "clients")
@Accessors(chain = true)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id of the Client", name="id", required=true, value = "1")
    @Column(name = "id", nullable = false)
    private Long id;

    @ApiModelProperty(notes = "Name of the Client", name="name", required=true, value = "Example Client")
    @Column(name = "name", nullable = false)
    private String name;

    @ApiModelProperty(notes = "Email of the Client", name="email", required=true, value = "test@email.com")
    @Column(name = "email", nullable = false)
    private String email;

    @ApiModelProperty(notes = "UUID allocated for the Client", name="apiKey", required=true, value = "51587b10-3004-417e-abe7-4dab7cdf0bd5")
    @Column(name = "api_key", nullable = false)
    @Type(type = "uuid-char")
    private UUID apiKey;
}
