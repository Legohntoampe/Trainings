package com.pluralstraining.conf_demo.controllers;


import com.pluralstraining.conf_demo.models.Session;
import com.pluralstraining.conf_demo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;
    @GetMapping
    public List<Session> List(){
        return sessionRepository.findAll();
        //RETURNS ALL THE SESSIONS
    }
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
        //GETTING SPECIFIC SESSION BY SESSION_ID
    }
    // postong to the table?
    @PostMapping
   // @ResponseStatus(HttpStatus.CREATED)//
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

}
