package com.pp.jobseeker.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Table(name = "positions")
@Accessors(chain = true)
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id of the Position", name="id", required=true, value = "1")
    @Column(name = "id", nullable = false)
    private Long id;

    @ApiModelProperty(notes = "Name of the Position", name="name", required=true, value = "Example Position")
    @Column(name = "name", nullable = false)
    private String name;

    @ApiModelProperty(notes = "Location of the Position", name="location", required=true, value = "Somewhere")
    @Column(name = "location", nullable = false)
    private String location;
}
