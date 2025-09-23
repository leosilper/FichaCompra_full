package br.com.fiap.fichacompra.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PurchaseItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    private PurchaseRequest purchaseRequest;

    @Column(nullable=false) private String brand;
    @Column(nullable=false) private String modelName;
    @Column(nullable=false) private String color;

    @Column(nullable=false) private String gender;     // MASC, FEM, UNISSEX
    @Column(nullable=false) private String lifecycle;  // LANCAMENTO, COLECAO, PERMANENTE, DESCONTINUADO
    @Column(nullable=false) private String collection; // INVERNO_2026, VERAO_2026, PERMANENTE, OPORTUNIDADE

    private String subcollection;
    private String skuVendor;
    private String ean;
    private String sizeScale;
    private Double priceCost;
    private Double priceList;

    @Column(nullable=false)
    private String standardDescription;
}
