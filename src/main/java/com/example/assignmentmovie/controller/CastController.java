package com.example.assignmentmovie.controller;

import com.example.assignmentmovie.database.BaseResponse;
import com.example.assignmentmovie.dto.CastDTO;
import com.example.assignmentmovie.service.CastService;
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
@RequestMapping("/apiCast")
public class CastController {
    @Autowired
    CastService castService;

    @GetMapping("/getListCast")
    public ResponseEntity getCast(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                  @RequestParam(value = "limit", required = false, defaultValue = "5") String limit){
        BaseResponse res = new BaseResponse();
        res.data = castService.getAllCast(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @PostMapping("/createCast")
    public ResponseEntity createCast(@Valid @RequestBody CastDTO castDTO){
        BaseResponse res = new BaseResponse();
        res.data = castService.createCast(castDTO);
        return ResponseEntity.ok(res);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse();
        res.data = castService.getById(id);
        return ResponseEntity.ok(res);
    }
    @PutMapping("/updateCast/{id}")
    public ResponseEntity updateCast(@Valid @PathVariable("id") int id, @RequestBody CastDTO castDTO){
        BaseResponse res = new BaseResponse();
        CastDTO castDTO1 = castService.getById(id);
        castDTO1.setName(castDTO.getName());
        castDTO1.setAvatar(castDTO.getAvatar());
        res.data = castService.createCast(castDTO1);
        return ResponseEntity.ok(res);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCast(@PathVariable("id") int id){
        castService.deleteById(id);
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
