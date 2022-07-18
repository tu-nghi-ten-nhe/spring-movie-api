package com.example.assignmentmovie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private int id;
    @NotBlank(message = "Please input name")
    private String name;
    private Date created_at;
    private Date updated_at;
}
