package com.example.assignmentmovie.controller;
import com.example.assignmentmovie.database.BaseResponse;
import com.example.assignmentmovie.dto.MovieDTO;
import com.example.assignmentmovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/apiMovie")
public class  MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/getListMovie")
    public ResponseEntity getListMovie(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                       @RequestParam(value = "limit", required = false, defaultValue = "5") String limit){
        BaseResponse res = new BaseResponse();
        res.data = movieService.getAllMovie(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/getMovieById/{id}")
    public ResponseEntity getMovieById (@PathVariable("id") int id){
        BaseResponse res = new BaseResponse();
        res.data = movieService.getById(id);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/createMovie")
    public ResponseEntity createMovie(@Valid  @RequestBody MovieDTO movieDTO){
        BaseResponse res = new BaseResponse();
        res.data = movieService.createMovie(movieDTO);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/updateMovie/{id}")
    public ResponseEntity updateMovie(@Valid @PathVariable("id") int id, @RequestBody MovieDTO movieDTO){
        BaseResponse res = new BaseResponse();
        MovieDTO movieDTO1 = movieService.getById(id);

        movieDTO1.setName(movieDTO.getName());
        movieDTO1.setDescription(movieDTO.getDescription());
        movieDTO1.setThumbnail(movieDTO.getThumbnail());
        movieDTO1.setView(movieDTO.getView());
        movieDTO1.setCategory_id(movieDTO.getCategory_id());
        movieDTO1.setDirector_id(movieDTO.getDirector_id());
        movieService.createMovie(movieDTO1);

        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public ResponseEntity deleteMovie(@PathVariable("id") int id){
        movieService.deleteById(id);
        return ResponseEntity.ok("deleted success");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
