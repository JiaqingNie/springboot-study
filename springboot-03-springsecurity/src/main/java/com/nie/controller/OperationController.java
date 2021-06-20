package com.nie.controller;

import com.nie.pojo.Operation;
import com.nie.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping("/operations/{opName}")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_OPERATION_READ')")
    public Operation getOpByName(@PathVariable("opName") String opName){
        return operationService.queryOpByName(opName);
    }

    @GetMapping("/operations")
    @PreAuthorize("hasAuthority('OP_OPERATION_READ')")
    public List<Operation> getOpList(){
        return operationService.queryOpList();
    }

    @PostMapping("/operations")
    @PreAuthorize("hasAuthority('OP_OPERATION_CREATE')")
    public int createOp(Operation op){
        return operationService.createOp(op);
    }

    @PatchMapping("/operations/{id}")
    @PreAuthorize("hasAuthority('OP_OPERATION_UPDATE')")
    public int updateOp(@PathVariable("id") int id, Operation op){
        return operationService.updateOp(op);
    }

    @DeleteMapping("/operations/{id}")
    @PreAuthorize("hasAuthority('OP_OPERATION_DELETE')")
    public int deleteOp(@PathVariable("id") int id){
        return operationService.deleteOp(id);
    }
}
