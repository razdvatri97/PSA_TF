package service;

import model.Reembolso;
import org.springframework.stereotype.Service;
import repository.ReembolsoRepositoryIT;

import java.util.Optional;

@Service
public class ReembolsoService implements ReembolsoServiceIT {

    ReembolsoRepositoryIT reembolsoRepositoryIT;

    @Override
    public Optional<Reembolso> save(Reembolso reembolso) {
        return Optional.of(reembolsoRepositoryIT.save(reembolso));
    }

    @Override
    public Optional<Reembolso> criaReembolso(double valor) {
        Reembolso reembolso = Reembolso.builder()
                .valor(valor)
                .build();

        return Optional.of(reembolsoRepositoryIT.save(reembolso));
    }
}
