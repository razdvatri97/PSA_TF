package service;

import model.Reembolso;

import java.util.Optional;

public interface ReembolsoServiceIT {

    Optional<Reembolso> save(Reembolso reembolso);

    Optional<Reembolso> criaReembolso(double valor);

}
