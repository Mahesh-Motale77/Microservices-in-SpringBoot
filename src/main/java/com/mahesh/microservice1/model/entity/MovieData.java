package com.mahesh.microservice1.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "movietable")
public class MovieData {
    @Id
    private int mid;

    @NotBlank(message = "Movie name should not be Blank")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Movie name should include only alphabets and digits.")
    @Column(name="MovieName")
    private String mname;

    @Pattern(regexp = "^(Action|Drama|Horror|Comedy|Comedy plus Horror|Sci-Fi)$", message = "Type must be of Action|Drama|Horror|Comedy|Comedy plus Horror|Sci-Fi")
    @Column(name="MovieType")
    private String mtype;

    @Min(value = 1900, message = "Release year must be greater than or equal to 1900")
    @Max(value = 2025, message = "Release year must be less than or equal to 2025")
    @Column(name="MovieRelease")
    private int mrelease;


}
