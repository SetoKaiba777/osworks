package com.kaibakorp.osworksapi.domain.persistence;

import com.kaibakorp.osworksapi.domain.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    ClienteEntity findByEmail(String email);
}
