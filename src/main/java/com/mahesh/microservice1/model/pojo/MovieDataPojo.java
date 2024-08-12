package com.mahesh.microservice1.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class MovieDataPojo {
    private int mid;

    @NotBlank(message = "Movie name should not be Blank")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Movie name should include only alphabets and digits.")
    private String mname;

    @Pattern(regexp = "^(Action|Drama|Horror|Comedy|Comedy plus Horror|Sci-Fi)$", message = "Type must be of Action|Drama|Horror|Comedy|Comedy plus Horror|Sci-Fi")
    private String mtype;

    @Min(value = 1900, message = "Release year must be greater than or equal to 1900")
    @Max(value = 2025, message = "Release year must be less than or equal to 2025")
    private int mrelease;

}
