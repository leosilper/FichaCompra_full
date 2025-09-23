package br.com.fiap.fichacompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.fichacompra.model.Lookup;
import java.util.List;

public interface LookupRepository extends JpaRepository<Lookup, Long> {
    List<Lookup> findByTypeAndActiveTrueOrderByLabelAsc(String type);
    List<Lookup> findByTypeAndParentCodeAndActiveTrueOrderByLabelAsc(String type, String parentCode);
}
