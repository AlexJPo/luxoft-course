package ru.ajp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ajp.entity.ClientEntity;
import ru.ajp.repository.ClientRepository;
import ru.ajp.service.ClientRepositoryImpl;

import java.util.List;

/**
 * @author ajp
 * @date 22.11.2018
 */
@RestController
public class ClientController {
    @Autowired
    private ClientRepositoryImpl clientRepository;

    @Autowired
    private ClientRepository repository;

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public ClientEntity create(@RequestParam(value = "name", name = "name") String name) {
        return clientRepository.create(name);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/update/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id, @RequestParam(value = "name") String name) {
        return new ResponseEntity(clientRepository.update(id, name) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id) {
        clientRepository.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get")
    public List<ClientEntity> getAll() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get/{id}")
    public ClientEntity getById(@PathVariable(value = "id") Integer id) {
        return clientRepository.findById(id);
    }
}
