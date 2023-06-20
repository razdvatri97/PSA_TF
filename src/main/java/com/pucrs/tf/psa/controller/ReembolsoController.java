package com.pucrs.tf.psa.controller;

import com.pucrs.tf.psa.model.Reembolso;
import com.pucrs.tf.psa.repository.ReembolsoRepositorio;
import com.pucrs.tf.psa.service.ReembolsoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ReembolsoController {

    @Autowired
    ReembolsoService reembolsoService;

    @Autowired
    ReembolsoRepositorio repositorio;

    @RequestMapping(value = "reembolso/", method = POST)
    public ResponseEntity<?> cadastrarReembolso(@RequestParam String nome, @RequestParam double valor) {
        if (reembolsoService.valida(nome, valor)) {
            Reembolso reembolso = reembolsoService.criaReembolso(nome, valor);
            return ResponseEntity.ok(reembolso);
        }
        return ResponseEntity.status(BAD_REQUEST).body("Nome e/ou valor estão incorretos.");
    }


    @RequestMapping(value = "listarTodosReembolsos", method = GET)
    public ResponseEntity<Optional<?>> listarTodosReembolsos() {
        return ResponseEntity.status(OK).body(Optional.of(repositorio.findAll()));
    }


    @RequestMapping(value = "aprovarReembolso/", method = POST)
    public ResponseEntity<?> aprovarReembolso(@RequestParam Long id) {
        Optional<Reembolso> reembolsoOptional = repositorio.findById(id);
        if (reembolsoOptional.isPresent()) {
            Reembolso reembolsoAprovado = reembolsoService.aprovarReembolso(reembolsoOptional.get());
            return ResponseEntity.status(OK).body(reembolsoAprovado);
        } else {
            return ResponseEntity.status(NOT_FOUND).body("Reembolso não encontrado.");
        }
    }

    @RequestMapping(value = "gerarRelatorio/", method = GET)
    public ResponseEntity<Optional<?>> gerarRelatorio() {
        return ResponseEntity.status(OK).body(Optional.of(reembolsoService.gerarRelatorio()));
    }
}

