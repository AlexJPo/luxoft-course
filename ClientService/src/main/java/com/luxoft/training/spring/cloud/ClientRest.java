package com.luxoft.training.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientRest {
    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private ClientRepository repository;

    @RequestMapping(method = RequestMethod.GET, path = "/create")
    public ClientEntity create(@RequestParam(value = "name", name = "name") String name) {
        return clientDAO.create(name);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/update/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id, @RequestParam(value = "name") String name) {
        return new ResponseEntity(clientDAO.update(id, name) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id) {
        repository.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get")
    public List<ClientEntity> getAll() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get/{id}")
    public ClientEntity getById(@PathVariable(value = "id") Integer id) {
        return repository.findOne(id);
    }
}
