package br.com.thr3r.domain.daos;

import br.com.thr3r.domain.models.entities.Product;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductDAO extends DAO<Product, Long>{}
