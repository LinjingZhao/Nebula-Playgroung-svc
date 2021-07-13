package com.accolade.nebula.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NebulaController {
    @Autowired
    private NebulaService nebulaService;

    @RequestMapping(value = "/id/{id}")
    public Nebula getById(@PathVariable(value ="id") int id){
        return nebulaService.getById(id);
    }
    @RequestMapping(value = "/nebula", method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Nebula nebula) {
        nebulaService.put(nebula);
        return new ResponseEntity<>("Nebula is created successfully", HttpStatus.CREATED);
    }
    @RequestMapping(value = "/test/{id}")
    public String test(@PathVariable(value ="id") int id){
        return String.format("Hello %s!", id);
    }

}
