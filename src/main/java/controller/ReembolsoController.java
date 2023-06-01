package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.ReembolsoService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/reembolso")
public class ReembolsoController {

    @Autowired
    ReembolsoService reembolsoService;

    @GetMapping(value = "/reembolso/")
    public ResponseEntity<Optional<?>> cadastrarReembolso(@RequestParam double valor) {
        return ResponseEntity.status(HttpStatus.OK).body(reembolsoService.criaReembolso(valor));
    }
}
