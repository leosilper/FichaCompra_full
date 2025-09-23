package br.com.fiap.fichacompra.service;

import org.springframework.stereotype.Service;
import br.com.fiap.fichacompra.model.PurchaseItem;
import br.com.fiap.fichacompra.repository.PurchaseRequestRepository;

@Service
public class PurchaseService {
    private final PurchaseRequestRepository repo;

    public PurchaseService(PurchaseRequestRepository repo) {
        this.repo = repo;
    }

    public String nextRequestNumber() {
        return "FC-" + repo.findTopByOrderByIdDesc().map(pr -> pr.getId() + 1).orElse(1L);
    }

    public String buildStandardDescription(PurchaseItem i) {
        String tipo = "TÊNIS"; // ou derive da categoria/linha
        String base = (tipo + " " + up(i.getBrand()) + " " + up(i.getModelName()) + " " + up(i.getColor())).trim();

        if (i.getGender() != null && !i.getGender().equalsIgnoreCase("UNISSEX")) {
            base += " - " + i.getGender().toUpperCase();
        }
        if (i.getCollection() != null && !i.getCollection().equalsIgnoreCase("PERMANENTE")) {
            base += " (" + labelFromCode(i.getCollection()) + ")";
        }
        return base;
    }

    private String up(String s) {
        return s == null ? "" : s.trim().toUpperCase().replaceAll("\\s+", " ");
    }

    private String labelFromCode(String code) {
        if (code == null) return "";
        return code.replace("_", " ").toUpperCase();
    }
}
