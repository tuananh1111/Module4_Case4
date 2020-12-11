package com.casestudy.case4.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String addressDetails;

    @Pattern(regexp="(^$|[0-9]{10})")
    private String hotline;

    private String description;

    @Column(columnDefinition = "boolean default false")
    private boolean status;

    @ManyToOne
    private Province province;

    @ManyToOne
    private User user;

}
