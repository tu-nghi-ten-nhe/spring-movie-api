package com.example.assignmentmovie.controller;

import com.example.assignmentmovie.database.BaseResponse;
import com.example.assignmentmovie.dto.DirectorDTO;
import com.example.assignmentmovie.service.DirectorService;
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
@RequestMapping("/apiDirector")
public class DirectorController {
    @Autowired
    DirectorService directorService;

    @GetMapping("/getListDirector")
    public ResponseEntity getList(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                  @RequestParam(value = "limit", required = false, defaultValue = "5") String limit){
        BaseResponse res = new BaseResponse();
        res.data = directorService.getAllDirector(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @PostMapping("/createDirector")
    public ResponseEntity createDirector(@Valid @RequestBody DirectorDTO directorDTO){
        BaseResponse res = new BaseResponse();
        res.data = directorService.createDirector(directorDTO);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/getDirectorById/{id}")
    public  ResponseEntity getDirectorById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse();
        res.data = directorService.getById(id);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/updateDirector/{id}")
    public ResponseEntity updateDirector(@Valid @PathVariable("id") int id, @RequestBody DirectorDTO directorDTO){
        BaseResponse res  = new BaseResponse();
        DirectorDTO directorDTO1 = directorService.getById(id);
        directorDTO1.setName(directorDTO.getName());
        directorDTO1.setAvatar(directorDTO.getAvatar());
        directorService.createDirector(directorDTO);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/deleteDirector/{id}")
    public ResponseEntity deleteDirector(@PathVariable("id") int id){
        directorService.deleteById(id);
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