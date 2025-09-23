package br.com.fiap.fichacompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.fichacompra.model.PurchaseRequest;
import java.util.Optional;

public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Long> {
    Optional<PurchaseRequest> findTopByOrderByIdDesc();
}
