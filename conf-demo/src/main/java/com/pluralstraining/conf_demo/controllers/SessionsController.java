package com.pluralstraining.conf_demo.controllers;


import com.pluralstraining.conf_demo.models.Session;
import com.pluralstraining.conf_demo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
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

    @PostMapping
   // @ResponseStatus(HttpStatus.CREATED)//specifies the response we want
    public Session create(@RequestBody final Session session){
        //this method will create a new session if uyou pass a session info to the api endpoint
        return sessionRepository.saveAndFlush(session);
    }
    @RequestMapping(value="id",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //will need to check for children records before deleting
        //HOMEWORK:find and  put in loggic that allows the deleting of children records for session records in our db
        sessionRepository.deleteById(id);
    }
    @RequestMapping(value = "id",method = RequestMethod.PUT)
    public Session update(@PathVariable Long id,@RequestBody Session session){
        // NB: for updating we have 2 verbs we can use ie. PUT & PATCH,
        //PUT replaces all the attributes to be passed to the record
        //PATCH allows for the update to a portion of the attributes in the record
        //HOMEWORK: add validation that all attributes are passed in, otherwise return a 400 payload
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }

}
