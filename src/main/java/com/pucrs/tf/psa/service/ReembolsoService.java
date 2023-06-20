package com.pucrs.tf.psa.service;

import com.pucrs.tf.psa.model.Reembolso;
import com.pucrs.tf.psa.repository.ReembolsoRepositoryIT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReembolsoService {

    ReembolsoRepositoryIT repository;

    public Optional<Reembolso> criaReembolso(String nome, double valor) {

        Reembolso reembolso = Reembolso.builder()
                .nome(nome)
                .valor(valor)
                .build();
        return Optional.of(repository.save(reembolso));

    }

    public boolean valida(String nome, double valor) {
        return valor != 0 && valor >= 0 && !nome.isBlank();
    }
}
