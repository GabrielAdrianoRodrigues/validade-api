package br.com.thr3team.domain.daos;

import br.com.thr3team.domain.models.entities.Product;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductDAO extends DAO<Product, Long>{}
