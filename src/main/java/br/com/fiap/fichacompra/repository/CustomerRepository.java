package br.com.fiap.fichacompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.fichacompra.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }
