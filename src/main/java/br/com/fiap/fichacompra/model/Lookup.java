package br.com.fiap.fichacompra.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Lookup {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false) private String type;   // DESTINO, SATELITE, CONVENIENCIA, CICLO, GENERO, COLECAO, SUBCOLECAO
    @Column(nullable=false) private String code;   // ex: INVERNO_2026
    @Column(nullable=false) private String label;  // ex: Inverno 2026

    private String parentCode;

    // ✅ Com Builder.Default para manter o valor ao usar o builder
    @Builder.Default
    private Boolean active = true;
}
