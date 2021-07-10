package com.kaibakorp.osworksapi.domain.persistence;

import com.kaibakorp.osworksapi.api.rpmodel.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
