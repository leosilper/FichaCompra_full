package br.com.fiap.fichacompra.controller;

import br.com.fiap.fichacompra.model.*;
import br.com.fiap.fichacompra.repository.*;
import br.com.fiap.fichacompra.service.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/")
public class PurchaseController {

    private final LookupRepository lookupRepo;
    private final CustomerRepository customerRepo;
    private final PurchaseRequestRepository prRepo;
    private final PurchaseItemRepository itemRepo;
    private final PurchaseService purchaseService;

    public PurchaseController(LookupRepository lookupRepo, CustomerRepository customerRepo,
                              PurchaseRequestRepository prRepo, PurchaseItemRepository itemRepo,
                              PurchaseService purchaseService) {
        this.lookupRepo = lookupRepo;
        this.customerRepo = customerRepo;
        this.prRepo = prRepo;
        this.itemRepo = itemRepo;
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("requests", prRepo.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String form(Model model) {
        PurchaseRequest pr = PurchaseRequest.builder()
                .requestNumber(purchaseService.nextRequestNumber())
                .build();
        model.addAttribute("pr", pr);
        loadLookups(model);
        model.addAttribute("customers", customerRepo.findAll());
        return "form";
    }

    @PostMapping
    public String create(@ModelAttribute("pr") PurchaseRequest pr) {
        if (pr.getItems() != null) {
            for (PurchaseItem it : pr.getItems()) {
                it.setPurchaseRequest(pr);
                it.setStandardDescription(purchaseService.buildStandardDescription(it));
            }
        }
        prRepo.save(pr);
        return "redirect:/";
    }

    // Presets por cliente (AJAX)
    @GetMapping("/customers/{id}")
    @ResponseBody
    public Customer getCustomer(@PathVariable Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    // Subcoleção dependente da coleção (AJAX)
    @GetMapping("/subcollections")
    @ResponseBody
    public List<Lookup> subcollections(@RequestParam String parentCode) {
        return lookupRepo.findByTypeAndParentCodeAndActiveTrueOrderByLabelAsc("SUBCOLECAO", parentCode);
    }

    private void loadLookups(Model model) {
        model.addAttribute("destinos",       lookupRepo.findByTypeAndActiveTrueOrderByLabelAsc("DESTINO"));
        model.addAttribute("satelites",      lookupRepo.findByTypeAndActiveTrueOrderByLabelAsc("SATELITE"));
        model.addAttribute("conveniencias",  lookupRepo.findByTypeAndActiveTrueOrderByLabelAsc("CONVENIENCIA"));
        model.addAttribute("ciclos",         lookupRepo.findByTypeAndActiveTrueOrderByLabelAsc("CICLO"));
        model.addAttribute("generos",        lookupRepo.findByTypeAndActiveTrueOrderByLabelAsc("GENERO"));
        model.addAttribute("colecoes",       lookupRepo.findByTypeAndActiveTrueOrderByLabelAsc("COLECAO"));
    }
}
