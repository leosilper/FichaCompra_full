package br.com.fiap.fichacompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.fichacompra.model.PurchaseItem;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> { }
