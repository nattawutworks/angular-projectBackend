package com.example.angularprojectbackend.controller;


import com.example.angularprojectbackend.model.Register;
import com.example.angularprojectbackend.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/odds")
@RestController

public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping()
    public ResponseEntity<Register> createRegister(@RequestBody Register dataRequest) throws Exception{
        return new ResponseEntity<>(registerService.createRegister(dataRequest), HttpStatus.OK);
    }

    @GetMapping()
    public List<Register> listAllStudent(){
        return registerService.listAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Register> searchById(@PathVariable(value = "id")String  studentId) throws Exception{
        return new ResponseEntity<>(registerService.searchById(studentId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Register> updateById(@PathVariable(value = "id")String studentId,@RequestBody Register dataRequest) throws Exception{
        return new ResponseEntity<>(registerService.updateById(studentId,dataRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Register> deleteById(@PathVariable(value = "id")String studentId) throws Exception{
        return  new ResponseEntity<>(registerService.deleteById(studentId), HttpStatus.OK);
    }
}