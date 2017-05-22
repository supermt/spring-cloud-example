package edu.uestc.msstudio.supermt.cloud.web.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public class UserDataExportController
{
    @GetMapping("/{id}")
    public HttpEntity<?> getUserByID(@PathVariable Long id)
    {
        
        return null;
    }
}