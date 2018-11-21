package ru.ajp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ajp.entity.ClientEntity;

/**
 * @author ajp
 * @date 22.11.2018
 */
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
