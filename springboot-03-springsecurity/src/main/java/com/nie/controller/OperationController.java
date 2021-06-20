package com.nie.controller;

import com.nie.pojo.Operation;
import com.nie.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OperationController {

    @Autowired
    private OperationService operationService;

    /**
     * 通过名字检索权限
     * @param opName 权限名
     * @return 该权限名对应的权限
     */
    @GetMapping("/operations/{opName}")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_OPERATION_READ')")
    public Operation getOpByName(@PathVariable("opName") String opName){
        return operationService.queryOpByName(opName);
    }

    /**
     * 获取权限清单页面
     * @param model spring ui model
     * @return 权限清单页面
     */
    @GetMapping("/operations")
    @PreAuthorize("hasAuthority('OP_OPERATION_READ')")
    public String getOpList(Model model){
        List<Operation> operations = operationService.queryOpList();
        model.addAttribute("operations", operations);
        return "operation/list";
    }

    /**
     * 获取权限创建页面
     * @return 权限创建页面
     */
    @GetMapping("/operations/new")
    @PreAuthorize("hasAuthority('OP_OPERATION_CREATE')")
    public String getOpNewPage() {
        return "operation/new";
    }

    /**
     * 获取权限修改页面
     * @param id 要被修改的权限ID
     * @param model spring ui model
     * @return 权限修改页面
     */
    @GetMapping("/operations/{id}/edit")
    @PreAuthorize("hasAuthority('OP_OPERATION_UPDATE')")
    public String getOpEditPage(@PathVariable("id") int id, Model model) {
        Operation operation = operationService.queryOpById(id);
        model.addAttribute("operation", operation);
        return "operation/edit";
    }

    /**
     * 创建新的权限
     * @param op 要被创建的权限
     * @return 服务层返回的代码（1 表示创建成功）
     */
    @PostMapping("/operations")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_OPERATION_CREATE')")
    public int createOp(@RequestBody Operation op){
        return operationService.createOp(op);
    }

    /**
     * 修改权限
     * @param id 被修改的权限的ID
     * @param op 被修改的权限
     * @return 服务层返回的代码（1 表示修改成功）
     */
    @PatchMapping("/operations/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_OPERATION_UPDATE')")
    public int updateOp(@PathVariable("id") int id, @RequestBody Operation op){
        return operationService.updateOp(op);
    }

    /**
     * 删除权限
     * @param id 要被删除的权限ID
     * @return 服务层返回的代码（1 表示删除成功）
     */
    @DeleteMapping("/operations/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_OPERATION_DELETE')")
    public int deleteOp(@PathVariable("id") int id){
        return operationService.deleteOp(id);
    }
}
