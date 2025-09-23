package br.com.fiap.fichacompra.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false) private String name;
    private String document;

    private String defaultDestination;
    private String defaultSatellite;
    private String defaultConvenience;
}
