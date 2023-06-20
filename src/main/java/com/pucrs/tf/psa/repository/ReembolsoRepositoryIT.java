package com.pucrs.tf.psa.repository;

import com.pucrs.tf.psa.model.Reembolso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReembolsoRepositoryIT extends CrudRepository<Reembolso, Integer> {
}
