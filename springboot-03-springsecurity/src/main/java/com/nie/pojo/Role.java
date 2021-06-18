package com.nie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private int id;
    private String roleName;
    private Set<String> operationSet;
}
