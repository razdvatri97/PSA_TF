package com.pucrs.tf.psa.repository;

import com.pucrs.tf.psa.model.Reembolso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReembolsoRepositorio extends JpaRepository<Reembolso, Long> {
    String findNomeById(Long id);

    double findValorById(Long id);

    @Query("SELECT r FROM Reembolso r WHERE r.aprovado = true")
    List<Reembolso> findAllAprovados();
}
