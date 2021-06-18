package com.nie.controller;

import com.nie.pojo.Operation;
import com.nie.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping("/operations/{opName}")
    public Operation getOpByName(@PathVariable("opName") String opName){
        return operationService.queryOpByName(opName);
    }

    @GetMapping("/operations")
    public List<Operation> getOpList(){
        return operationService.queryOpList();
    }

    @PostMapping("/operations")
    public int createOp(Operation op){
        return operationService.createOp(op);
    }

    @PatchMapping("/operations/{id}")
    public int updateOp(@PathVariable("id") int id, Operation op){
        return operationService.updateOp(op);
    }

    @DeleteMapping("/operations/{id}")
    public int deleteOp(@PathVariable("id") int id){
        return operationService.deleteOp(id);
    }
}
