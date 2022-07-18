package com.example.assignmentmovie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDTO {
    private int id;
    @NotBlank(message = "Please input name")
    private String name;
    @NotBlank(message = "Please input avatar")
    private String avatar;
    private Date created_at;
    private Date updated_at;
}
