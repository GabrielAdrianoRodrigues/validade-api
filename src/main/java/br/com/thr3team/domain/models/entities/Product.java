package br.com.thr3team.domain.models.entities;

import java.time.LocalDate;

import br.com.thr3team.domain.models.enums.ProductStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produtos")
@Data
@AllArgsConstructor@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "gtin", nullable = false)
    private Long gtin;

    @Column(name = "nm_product", nullable = false)
    private String name;

    @Column(name = "dt_expiration", nullable = false)
    private LocalDate expirationDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "st_product", nullable = false)
    private ProductStatus productStatus;

    @Column(name = "qt_product", nullable = true)
    private Integer amount;
}
