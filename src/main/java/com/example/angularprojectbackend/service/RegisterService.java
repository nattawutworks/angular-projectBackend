package com.example.angularprojectbackend.service;

import com.example.angularprojectbackend.model.Register;
import com.example.angularprojectbackend.repository.RegisterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record RegisterService (RegisterRepository registerRepository,
                               SendMailRegisterService sendMailRegisterService){

    public Register createRegister(Register dataRequest) throws Exception {
        try {
            sendMailRegisterService.mailToRegister();
            return registerRepository.save(dataRequest);
        } catch (Exception e) {
            throw new Exception("Error Create Data");
        }
    }

    public List<Register> listAllStudent() {
        return registerRepository.findAll();
    }


    public Register searchById(String registerId) throws Exception {
        return registerRepository.findById(registerId)
                .orElseThrow(() -> new Exception("Error Search Data"));
    }

    public Register updateById(String registerId, Register dataRequest) throws Exception {
        Register register = registerRepository.findById(registerId)
                .orElseThrow(() -> new Exception("Error Update Data"));

        register.setFullName(dataRequest.getFullName());
        register.setEmail(dataRequest.getEmail());
        register.setPassword(dataRequest.getPassword());
        register.setTel(dataRequest.getTel());
        register.setBirthDay(dataRequest.getBirthDay());
        register.setSex(dataRequest.getSex());

        try {
            return registerRepository.save(register);
        } catch (Exception e) {
            throw new Exception("Error Update Data", e);
        }
    }

    public Register deleteById(String studentId) throws Exception{
        registerRepository.deleteById(studentId);
        return null;

    }
}

