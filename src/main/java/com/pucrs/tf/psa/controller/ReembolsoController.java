package com.pucrs.tf.psa.controller;

import com.pucrs.tf.psa.service.ReembolsoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ReembolsoController {

    @Autowired
    ReembolsoService reembolsoService;

    @RequestMapping(value = "reembolso/", method = RequestMethod.POST)
    public ResponseEntity<Optional<?>> cadastrarReembolso(@RequestParam String nome, @RequestParam double valor) {

        if (reembolsoService.valida(nome, valor)) {
            return ResponseEntity.status(HttpStatus.OK).body(reembolsoService.criaReembolso(nome, valor));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Optional.of("Nome e/ou valor estão incorretos."));
    }
}
