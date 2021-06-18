package com.nie.service.impl;

import com.nie.mapper.OperationMapper;
import com.nie.pojo.Operation;
import com.nie.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OperationService")
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationMapper operationMapper;

    @Override
    public Operation queryOpByName(String opName) {
        return operationMapper.queryOpByName(opName);
    }

    @Override
    public Operation queryOpById(int id) {
        return operationMapper.queryOpById(id);
    }

    @Override
    public List<Operation> queryOpList() {
        return operationMapper.queryOpList();
    }

    @Override
    public int createOp(Operation op) {
        return operationMapper.createOp(op);
    }

    @Override
    public int updateOp(Operation op) {
        return operationMapper.updateOp(op);
    }

    @Override
    public int deleteOp(int id) {
        return operationMapper.deleteOp(id);
    }
}
