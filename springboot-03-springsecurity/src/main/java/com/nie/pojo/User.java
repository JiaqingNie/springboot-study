package com.nie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private Set<String> roleSet;

    public boolean hasRole(String role) {
        return roleSet != null && roleSet.contains(role);
    }
}
