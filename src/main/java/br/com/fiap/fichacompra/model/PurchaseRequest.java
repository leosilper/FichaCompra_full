package br.com.fiap.fichacompra.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PurchaseRequest {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String requestNumber;

    @ManyToOne
    private Customer customer;

    private String destination;
    private String satellite;
    private String convenience;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status = Status.DRAFT;

    @Builder.Default
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @Builder.Default
    private OffsetDateTime updatedAt = OffsetDateTime.now();

    @OneToMany(mappedBy="purchaseRequest", cascade=CascadeType.ALL, orphanRemoval=true)
    @Builder.Default
    private List<PurchaseItem> items = new ArrayList<>();

    public enum Status { DRAFT, UNDER_REVIEW, APPROVED, REJECTED }
}
