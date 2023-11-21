package br.com.thr3team.domain.models.dtos;

import java.time.LocalDate;

import br.com.thr3team.domain.models.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class ProductDTO {
    private long gtin;
    private String name;
    private LocalDate expirationDate;
    private String productStatus;
    private int amount;

    public ProductDTO(Product product) {
        this.gtin = product.getGtin();
        this.name = product.getName();
        this.expirationDate = product.getExpirationDate();
        this.productStatus = product.getProductStatus().getDescription();
        this.amount = product.getAmount();
    }
}
