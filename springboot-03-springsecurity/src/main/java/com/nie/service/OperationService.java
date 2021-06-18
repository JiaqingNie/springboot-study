package com.nie.service;

import com.nie.pojo.Operation;

import java.util.List;

public interface OperationService {

    Operation queryOpByName(String opName);

    Operation queryOpById(int id);

    List<Operation> queryOpList();

    int createOp(Operation op);

    int updateOp(Operation op);

    int deleteOp(int id);
}
