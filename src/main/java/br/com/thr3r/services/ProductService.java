package br.com.thr3r.services;

import java.util.List;
import java.util.stream.Collectors;

import br.com.thr3r.domain.daos.ProductDAO;
import br.com.thr3r.domain.models.dtos.ProductDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;

@ApplicationScoped
public class ProductService {
    @Inject
    private ProductDAO productDAO;

    public List<ProductDTO> findAll() throws Exception {
        return productDAO.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public ProductDTO findById(long id) throws Exception {
        return new ProductDTO(productDAO.findById(id).orElseThrow(EntityNotFoundException::new));
    }
}
