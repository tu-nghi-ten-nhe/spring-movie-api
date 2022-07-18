package com.example.assignmentmovie.controller;

import com.example.assignmentmovie.database.BaseResponse;
import com.example.assignmentmovie.dto.CategoryDTO;
import com.example.assignmentmovie.service.CategoryService;
import com.sun.javafx.runtime.async.BackgroundExecutor;
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
@RequestMapping("/apiCategory")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/getListCategory")
    public ResponseEntity getListCategory(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                          @RequestParam(value = "limit", required = false, defaultValue = "5") String limit){
        BaseResponse res = new BaseResponse();
        res.data = categoryService.getAllCategory(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity getCategoryById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse();
        res.data = categoryService.getById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/createCategory")
    public ResponseEntity createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        BaseResponse res = new BaseResponse();
        res.data = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity updateCategory(@Valid @PathVariable("id") int id, @RequestBody CategoryDTO categoryDTO){
        BaseResponse res = new BaseResponse();
        CategoryDTO categoryDTO1  = categoryService.getById(id);
        categoryDTO1.setName(categoryDTO.getName());
        categoryService.createCategory(categoryDTO1);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity deleteCategory(@PathVariable("id") int id){
        categoryService.deleteCategory(id);
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
