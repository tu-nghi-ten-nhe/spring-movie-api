package com.example.assignmentmovie.dto;

import com.example.assignmentmovie.entity.MovieEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CastDTO {
    private int id;
    @NotBlank(message = "Please input name")
    private String name;
    @NotBlank(message = "Please input avatar")
    private String avatar;
    List<MovieDTO> movies;
    private Date created_at;
    private Date updated_at;
}
