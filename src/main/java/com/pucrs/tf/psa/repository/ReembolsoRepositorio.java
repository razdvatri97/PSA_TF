package com.pucrs.tf.psa.repository;

import com.pucrs.tf.psa.model.Reembolso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReembolsoRepositorio extends JpaRepository<Reembolso, Long> {
    String findNomeById(Long id);

    double findValorById(Long id);
}
