package com.kaibakorp.osworksapi.domain.persistence;

import com.kaibakorp.osworksapi.domain.entity.OSEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OSRepository extends JpaRepository<OSEntity,Long> {

}
