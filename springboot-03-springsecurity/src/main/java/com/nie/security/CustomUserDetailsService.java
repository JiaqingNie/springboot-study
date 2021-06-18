package com.nie.security;

import com.nie.pojo.User;
import com.nie.service.RoleService;
import com.nie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.queryUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        Set<GrantedAuthority> authoritySet = new HashSet<>();

        Set<String> roleSet = user.getRoleSet();
        for (String role : roleSet) {
            authoritySet.add(new SimpleGrantedAuthority("ROLE_" + role));
            Set<String> operationSet = roleService.queryRoleByName(role).getOperationSet();
            for (String op : operationSet) {
                authoritySet.add(new SimpleGrantedAuthority("OP_" + op));
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authoritySet);
    }
}