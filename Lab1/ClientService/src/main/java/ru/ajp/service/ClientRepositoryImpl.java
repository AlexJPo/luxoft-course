package ru.ajp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ajp.entity.ClientEntity;
import ru.ajp.repository.ClientRepository;

import java.util.List;

/**
 * @author ajp
 * @date 22.11.2018
 */
@Component
public class ClientRepositoryImpl {
    @Autowired
    private ClientRepository repository;

    /**
     * Создание клиента
     *
     * @param   name    имя клиента
     * @return          клиент
     */
    public ClientEntity create(final String name) {
        ClientEntity entity = new ClientEntity();
        entity.setName(name);
        return repository.save(entity);
    }

    /**
     * Обновление информации о клиенте
     *
     * @param   id      id клиента
     * @param   name    имя клиента
     * @return          true, если клиент был успешно обновлен, иначе false
     */
    public boolean update(final Integer id, final String name) {
        ClientEntity entity = repository.findOne(id);
        if (entity == null) {
            return false;
        }

        entity.setName(name);
        repository.save(entity);
        return true;
    }

    /**
     * Создание клиента
     *
     * @param id id клиента
     */
    public void delete(final Integer id) {
        repository.delete(id);
    }

    /**
     * Полученеи списка всех клиентов
     *
     * @return список клиентов
     */
    public List<ClientEntity> findAll() {
        return repository.findAll();
    }

    /**
     * Полученеи информации о клиенте по id
     *
     * @param   id  id клиента
     * @return      клиент
     */
    public ClientEntity findById(final Integer id) {
        return repository.findOne(id);
    }
}
