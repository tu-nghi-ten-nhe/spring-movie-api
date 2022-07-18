package com.example.assignmentmovie.dto;

import com.example.assignmentmovie.entity.CastEntity;
import com.example.assignmentmovie.entity.CategoryEntity;
import com.example.assignmentmovie.entity.DirectorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private int id;
    @NotBlank(message = "Please input name")
    private String name;
    @NotBlank(message = "Please input description")
    private String description;
    @NotBlank(message = "Please input thumbnail")
    private String thumbnail;
    @Min(1)
    private int view;
    @Min(1)
    private int category_id;
    @Min(1)
    private int director_id;
    private List<MovieDTO> casts;
    private Date created_at;
    private Date updated_at;
}
