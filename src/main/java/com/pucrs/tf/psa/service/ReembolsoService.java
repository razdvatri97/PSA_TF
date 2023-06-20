package com.pucrs.tf.psa.service;

import com.pucrs.tf.psa.model.Reembolso;
import com.pucrs.tf.psa.repository.ReembolsoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReembolsoService {

    @Autowired
    ReembolsoRepositorio repositorio;

    public Optional<Reembolso> criaReembolso(String nome, double valor) {

        Reembolso reembolso = Reembolso.builder()
                .nome(nome)
                .valor(valor)
                .aprovado(false)
                .build();
        return Optional.of(repositorio.save(reembolso));

    }

    public boolean valida(String nome, double valor) {
        return valor != 0 && valor >= 0 && !nome.isBlank();
    }

    public Optional<Reembolso> aprovarReembolso(Long id) {

        Reembolso reembolsoAprovado = Reembolso.builder()
                .nome(repositorio.findNomeById(id))
                .valor(repositorio.findValorById(id))
                .aprovado(true).build();

        return Optional.of(reembolsoAprovado);

    }

    public Optional<List<Reembolso>> gerarRelatorio() {
        return Optional.of(repositorio.findAllAprovados());
    }
}
