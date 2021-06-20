package com.nie.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping({"/", "/dashboard", "/dashboard.html"})
    public String showDashboard(){
        return "dashboard";
    }

    @GetMapping("/readme")
    public String showReadMe(){
        return "readme";
    }
}
